package com.healthclinic.HealthClinicJDBC.service;

import java.util.List;

import com.healthclinic.HealthClinicJDBC.dao.DepartmentDAO;
import com.healthclinic.HealthClinicJDBC.model.Department;

public class DepartmentService {

    private DepartmentDAO departmentDAO = new DepartmentDAO();

    public boolean addDepartment(Department department) {
        return departmentDAO.addDepartment(department);
    }

    public List<Department> getAllDepartments() {
        return departmentDAO.getAllDepartments();
    }

    public Department getDepartmentById(int id) {
        return departmentDAO.getDepartmentById(id);
    }

    public boolean updateDepartment(Department department) {
        return departmentDAO.updateDepartment(department);
    }

    public boolean deleteDepartment(int id) {
        return departmentDAO.deleteDepartment(id);
    }
}