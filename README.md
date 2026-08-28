# 🚀 BridgeLabz Refresher Training

> A repository documenting my learning journey during the **BridgeLabz Refresher Training Program**, covering database fundamentals, Java backend development, and hands-on projects.

---

## 📘 Training Overview

Throughout this training, I explored core backend technologies by learning concepts, solving practice problems, and implementing real-world applications. Each day's work is organized into separate folders for easy navigation.

---

## 📅 Learning Milestones

| Day    | Date   | Topics                                                                         | Coverage                                                                                                                         |
| ------ | ------ | ------------------------------------------------------------------------------ | -------------------------------------------------------------------------------------------------------------------------------- |
| **1**  | 31 Jul | Database Types, Relational & Non-Relational Databases, DDL, DML                | Set up MySQL and designed the initial ER Diagram for the Health Clinic Application.                                              |
| **2**  | 3 Aug  | ER Diagram, Normalization, Indexing                                            | Finalized the ER Diagram, applied Normalization, and explored Indexing with query optimization.                                  |
| **3**  | 4 Aug  | SQL Joins, Stored Procedures, Triggers                                         | Solved SQL JOIN problems and implemented Stored Procedures, Triggers, and Transactions.                                          |
| **4**  | 5 Aug  | JDBC with MySQL                                                                | Built a Maven-based JDBC project, connected Java with MySQL, and developed a menu-driven Health Clinic application.              |
| **5**  | 6 Aug  | Servlets, Apache Tomcat, Spring Core                                           | Learned Java Servlets, configured Tomcat, and explored Spring Core using XML, Annotation, and Java-based configuration.          |
| **6**  | 7 Aug  | Spring MVC Fundamentals                                                        | Explored Spring MVC concepts and developed a **Demo Greetings Application** using Spring MVC.                                    |
| **7**  | 10 Aug | RESTful API, H2 Basics                                                         | Completed the **Greetings Application**, explored RESTful APIs and H2 Database basics, and started the **Contacts Application**. |
| **8**  | 11 Aug | API Testing, Mockito, Postman & Swagger UI                                     | Updated the **Contacts Application** by writing Mockito test cases for the service layer.                                        |
| **9**  | 12 Aug | Spring Boot, Auto-Configuration, Starters, Spring Controller & REST API Basics | Updated the **Contacts Application** with search by name and favourite contact functionality.                                    |
| **10** | 13 Aug | Bean Injection in Spring Boot, H2 Implementation                               | Completed the **Contacts Application** and started the **Employee Payroll Application**.                                         |
| **11** | 14 Aug | Spring Services, Spring JPA & Spring JDBC                                      | Updated the **Employee Payroll Application** and migrated it to **Spring Data JPA**.                                             |
| **12** | 17 Aug | Spring Scopes, Logging, Maven & Postman                                        | Updated the **Employee Payroll Application** by adding simple loggers and OpenAPI documentation.                                |
| **13** | 18 Aug | Spring Security & JWT Authentication                                           | Added the **Fundoo Notes Application** with basic Spring Security.                                                              |
| **14** | 19 Aug | Authorization & JPA for Notes Management                                       | Updated the **Fundoo Notes Application** with basic User Notes CRUD operations.                                                 |
| **15** | 20 Aug | Organisation Modules: Pin/Archive/Trash, Search & Tags                         | Updated the **Fundoo Notes Application** with basic User Notes patch operations.                                                |
| **16** | 21 Aug | JMS (Asynchronous Messaging) & Redis Caching                                   | Updated the **Fundoo Notes Application** with basic Redis and JMS implementations for learning.                                 |
| **17** | 24 Aug | RabbitMQ & Introduction to Spring Batch                                        | Updated the **Fundoo Notes Application** with RabbitMQ implementation for email reminders and Excel export functionality.       |
| **18** | 25 Aug | Global Exception Handling & Logging                                            | Updated the **Fundoo Notes Application** with Global Exception Handling and an aspect to calculate request method timings.       |
| **19** | 26 Aug | Monolith vs Microservices & Spring Boot Microservices                          | Updated the **Fundoo Notes Application** and migrated it to a microservices-based architecture.                                  |
| **20** | 27 Aug | Eureka Server & Spring Boot Microservices                                      | Updated the **Fundoo Notes Application** by adding Circuit Breakers and Load Balancers.                                          |

---

## 📚 Concepts Covered

### 🗄️ DBMS

* Relational & Non-Relational Databases
* SQL (DDL & DML)
* ER Diagrams
* Normalization (1NF, 2NF, 3NF, BCNF)
* Indexing
* SQL Joins
* Stored Procedures
* Triggers
* Transactions

### ☕ JDBC

* JDBC Architecture
* DriverManager
* Connection
* Statement & PreparedStatement
* ResultSet
* CRUD Operations
* Basic Transaction Management
* Connection Pooling Basics

### 🌐 Backend Development

* Java Servlets
* Apache Tomcat
* Servlet Lifecycle
* Request & Response Handling

### 🌱 Spring Core

* Spring Beans
* Dependency Injection
* Constructor, Setter & Field Injection
* XML-based Configuration
* Annotation-based Configuration
* Java-based Configuration
* Spring Annotations

### 🌐 Spring MVC

