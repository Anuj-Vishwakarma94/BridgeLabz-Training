mysql> CREATE DATABASE IF NOT EXISTS health_clinic;
Query OK, 1 row affected (0.00 sec)

mysql> Use health_clinic;
Database changed
mysql> CREATE TABLE patient (
    ->     patient_id INT PRIMARY KEY AUTO_INCREMENT,
    ->     name       VARCHAR(100) NOT NULL,
    ->     phone      VARCHAR(15),
    ->     dob        DATE
    -> );
Query OK, 0 rows affected (0.03 sec)

mysql> CREATE TABLE doctor (
    ->     doctor_id  INT PRIMARY KEY AUTO_INCREMENT,
    ->     name       VARCHAR(100) NOT NULL,
    ->     specialty  VARCHAR(50)
    -> );
Query OK, 0 rows affected (0.01 sec)

mysql> CREATE TABLE appointment (
    ->     appointment_id    INT PRIMARY KEY AUTO_INCREMENT,
    ->     patient_id        INT NOT NULL,
    ->     doctor_id         INT NOT NULL,
    ->     appointment_date  DATETIME NOT NULL,
    ->     status             VARCHAR(20) DEFAULT 'Scheduled',
    ->     FOREIGN KEY (patient_id) REFERENCES patient(patient_id),
    ->     FOREIGN KEY (doctor_id)  REFERENCES doctor(doctor_id)
    -> );
Query OK, 0 rows affected (0.04 sec)

