package com.fundoo.notes.config;

import com.fundoo.notes.dto.NoteExcelRowDto;
import com.fundoo.notes.entity.Note;
import com.fundoo.notes.repository.NoteRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.PlatformTransactionManager;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Collections;

@Configuration
public class ExcelExportBatchConfig {

    public static final String EXPORT_FILE_PATH = "exports/notes_export.xlsx";

    private final NoteRepository noteRepository;

    public ExcelExportBatchConfig(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Bean
    public RepositoryItemReader<Note> noteItemReader() {
        return new RepositoryItemReaderBuilder<Note>()
                .name("noteItemReader")
                .repository(noteRepository)
                .methodName("findAll")
                .pageSize(10)
                .sorts(Collections.singletonMap("noteId", Sort.Direction.ASC))
                .build();
    }

    @Bean
    public ItemProcessor<Note, NoteExcelRowDto> noteItemProcessor() {
        return note -> new NoteExcelRowDto(
                note.getNoteId(),
                note.getTitle(),
                note.getContent(),
                note.getCreatedAt(),
                note.isPinned(),
                note.isArchived(),
                note.isTrashed(),
                note.getReminderAt(),
                note.getLabels() != null ? note.getLabels().toString() : ""
        );
    }

    @Bean
    public ItemWriter<NoteExcelRowDto> excelItemWriter() {
        return chunk -> {
            File exportFile = new File(EXPORT_FILE_PATH);
            if (exportFile.getParentFile() != null) {
                exportFile.getParentFile().mkdirs();
            }

            Workbook workbook;
            Sheet sheet;
            if (exportFile.exists() && exportFile.length() > 0) {
                try (java.io.InputStream is = new java.io.FileInputStream(exportFile)) {
                    workbook = new XSSFWorkbook(is);
                    sheet = workbook.getSheet("Notes Export");
                    if (sheet == null) {
                        sheet = workbook.createSheet("Notes Export");
                        createHeaderRow(sheet);
                    }
                }
            } else {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Notes Export");
                createHeaderRow(sheet);
            }

            int lastRowNum = sheet.getLastRowNum();
            for (NoteExcelRowDto dto : chunk.getItems()) {
                Row row = sheet.createRow(++lastRowNum);
                row.createCell(0).setCellValue(dto.getNoteId() != null ? dto.getNoteId() : 0);
                row.createCell(1).setCellValue(dto.getTitle() != null ? dto.getTitle() : "");
                row.createCell(2).setCellValue(dto.getContent() != null ? dto.getContent() : "");
                row.createCell(3).setCellValue(dto.isPinned() ? "Yes" : "No");
                row.createCell(4).setCellValue(dto.isArchived() ? "Yes" : "No");
                row.createCell(5).setCellValue(dto.isTrashed() ? "Yes" : "No");
                row.createCell(6).setCellValue(dto.getCreatedAt() != null ? dto.getCreatedAt().toString() : "");
            }

            try (FileOutputStream fos = new FileOutputStream(exportFile)) {
                workbook.write(fos);
            }
            workbook.close();
        };
    }

    private void createHeaderRow(Sheet sheet) {
        Row header = sheet.createRow(0);
        String[] headers = {"Note ID", "Title", "Content", "Pinned", "Archived", "Trashed", "Created At"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = header.createCell(i);
            cell.setCellValue(headers[i]);
        }
    }

    @Bean
    public Step exportNotesStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("exportNotesStep", jobRepository)
                .<Note, NoteExcelRowDto>chunk(10, transactionManager)
                .reader(noteItemReader())
                .processor(noteItemProcessor())
                .writer(excelItemWriter())
                .build();
    }

    @Bean
    public Job exportNotesJob(JobRepository jobRepository, Step exportNotesStep) {
        return new JobBuilder("exportNotesJob", jobRepository)
                .start(exportNotesStep)
                .build();
    }
}
