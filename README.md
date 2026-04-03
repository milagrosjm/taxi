# 🚕 Taxi Management System

## 📌 Description

This project is a **Taxi Management System** developed in Java.
It simulates the process of requesting and creating trips, assigning drivers, and calculating trip details such as distance, price, and time.

The project was built following **Object-Oriented Programming (OOP)** principles.

---

## 🧱 Technologies Used

- Java 21
- Maven
- Log4j2 (logging)

---

## 📂 Project Structure

```
project
 ├── pom.xml
 └── src
     ├── main
     │   ├── java
     │   │   └── com.solvd.taxi
     │   └── resources
     │       └── log4j2.xml
     └── test
         └── java
```

---

## ▶️ How to Run the Project

### 1. Compile and build

```bash
mvn clean install
```

### 2. Run the application

```bash
mvn exec:java -Dexec.mainClass="com.solvd.taxi.Main"
```
