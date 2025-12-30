package com.objectmodeling;
import java.util.ArrayList;
import java.util.Scanner;

public class University {

    String universityname;
    ArrayList<Department2D> departmentlist = new ArrayList<>();
    ArrayList<Faculty> facultylist = new ArrayList<>();

    University(String universityname) {
        this.universityname = universityname;
    }

    void addDepartment(Department2D department) {
        departmentlist.add(department);
    }

    void addFaculty(Faculty faculty) {
        facultylist.add(faculty);
    }

    void showUniversityDetails() {
        System.out.println("University: " + universityname);

        System.out.println("Departments:");
        for (Department2D department : departmentlist) {
            department.showDepartment();
        }

        System.out.println("Faculty Members:");
        for (Faculty faculty : facultylist) {
            faculty.showFaculty();
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        University university = new University("Tech University");

        Department2D cseDept = new Department2D("Computer Science");
        Department2D mechDept = new Department2D("Mechanical");

        Faculty faculty1 = new Faculty("Dr. Sharma");
        Faculty faculty2 = new Faculty("Prof. Verma");

        university.addDepartment(cseDept);
        university.addDepartment(mechDept);

        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        university.showUniversityDetails();

        // deleting university deletes departments
        university = null;
        System.out.println("University deleted");
        System.out.println("Departments are also deleted");

        // faculty can still exist independently
        faculty1.showFaculty();
        sc.close();
    }
}
