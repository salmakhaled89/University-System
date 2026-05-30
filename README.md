<img width="1280" height="515" alt="WhatsApp Image 2026-05-30 at 7 35 20 PM" src="https://github.com/user-attachments/assets/6a484d89-410c-481e-9835-28e5efe556ba" />
# University Management System

A robust and comprehensive Desktop Application built using **Core Java** and developed within the **NetBeans IDE**. This project focuses on implementing advanced **Object-Oriented Programming (OOP)** principles and software engineering design patterns to model a real-world university ecosystem.

##  Tech Stack & Concepts
- **Language:** Java (JDK 11+)
- **IDE:** NetBeans
- **Core Concepts:** Encapsulation, Inheritance, Polymorphism, Abstraction, and File I/O for persistent data storage.

##  System Architecture & Design
Before writing the code, the system architecture was carefully designed to ensure high modularity and scalability. Below is the **Class Diagram** representing the relationships (Associations, Inheritances, and Dependencies) between core entities.

---

##  Key Features

1. **User Hierarchies (Inheritance & Abstraction):**
   - Utilizes a base abstract `User` class inherited by specialized roles: `Student`, `Faculty`, `SystemAdmin`, and `AdminStaff`.
2. **Course & Enrollment Management:**
   - Supports course creation with prerequisite validations (`isPrerequisiteSatisfied()`).
   - Handles student registrations, capacity checks, and grading mechanisms (`assignGrade()`).
3. **Data Persistence (File Management):**
   - Features a custom `FileManager` subsystem capable of loading and saving user, student, and course profiles to local storage, ensuring data persistence.
4. **Department & University Structure:**
   - Implements composition and aggregation principles where a `University` consists of multiple `Departments` offering various courses.
