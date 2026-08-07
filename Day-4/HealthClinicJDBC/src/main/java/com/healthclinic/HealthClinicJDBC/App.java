package com.healthclinic.HealthClinicJDBC;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

import com.healthclinic.HealthClinicJDBC.model.Appointment;
import com.healthclinic.HealthClinicJDBC.model.Department;
import com.healthclinic.HealthClinicJDBC.model.Doctor;
import com.healthclinic.HealthClinicJDBC.model.Patient;
import com.healthclinic.HealthClinicJDBC.service.AppointmentService;
import com.healthclinic.HealthClinicJDBC.service.DepartmentService;
import com.healthclinic.HealthClinicJDBC.service.DoctorService;
import com.healthclinic.HealthClinicJDBC.service.PatientService;
import java.sql.Timestamp;

import com.healthclinic.HealthClinicJDBC.model.Visit;
import com.healthclinic.HealthClinicJDBC.model.Billing;

import com.healthclinic.HealthClinicJDBC.service.VisitService;
import com.healthclinic.HealthClinicJDBC.service.BillingService;

public class App {

    static Scanner sc = new Scanner(System.in);

    static PatientService patientService = new PatientService();
    static DoctorService doctorService = new DoctorService();
    static DepartmentService departmentService = new DepartmentService();
    static AppointmentService appointmentService = new AppointmentService();
    static VisitService visitService = new VisitService();
    static BillingService billingService = new BillingService();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n========== HEALTH CLINIC ==========");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Department Management");
            System.out.println("4. Appointment Management");
            System.out.println("5. Visit Management");
            System.out.println("6. Billing Management");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    patientMenu();
                    break;

                case 2:
                    doctorMenu();
                    break;

                case 3:
                    departmentMenu();
                    break;

                case 4:
                    appointmentMenu();
                    break;

                case 5:
                    visitMenu();
                    break;

                case 6:
                    billingMenu();
                    break;

                case 7:
                    System.out.println("Application Closed");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    static void patientMenu() {

        System.out.println("\n----- PATIENT MENU -----");
        System.out.println("1. Add Patient");
        System.out.println("2. View All Patients");
        System.out.println("3. Search Patient");
        System.out.println("4. Update Patient");
        System.out.println("5. Delete Patient");
        System.out.print("Enter Choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Gender: ");
                String gender = sc.nextLine();

                System.out.print("Enter Phone: ");
                String phone = sc.nextLine();

                Patient patient = new Patient(
                        name,
                        age,
                        gender,
                        phone
                );

                if (patientService.addPatient(patient))
                    System.out.println("Patient Added Successfully");
                else
                    System.out.println("Patient Not Added");

                break;

            case 2:

                for (Patient p : patientService.getAllPatients()) {

                    System.out.println(
                            p.getPatientId() + " | " +
                            p.getName() + " | " +
                            p.getAge() + " | " +
                            p.getGender() + " | " +
                            p.getPhone()
                    );
                }

                break;

            case 3:

                System.out.print("Enter Patient ID: ");
                int id = sc.nextInt();

                Patient p = patientService.getPatientById(id);

                if (p != null) {

                    System.out.println(
                            p.getPatientId() + " | " +
                            p.getName() + " | " +
                            p.getAge() + " | " +
                            p.getGender() + " | " +
                            p.getPhone()
                    );

                } else {
                    System.out.println("Patient Not Found");
                }

                break;

            case 4:

                System.out.print("Enter Patient ID: ");
                int updateId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Name: ");
                String newName = sc.nextLine();

                System.out.print("Enter New Age: ");
                int newAge = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Gender: ");
                String newGender = sc.nextLine();

                System.out.print("Enter New Phone: ");
                String newPhone = sc.nextLine();

                Patient updatePatient = new Patient(
                        updateId,
                        newName,
                        newAge,
                        newGender,
                        newPhone
                );

                if (patientService.updatePatient(updatePatient))
                    System.out.println("Patient Updated Successfully");
                else
                    System.out.println("Patient Not Found");

                break;

            case 5:

                System.out.print("Enter Patient ID: ");
                int deleteId = sc.nextInt();

                if (patientService.deletePatient(deleteId))
                    System.out.println("Patient Deleted Successfully");
                else
                    System.out.println("Patient Not Found");

                break;

            default:
                System.out.println("Invalid Choice");
        }
    }

    static void doctorMenu() {

        System.out.println("\n----- DOCTOR MENU -----");
        System.out.println("1. Add Doctor");
        System.out.println("2. View All Doctors");
        System.out.println("3. Search Doctor");
        System.out.println("4. Update Doctor");
        System.out.println("5. Delete Doctor");
        System.out.print("Enter Choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:

                System.out.print("Enter Doctor Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Specialization: ");
                String specialization = sc.nextLine();

                System.out.print("Enter Phone: ");
                String phone = sc.nextLine();

                System.out.print("Enter Department ID: ");
                int departmentId = sc.nextInt();

                Doctor doctor = new Doctor(
                        name,
                        specialization,
                        phone,
                        departmentId
                );

                if (doctorService.addDoctor(doctor))
                    System.out.println("Doctor Added Successfully");
                else
                    System.out.println("Doctor Not Added");

                break;

            case 2:

                for (Doctor d : doctorService.getAllDoctors()) {

                    System.out.println(
                            d.getDoctorId() + " | " +
                            d.getDoctorName() + " | " +
                            d.getSpecialization() + " | " +
                            d.getPhone() + " | Department ID: " +
                            d.getDepartmentId()
                    );
                }

                break;

            case 3:

                System.out.print("Enter Doctor ID: ");
                int id = sc.nextInt();

                Doctor d = doctorService.getDoctorById(id);

                if (d != null) {

                    System.out.println(
                            d.getDoctorId() + " | " +
                            d.getDoctorName() + " | " +
                            d.getSpecialization() + " | " +
                            d.getPhone() + " | Department ID: " +
                            d.getDepartmentId()
                    );

                } else {
                    System.out.println("Doctor Not Found");
                }

                break;

            case 4:

                System.out.print("Enter Doctor ID: ");
                int updateId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Name: ");
                String newName = sc.nextLine();

                System.out.print("Enter New Specialization: ");
                String newSpecialization = sc.nextLine();

                System.out.print("Enter New Phone: ");
                String newPhone = sc.nextLine();

                System.out.print("Enter New Department ID: ");
                int newDepartmentId = sc.nextInt();

                Doctor updateDoctor = new Doctor(
                        updateId,
                        newName,
                        newSpecialization,
                        newPhone,
                        newDepartmentId
                );

                if (doctorService.updateDoctor(updateDoctor))
                    System.out.println("Doctor Updated Successfully");
                else
                    System.out.println("Doctor Not Found");

                break;

            case 5:

                System.out.print("Enter Doctor ID: ");
                int deleteId = sc.nextInt();

                if (doctorService.deleteDoctor(deleteId))
                    System.out.println("Doctor Deleted Successfully");
                else
                    System.out.println("Doctor Not Found");

                break;

            default:
                System.out.println("Invalid Choice");
        }
    }

    static void departmentMenu() {

        System.out.println("\n----- DEPARTMENT MENU -----");
        System.out.println("1. Add Department");
        System.out.println("2. View All Departments");
        System.out.println("3. Update Department");
        System.out.println("4. Delete Department");
        System.out.print("Enter Choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:

                System.out.print("Enter Department Name: ");
                String name = sc.nextLine();

                Department department = new Department(name);

                if (departmentService.addDepartment(department))
                    System.out.println("Department Added Successfully");
                else
                    System.out.println("Department Not Added");

                break;

            case 2:

                for (Department d :
                        departmentService.getAllDepartments()) {

                    System.out.println(
                            d.getDepartmentId() + " | " +
                            d.getDepartmentName()
                    );
                }

                break;

            case 3:

                System.out.print("Enter Department ID: ");
                int updateId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Department Name: ");
                String newName = sc.nextLine();

                Department updateDepartment =
                        new Department(updateId, newName);

                if (departmentService.updateDepartment(updateDepartment))
                    System.out.println("Department Updated Successfully");
                else
                    System.out.println("Department Not Found");

                break;

            case 4:

                System.out.print("Enter Department ID: ");
                int deleteId = sc.nextInt();

                if (departmentService.deleteDepartment(deleteId))
                    System.out.println("Department Deleted Successfully");
                else
                    System.out.println("Department Not Found");

                break;

            default:
                System.out.println("Invalid Choice");
        }
    }

    static void appointmentMenu() {

        System.out.println("\n----- APPOINTMENT MENU -----");
        System.out.println("1. Book Appointment");
        System.out.println("2. View All Appointments");
        System.out.println("3. Update Status");
        System.out.println("4. Delete Appointment");
        System.out.print("Enter Choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:

                System.out.print("Enter Patient ID: ");
                int patientId = sc.nextInt();

                System.out.print("Enter Doctor ID: ");
                int doctorId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Date (YYYY-MM-DD): ");
                Date date = Date.valueOf(sc.nextLine());

                System.out.print("Enter Time (HH:MM:SS): ");
                Time time = Time.valueOf(sc.nextLine());

                System.out.print("Enter Status: ");
                String status = sc.nextLine();

                Appointment appointment = new Appointment(
                        patientId,
                        doctorId,
                        date,
                        time,
                        status
                );

                if (appointmentService.addAppointment(appointment))
                    System.out.println("Appointment Booked Successfully");
                else
                    System.out.println("Appointment Not Booked");

                break;

            case 2:

                for (Appointment a :
                        appointmentService.getAllAppointments()) {

                    System.out.println(
                            a.getAppointmentId() +
                            " | Patient ID: " + a.getPatientId() +
                            " | Doctor ID: " + a.getDoctorId() +
                            " | Date: " + a.getAppointmentDate() +
                            " | Time: " + a.getAppointmentTime() +
                            " | Status: " + a.getStatus()
                    );
                }

                break;

            case 3:

                System.out.print("Enter Appointment ID: ");
                int appointmentId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Status: ");
                String newStatus = sc.nextLine();

                if (appointmentService.updateStatus(
                        appointmentId,
                        newStatus))
                    System.out.println("Status Updated Successfully");
                else
                    System.out.println("Appointment Not Found");

                break;

            case 4:

                System.out.print("Enter Appointment ID: ");
                int deleteId = sc.nextInt();

                if (appointmentService.deleteAppointment(deleteId))
                    System.out.println("Appointment Deleted Successfully");
                else
                    System.out.println("Appointment Not Found");

                break;

            default:
                System.out.println("Invalid Choice");       
        }
    }
    static void visitMenu() {

        System.out.println("\n----- VISIT MENU -----");
        System.out.println("1. Add Visit");
        System.out.println("2. View All Visits");
        System.out.println("3. Search Visit");
        System.out.println("4. Update Visit");
        System.out.println("5. Delete Visit");
        System.out.print("Enter Choice : ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch(choice) {

        case 1:

            System.out.print("Appointment ID : ");
            int appointmentId = sc.nextInt();
            sc.nextLine();

            System.out.print("Diagnosis : ");
            String diagnosis = sc.nextLine();

            Visit visit = new Visit(
                    appointmentId,
                    new Timestamp(System.currentTimeMillis()),
                    diagnosis);

            if(visitService.addVisit(visit))
                System.out.println("Visit Added Successfully");
            else
                System.out.println("Visit Not Added");

            break;

        case 2:

            visitService.viewVisitDetails();

            break;

        case 3:

            System.out.print("Visit ID : ");
            int visitId = sc.nextInt();

            Visit v = visitService.getVisitById(visitId);

            if(v != null) {

                System.out.println(
                        v.getVisitId()+" | "+
                        v.getAppointmentId()+" | "+
                        v.getVisitDate()+" | "+
                        v.getDiagnosis());

            } else {

                System.out.println("Visit Not Found");

            }

            break;

        case 4:

            System.out.print("Visit ID : ");
            int updateId = sc.nextInt();
            sc.nextLine();

            System.out.print("Appointment ID : ");
            int appId = sc.nextInt();
            sc.nextLine();

            System.out.print("Diagnosis : ");
            String newDiagnosis = sc.nextLine();

            Visit updateVisit = new Visit(
                    updateId,
                    appId,
                    new Timestamp(System.currentTimeMillis()),
                    newDiagnosis);

            if(visitService.updateVisit(updateVisit))
                System.out.println("Visit Updated Successfully");
            else
                System.out.println("Visit Not Found");

            break;

        case 5:

            System.out.print("Visit ID : ");
            int deleteId = sc.nextInt();

            if(visitService.deleteVisit(deleteId))
                System.out.println("Visit Deleted Successfully");
            else
                System.out.println("Visit Not Found");

            break;

        default:
            System.out.println("Invalid Choice");

        }

    }
    static void billingMenu() {

        System.out.println("\n----- BILLING MENU -----");
        System.out.println("1. Generate Bill");
        System.out.println("2. View Bills");
        System.out.println("3. Search Bill");
        System.out.println("4. Update Bill");
        System.out.println("5. Delete Bill");
        System.out.print("Enter Choice : ");

        int choice = sc.nextInt();

        switch(choice) {

        case 1:

            System.out.print("Appointment ID : ");
            int appointmentId = sc.nextInt();

            System.out.print("Consultation Fee : ");
            double consultation = sc.nextDouble();

            System.out.print("Medicine Charge : ");
            double medicine = sc.nextDouble();

            System.out.print("Test Charge : ");
            double test = sc.nextDouble();

            sc.nextLine();

            System.out.print("Payment Status : ");
            String payment = sc.nextLine();

            Billing bill = new Billing(
                    appointmentId,
                    consultation,
                    medicine,
                    test,
                    0,
                    payment);

            if(billingService.addBill(bill))
                System.out.println("Bill Generated Successfully");
            else
                System.out.println("Bill Generation Failed");

            break;

        case 2:

            for(Billing b : billingService.getAllBills()) {

                System.out.println(
                        b.getBillId()+" | "+
                        b.getAppointmentId()+" | "+
                        b.getConsultationFee()+" | "+
                        b.getMedicineCharge()+" | "+
                        b.getTestCharge()+" | "+
                        b.getTotalAmount()+" | "+
                        b.getPaymentStatus());

            }

            break;

        case 3:

            System.out.print("Bill ID : ");
            int billId = sc.nextInt();

            Billing b = billingService.getBillById(billId);

            if(b != null) {

                System.out.println(
                        b.getBillId()+" | "+
                        b.getAppointmentId()+" | "+
                        b.getConsultationFee()+" | "+
                        b.getMedicineCharge()+" | "+
                        b.getTestCharge()+" | "+
                        b.getTotalAmount()+" | "+
                        b.getPaymentStatus());

            } else {

                System.out.println("Bill Not Found");

            }

            break;

        case 4:

            System.out.print("Bill ID : ");
            int updateBillId = sc.nextInt();

            System.out.print("Appointment ID : ");
            int appId = sc.nextInt();

            System.out.print("Consultation Fee : ");
            double consultationFee = sc.nextDouble();

            System.out.print("Medicine Charge : ");
            double medicineCharge = sc.nextDouble();

            System.out.print("Test Charge : ");
            double testCharge = sc.nextDouble();

            sc.nextLine();

            System.out.print("Payment Status : ");
            String paymentStatus = sc.nextLine();

            Billing updateBill = new Billing(
                    updateBillId,
                    appId,
                    consultationFee,
                    medicineCharge,
                    testCharge,
                    0,
                    paymentStatus);

            if(billingService.updateBill(updateBill))
                System.out.println("Bill Updated Successfully");
            else
                System.out.println("Bill Not Found");

            break;

        case 5:

            System.out.print("Bill ID : ");
            int deleteId = sc.nextInt();

            if(billingService.deleteBill(deleteId))
                System.out.println("Bill Deleted Successfully");
            else
                System.out.println("Bill Not Found");

            break;

        default:
            System.out.println("Invalid Choice");

        }

    }
}