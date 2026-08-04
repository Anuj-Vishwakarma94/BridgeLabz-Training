SHOW DATABASES;

USE healthclinicdb;

SELECT * FROM Department;
SELECT * FROM Doctor;
SELECT * FROM Patient;
SELECT * FROM Appointment;

SELECT DoctorName, Specialization
FROM Doctor;

SELECT *
FROM Patient
WHERE Phone LIKE '98%';

SELECT *
FROM Appointment
WHERE AppointmentDate = '2026-08-10';

SELECT *
FROM Doctor
WHERE DepartmentID = 1;

SELECT DISTINCT AppointmentDate
FROM Appointment;

SELECT *
FROM Patient
WHERE PatientName LIKE '%uj%';

SELECT *
FROM Appointment
WHERE AppointmentDate > '2026-08-10';

SELECT COUNT(*) AS TotalDoctors
FROM Doctor;

SELECT PatientName
FROM Patient
ORDER BY PatientName;

SELECT D.DoctorName,
       DP.DepartmentName
FROM Doctor D
INNER JOIN Department DP
ON D.DepartmentID = DP.DepartmentID;

SELECT P.PatientName,
       A.AppointmentDate
FROM Appointment A
INNER JOIN Patient P
ON A.PatientID = P.PatientID
ORDER BY A.AppointmentDate, P.PatientName;

SELECT P.PatientName,
       D.DoctorName,
       A.AppointmentDate
FROM Appointment A
INNER JOIN Patient P
ON A.PatientID = P.PatientID
INNER JOIN Doctor D
ON A.DoctorID = D.DoctorID;

SELECT P.PatientName,
       D.DoctorName
FROM Appointment A
INNER JOIN Patient P
ON A.PatientID = P.PatientID
INNER JOIN Doctor D
ON A.DoctorID = D.DoctorID;

SELECT DP.DepartmentName,
       COUNT(D.DoctorID) AS TotalDoctors
FROM Department DP
LEFT JOIN Doctor D
ON DP.DepartmentID = D.DepartmentID
GROUP BY DP.DepartmentName;

SELECT DISTINCT
       P.PatientID,
       P.PatientName
FROM Patient P
INNER JOIN Appointment A
ON P.PatientID = A.PatientID;

SELECT D.DoctorID,
       D.DoctorName
FROM Doctor D
LEFT JOIN Appointment A
ON D.DoctorID = A.DoctorID
WHERE A.AppointmentID IS NULL;

SELECT D.DoctorName,
       COUNT(A.AppointmentID) AS TotalAppointments
FROM Doctor D
LEFT JOIN Appointment A
ON D.DoctorID = A.DoctorID
GROUP BY D.DoctorID, D.DoctorName;

SELECT DP.DepartmentName,
       COUNT(D.DoctorID) AS TotalDoctors
FROM Department DP
LEFT JOIN Doctor D
ON DP.DepartmentID = D.DepartmentID
GROUP BY DP.DepartmentID, DP.DepartmentName
ORDER BY TotalDoctors DESC
LIMIT 1;

SELECT P.PatientName,
       D.DoctorName,
       DP.DepartmentName,
       A.AppointmentDate
FROM Appointment A
INNER JOIN Patient P
ON A.PatientID = P.PatientID
INNER JOIN Doctor D
ON A.DoctorID = D.DoctorID
INNER JOIN Department DP
ON D.DepartmentID = DP.DepartmentID;

SELECT P.PatientName,
       D.DoctorName,
       A.AppointmentDate,
       A.TimeSlot
FROM Appointment A
INNER JOIN Patient P
ON A.PatientID = P.PatientID
INNER JOIN Doctor D
ON A.DoctorID = D.DoctorID;