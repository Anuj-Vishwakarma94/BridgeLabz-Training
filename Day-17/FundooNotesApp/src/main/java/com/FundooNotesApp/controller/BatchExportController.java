package com.FundooNotesApp.controller;

import com.FundooNotesApp.config.ExcelExportBatchConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping({"/api/batch/export", "/batch/export"})
public class BatchExportController {

    private static final Logger log = LoggerFactory.getLogger(BatchExportController.class);

    private final JobLauncher jobLauncher;
    private final Job exportNotesJob;

    public BatchExportController(JobLauncher jobLauncher, Job exportNotesJob) {
        this.jobLauncher = jobLauncher;
        this.exportNotesJob = exportNotesJob;
    }

    /**
     * Trigger Spring Batch job to export all notes into an Excel (.xlsx) file.
     * 
     * GET /api/batch/export/notes
     */
    @GetMapping("/notes")
    public ResponseEntity<?> exportNotesToExcel(@RequestParam(defaultValue = "false") boolean download) {
        try {
            // Delete pre-existing file to avoid duplicate/stale rows on re-run
            File oldFile = new File(ExcelExportBatchConfig.EXPORT_FILE_PATH);
            if (oldFile.exists()) {
                oldFile.delete();
            }

            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();

            log.info("[Spring Batch] Launching exportNotesJob...");
            JobExecution jobExecution = jobLauncher.run(exportNotesJob, jobParameters);

            File exportedFile = new File(ExcelExportBatchConfig.EXPORT_FILE_PATH);

            if (download && exportedFile.exists()) {
                Resource resource = new FileSystemResource(exportedFile);
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + exportedFile.getName())
                        .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                        .body(resource);
            }

            Map<String, Object> response = new HashMap<>();
            response.put("jobStatus", jobExecution.getStatus().toString());
            response.put("exitStatus", jobExecution.getExitStatus().getExitCode());
            response.put("filePath", exportedFile.getAbsolutePath());
            response.put("fileExists", exportedFile.exists());
            response.put("fileSizeBytes", exportedFile.exists() ? exportedFile.length() : 0);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            log.error("[Spring Batch Export Error]", e);
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to launch export batch job: " + e.getMessage());
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }
}
