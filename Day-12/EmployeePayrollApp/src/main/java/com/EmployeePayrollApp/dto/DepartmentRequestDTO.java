package com.EmployeePayrollApp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Request payload for creating or updating a department")
public class DepartmentRequestDTO {

    @Schema(description = "Name of the department", example = "Engineering", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Department name is required")
    @Size(min = 2, max = 100, message = "Department name must be between 2 and 100 characters")
    private String name;
}
