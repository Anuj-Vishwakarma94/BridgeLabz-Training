DDL

mysql> CREATE DATABASE HealthClinicDB;
Query OK, 1 row affected (0.03 sec)

mysql> USE HealthClinicDB;
Database changed

mysql> CREATE TABLE Doctor (
    ->     DoctorID INT AUTO_INCREMENT PRIMARY KEY,
    ->     FirstName VARCHAR(50) NOT NULL,
    ->     LastName VARCHAR(50) NOT NULL,
    ->     Specialization VARCHAR(100) NOT NULL,
    ->     Phone VARCHAR(15) UNIQUE,
    ->     CreatedOn DATETIME DEFAULT CURRENT_TIMESTAMP
    -> );
Query OK, 0 rows affected (0.07 sec)

mysql> ALTER TABLE Doctor ADD Email VARCHAR(100) UNIQUE;
Query OK, 0 rows affected (0.05 sec)
Records: 0  Duplicates: 0  Warnings: 0

DML

mysql> INSERT INTO Doctor (FirstName, LastName, Specialization, Phone)
    -> VALUES ('Anuj', 'Vishwakarma', 'Cardiology', '9876500001');
Query OK, 1 row affected (0.01 sec)

mysql> SELECT DoctorID, FirstName, LastName, Specialization
    -> FROM Doctor
    -> WHERE Specialization = 'Cardiology';
+----------+-----------+-------------+----------------+
| DoctorID | FirstName | LastName    | Specialization |
+----------+-----------+-------------+----------------+
|        1 | Anuj      | Vishwakarma | Cardiology     |
+----------+-----------+-------------+----------------+
1 row in set (0.00 sec)

mysql> UPDATE Doctor SET Phone = '9876500099' WHERE DoctorID = 1;
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> DELETE FROM Doctor WHERE DoctorID = 1;
Query OK, 1 row affected (0.00 sec)