* MVC Architecture
* Front Controller Pattern
* DispatcherServlet
* Model & View
* View Resolver
* Request Mapping
* Spring MVC Application Development

### 🔗 RESTful API & H2

* REST Architecture
* RESTful APIs
* HTTP Methods
* API Request & Response Handling
* H2 Database Basics
* In-memory Database
* Spring-based REST API Development

### 🧪 API Testing & Mocking

* Postman
* Swagger UI
* Mockito
* Service Layer Testing
* Mocking
* API Testing

### 🚀 Spring Boot

* Spring Boot Fundamentals
* Auto-Configuration
* Spring Boot Starters
* Stereotype Annotations
* Spring Controller
* REST API Basics in Spring Boot
* Bean Injection
* H2 Database Implementation
* Spring Services
* Spring Data JPA
* Spring JDBC
* Spring Scopes
* Logging
* Maven
* OpenAPI Documentation

### 🔐 Spring Security

* Spring Security Fundamentals
* Authentication
* Authorization
* JWT (JSON Web Token)
* Token-based Authentication

### 📨 Messaging & Caching

* JMS
* Asynchronous Messaging
* Redis Caching
* RabbitMQ
* Email Reminders
* Spring Batch Basics

### 🏗️ Microservices

* Monolithic Architecture
* Microservices Architecture
* Spring Boot Microservices
* Service Discovery
* Eureka Server
* Circuit Breakers
* Load Balancing

---

## 🏥 Project

### Health Clinic Management System

A console-based Java application developed using **JDBC** and **MySQL** to understand backend development and database connectivity.

**Modules**

* Department
* Doctor
* Patient
* Appointment
* Visit
* Billing

**Features**

* CRUD Operations
* Primary & Foreign Key Relationships
* SQL Joins
* Stored Procedures
* Triggers
* Transactions
* Menu-driven Console Interface

---

## 👋 Spring MVC Project

### Demo Greetings Application

A basic Spring MVC application developed to understand the fundamentals of **Spring MVC architecture** and request handling.

**Concepts Practiced**

* DispatcherServlet
* Controllers
* Model & View
* View Resolver
* Request Mapping
* MVC Request Flow

---

## 📇 Contacts Application

Started developing a **Contacts Application** while exploring **RESTful APIs and H2 Database** concepts.

The application focuses on understanding how a Spring-based backend can expose APIs and work with a database for managing contact information.

**Features Added**

* Search Contact by Name
* Favourite Contact Functionality
* Service Layer Testing using Mockito
* REST API Development
* H2 Database Implementation

---

## 👨‍💼 Employee Payroll Application

Started developing an **Employee Payroll Application** after completing the Contacts Application.

The project focuses on applying **Spring Boot, Spring Services, Spring Data JPA, Spring JDBC, and H2 Database** concepts to a new backend application.

---

## 📝 Fundoo Notes Application

A Spring Boot-based Notes Management application developed throughout the later stages of the refresher training.

The application was progressively enhanced with security, database operations, messaging, caching, exception handling, and microservices architecture.

**Features & Concepts Added**

* Spring Security & JWT Authentication
* User Notes CRUD Operations
* Authorization
* Pin, Archive & Trash Operations
* Search & Tags
* Redis Caching
* JMS
* RabbitMQ
* Email Reminders
* Excel Export
* Global Exception Handling
* Request Timing using AOP
* Microservices Architecture
* Eureka Service Discovery
* Circuit Breakers
* Load Balancing

---

## 🛠️ Tech Stack

* Java 17
* MySQL 8
* H2 Database
* JDBC
* Apache Tomcat
* Spring Core
* Spring MVC
* Spring Boot
* Spring Data JPA
* Spring JDBC
* Spring Security
* JWT
* Redis
* JMS
* RabbitMQ
* Spring Batch
* RESTful APIs
* Maven
* Eclipse IDE / STS
* Git & GitHub

---

## 🔗 Quick Links

* 📌 [Day 1](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/Refresher-Training/Day-1)
* 📌 [Day 2](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/Refresher-Training/Day-2)
* 📌 [Day 3](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/Refresher-Training/Day-3)
* 📌 [Day 4](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/Refresher-Training/Day-4)
* 📌 [Day 5](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/Refresher-Training/Day-5)
* 📌 [Day 6](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/Refresher-Training/Day-6)
* 📌 [Day 7](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/Refresher-Training/Day-7)
* 📌 [Day 8](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/Refresher-Training/Day-8)
* 📌 [Day 9](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/Refresher-Training/Day-9)
* 📌 [Day 10](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/Refresher-Training/Day-10)
* 📌 [Day 11](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/Refresher-Training/Day-11)
* 📌 [Day 12](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/Refresher-Training/Day-12)
* 📌 [Day 13](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/Refresher-Training/Day-13)
* 📌 [Day 14](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/Refresher-Training/Day-14)
* 📌 [Day 15](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/Refresher-Training/Day-15)
* 📌 [Day 16](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/Refresher-Training/Day-16)
* 📌 [Day 17](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/Refresher-Training/Day-17)
* 📌 [Day 18](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/Refresher-Training/Day-18)
* 📌 [Day 19](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/Refresher-Training/Day-19)
* 📌 [Day 20](https://github.com/Anuj-Vishwakarma94/BridgeLabz-Training/tree/Refresher-Training/Day-20)

---
