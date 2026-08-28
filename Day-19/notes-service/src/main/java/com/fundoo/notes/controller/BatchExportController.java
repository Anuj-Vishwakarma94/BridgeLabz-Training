package com.fundoo.notes.controller;

import com.fundoo.notes.config.ExcelExportBatchConfig;
import com.fundoo.notes.dto.response.ApiResponse;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/batch", "/api/batch"})
public class BatchExportController {

    private final JobLauncher jobLauncher;
    private final Job exportNotesJob;

    public BatchExportController(JobLauncher jobLauncher, Job exportNotesJob) {
        this.jobLauncher = jobLauncher;
        this.exportNotesJob = exportNotesJob;
    }

    @PostMapping("/export-excel")
    public ResponseEntity<ApiResponse<String>> exportNotesToExcel() {
        try {
            JobParameters params = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(exportNotesJob, params);
            return ResponseEntity.ok(ApiResponse.success("Notes Excel export job triggered successfully", ExcelExportBatchConfig.EXPORT_FILE_PATH));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(ApiResponse.error("Export job failed: " + e.getMessage()));
        }
    }
}
