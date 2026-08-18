package com.EmployeePayrollApp.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Response payload representing employee details")
public class EmployeeResponseDTO {

    @Schema(description = "Unique employee ID", example = "1")
    private Long id;

    @Schema(description = "Full name of the employee", example = "John Doe")
    private String name;

    @Schema(description = "Email address of the employee", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Phone number of the employee", example = "9876543210")
    private String phone;

    @Schema(description = "Monthly salary of the employee", example = "75000.00")
    private BigDecimal salary;

    @Schema(description = "ID of the assigned department", example = "1")
    private Long departmentId;
}