mysql> INSERT INTO patient (name, phone, dob) VALUES('Anuj','9876543210','2004-07-28'),('Aryan','0123456789','2004-10-18'),('Vaidik','7418529630','2004-02-09');
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> INSERT INTO doctor (name, specialty) VALUES ('Dr. Andrew',  'Cardiology'),('Dr. Tristan',  'Orthopedic');
Query OK, 2 rows affected (0.01 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql> INSERT INTO appointment (patient_id, doctor_id, appointment_date, status) VALUES
    ->     (1, 1, '2026-08-05 10:00:00', 'Scheduled'),
    ->     (1, 2, '2026-08-06 11:30:00', 'Scheduled'),
    ->     (2, 1, '2026-08-07 09:00:00', 'Scheduled');
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> SELECT p.name AS patient, d.name AS doctor, a.appointment_date
    -> FROM appointment a
    -> JOIN patient p ON a.patient_id = p.patient_id
    -> JOIN doctor d  ON a.doctor_id  = d.doctor_id
    -> ORDER BY a.appointment_date;
+---------+-------------+---------------------+
| patient | doctor      | appointment_date    |
+---------+-------------+---------------------+
| Anuj    | Dr. Andrew  | 2026-08-05 10:00:00 |
| Anuj    | Dr. Tristan | 2026-08-06 11:30:00 |
| Aryan   | Dr. Andrew  | 2026-08-07 09:00:00 |
+---------+-------------+---------------------+
3 rows in set (0.00 sec)

mysql> CREATE TABLE appointment_bad (
    ->     appt_id           INT PRIMARY KEY AUTO_INCREMENT,
    ->     patient_name      VARCHAR(100),
    ->     patient_phone     VARCHAR(15),
    ->     doctor_name       VARCHAR(100),
    ->     doctor_specialty  VARCHAR(50),
    ->     appt_date         DATETIME
    -> );
Query OK, 0 rows affected (0.04 sec)

mysql> INSERT INTO appointment_bad
    ->     (patient_name, patient_phone, doctor_name, doctor_specialty, appt_date) VALUES
    ->     ('Anuj',  '9876543210', 'Dr. Andrew',  'Cardiology', '2026-08-05 10:00:00'),
    ->     ('Anuj',  '9876543210', 'Dr. Tristan', 'Orthopedic', '2026-08-06 11:30:00'),
    ->     ('Aryan', '0123456789', 'Dr. Andrew',  'Cardiology', '2026-08-07 09:00:00');
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM appointment_bad;
+---------+--------------+---------------+-------------+------------------+---------------------+
| appt_id | patient_name | patient_phone | doctor_name | doctor_specialty | appt_date           |
+---------+--------------+---------------+-------------+------------------+---------------------+
|       1 | Anuj         | 9876543210    | Dr. Andrew  | Cardiology       | 2026-08-05 10:00:00 |
|       2 | Anuj         | 9876543210    | Dr. Tristan | Orthopedic       | 2026-08-06 11:30:00 |
|       3 | Aryan        | 0123456789    | Dr. Andrew  | Cardiology       | 2026-08-07 09:00:00 |
+---------+--------------+---------------+-------------+------------------+---------------------+
3 rows in set (0.00 sec)

mysql> UPDATE appointment_bad
    -> SET patient_phone = '9999999999'
    -> WHERE patient_name = 'Anuj';
Query OK, 2 rows affected (0.04 sec)
Rows matched: 2  Changed: 2  Warnings: 0

mysql> SELECT ROW_COUNT();
+-------------+
| ROW_COUNT() |
+-------------+
|           2 |
+-------------+
1 row in set (0.00 sec)

mysql> UPDATE patient
    -> SET phone = '9999999999'
    -> WHERE name = 'Anuj';
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> SELECT ROW_COUNT();
+-------------+
| ROW_COUNT() |
+-------------+
|           1 |
+-------------+
1 row in set (0.00 sec)

mysql> SELECT * FROM patient;
+------------+--------+------------+------------+
| patient_id | name   | phone      | dob        |
+------------+--------+------------+------------+
|          1 | Anuj   | 9999999999 | 2004-07-28 |
|          2 | Aryan  | 0123456789 | 2004-10-18 |
|          3 | Vaidik | 7418529630 | 2004-02-09 |
+------------+--------+------------+------------+
3 rows in set (0.00 sec)

mysql> ALTER TABLE doctor
    -> ADD COLUMN department_name VARCHAR(50);
Query OK, 0 rows affected (0.08 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> UPDATE doctor
    -> SET department_name = 'Cardiology Dept'
    -> WHERE specialty = 'Cardiology';
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> UPDATE doctor
    -> SET department_name = 'Ortho Dept'
    -> WHERE specialty = 'Orthopedic';
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> SELECT * FROM doctor;
+-----------+-------------+------------+-----------------+
| doctor_id | name        | specialty  | department_name |
+-----------+-------------+------------+-----------------+
|         1 | Dr. Andrew  | Cardiology | Cardiology Dept |
|         2 | Dr. Tristan | Orthopedic | Ortho Dept      |
+-----------+-------------+------------+-----------------+
2 rows in set (0.00 sec)

mysql> ALTER TABLE doctor
    -> DROP COLUMN department_name;
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> CREATE TABLE department (
    ->     department_id INT PRIMARY KEY AUTO_INCREMENT,
    ->     department_name VARCHAR(50) NOT NULL
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> ALTER TABLE doctor
    -> ADD COLUMN department_id INT;
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> ALTER TABLE doctor
    -> ADD FOREIGN KEY (department_id)
    -> REFERENCES department(department_id);
Query OK, 2 rows affected (0.05 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql> INSERT INTO department (department_name)
    -> VALUES
    -> ('Cardiology Dept'),
    -> ('Ortho Dept');
Query OK, 2 rows affected (0.01 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql> UPDATE doctor
    -> SET department_id = 1
    -> WHERE specialty = 'Cardiology';
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> UPDATE doctor
    -> SET department_id = 2
    -> WHERE specialty = 'Orthopedic';
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> UPDATE department
    -> SET department_name = 'Cardiology Department'
    -> WHERE department_id = 1;
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> SELECT d.name,
    ->        d.specialty,
    ->        dep.department_name
    -> FROM doctor d
    -> JOIN department dep
    -> ON d.department_id = dep.department_id;
+-------------+------------+-----------------------+
| name        | specialty  | department_name       |
+-------------+------------+-----------------------+
| Dr. Andrew  | Cardiology | Cardiology Department |
| Dr. Tristan | Orthopedic | Ortho Dept            |
+-------------+------------+-----------------------+
2 rows in set (0.00 sec)

mysql> DELIMITER $$
mysql> CREATE PROCEDURE seed_appointments(IN n INT)
    -> BEGIN
    ->     DECLARE i INT DEFAULT 0;
    ->
    ->     WHILE i < n DO
    ->         INSERT INTO appointment
    ->         (patient_id, doctor_id, appointment_date, status)
    ->         VALUES
    ->         (
    ->             1 + FLOOR(RAND() * 2),
    ->             1 + FLOOR(RAND() * 2),
    ->             DATE_ADD('2026-01-01', INTERVAL FLOOR(RAND() * 365) DAY),
    ->             'Scheduled'
    ->         );
    ->
    ->         SET i = i + 1;
    ->     END WHILE;
    -> END$$
Query OK, 0 rows affected (0.04 sec)

mysql> DELIMITER ;
mysql> CALL seed_appointments(50000);
Query OK, 1 row affected (38.09 sec)

mysql> EXPLAIN
    -> SELECT *
    -> FROM appointment
    -> WHERE patient_id = 1;
+----+-------------+-------------+------------+------+---------------+------------+---------+-------+-------+----------+-------+
| id | select_type | table       | partitions | type | possible_keys | key        | key_len | ref   | rows  | filtered | Extra |
+----+-------------+-------------+------------+------+---------------+------------+---------+-------+-------+----------+-------+
|  1 | SIMPLE      | appointment | NULL       | ref  | patient_id    | patient_id | 4       | const | 25102 |   100.00 | NULL  |
+----+-------------+-------------+------------+------+---------------+------------+---------+-------+-------+----------+-------+
1 row in set, 1 warning (0.01 sec)

mysql> CREATE INDEX idx_appointment_patient
    -> ON appointment(patient_id);
Query OK, 0 rows affected (0.10 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> EXPLAIN
    -> SELECT *
    -> FROM appointment
    -> WHERE doctor_id = 1
    -> AND appointment_date > '2026-06-01';
+----+-------------+-------------+------------+------+---------------+-----------+---------+-------+-------+----------+-------------+
| id | select_type | table       | partitions | type | possible_keys | key       | key_len | ref   | rows  | filtered | Extra       |
+----+-------------+-------------+------------+------+---------------+-----------+---------+-------+-------+----------+-------------+
|  1 | SIMPLE      | appointment | NULL       | ref  | doctor_id     | doctor_id | 4       | const | 25102 |    33.33 | Using where |
+----+-------------+-------------+------------+------+---------------+-----------+---------+-------+-------+----------+-------------+
1 row in set, 1 warning (0.00 sec)

mysql> CREATE INDEX idx_doctor_date
    -> ON appointment(doctor_id, appointment_date);
Query OK, 0 rows affected (0.10 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> EXPLAIN
    -> SELECT *
    -> FROM appointment
    -> WHERE doctor_id = 1
    -> AND appointment_date > '2026-06-01';
+----+-------------+-------------+------------+------+-----------------+------+---------+------+-------+----------+-------------+
| id | select_type | table       | partitions | type | possible_keys   | key  | key_len | ref  | rows  | filtered | Extra       |
+----+-------------+-------------+------------+------+-----------------+------+---------+------+-------+----------+-------------+
|  1 | SIMPLE      | appointment | NULL       | ALL  | idx_doctor_date | NULL | NULL    | NULL | 50204 |    50.00 | Using where |
+----+-------------+-------------+------------+------+-----------------+------+---------+------+-------+----------+-------------+
1 row in set, 1 warning (0.00 sec)

