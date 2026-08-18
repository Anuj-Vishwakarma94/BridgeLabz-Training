package com.EmployeePayrollApp.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Request payload for creating or updating an employee")
public class EmployeeRequestDTO {

    @Schema(description = "Full name of the employee", example = "John Doe", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @Schema(description = "Email address of the employee", example = "john.doe@example.com", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Schema(description = "Phone number of the employee", example = "9876543210", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Phone is required")
    @Size(min = 10, max = 15, message = "Phone must be between 10 and 15 characters")
    private String phone;

    @Schema(description = "Monthly salary of the employee", example = "75000.00", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be greater than zero")
    private BigDecimal salary;

    @Schema(description = "ID of the assigned department", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Department ID is required")
    @Positive(message = "Department ID must be greater than zero")
    private Long departmentId;
}
