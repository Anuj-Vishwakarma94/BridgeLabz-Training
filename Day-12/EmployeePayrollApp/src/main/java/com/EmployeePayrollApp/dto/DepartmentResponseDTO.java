package com.EmployeePayrollApp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Response payload representing department details")
public class DepartmentResponseDTO {

    @Schema(description = "Unique department ID", example = "1")
    private Long id;

    @Schema(description = "Name of the department", example = "Engineering")
    private String name;
}
