package com.EmployeePayrollApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI employeePayrollOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee Payroll REST API")
                        .description("RESTful API documentation for Employee Payroll Application managing employees, departments, and salary details.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Employee Payroll Support")
                                .email("support@employeepayroll.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
}
