# HIGN RESTful API Project

## Overview

This project implements a RESTful API for the **Hartford Institute for Geriatric Nursing (HIGN)**. The API supports managing **Examiners** and **Mental State Exams**, adhering to the given business rules and architectural constraints. The implementation leverages **Java 22**, **Spring Boot Framework 3.X**, and follows best practices of Domain-Driven Design (DDD) and layered architecture.

---

## Project Name
`si729ebu<student-code>`  
Example: `si729ebu201621873`

---

## Packages Structure
- Root Package: `org.hign.platform.u<student-code>`  
  Example: `org.hign.platform.u201621873`

### Bounded Contexts:
1. **Personnel**  
   Handles the `Examiner` entity.
2. **Assessment**  
   Handles the `Mental State Exam` entity.
3. **Shared**  
   Provides reusable base components and utilities.

---

## Database
- **Database Type:** MySQL
- **Schema Name:** `hign`
- **Tables:**
    - `examiners`
    - `mental_state_exams`

---

## Endpoints

### Examiners Endpoint
**Path:** `/api/v1/examiners`  
**Method:** `POST`  
**Purpose:** Add a new examiner.  
**Parameters:**
- `firstName`: string (non-empty)
- `lastName`: string (non-empty)
- `nationalProviderIdentifier`: string (valid UUID)

### Mental State Exams Endpoint
**Path:** `/api/v1/mental-state-exams`  
**Method:** `POST`  
**Purpose:** Add a new mental state exam.  
**Parameters:**
- `patientId`: long (non-empty)
- `examinerNationalProviderIdentifier`: string (valid UUID)
- `examDate`: string (YYYY-MM-DD)
- `orientationScore`: integer (0-10)
- `registrationScore`: integer (0-3)
- `attentionAndCalculationScore`: integer (0-5)
- `recallScore`: integer (0-3)
- `languageScore`: integer (0-9)

---

## Business Rules & Validation

### Examiner:
- `nationalProviderIdentifier` must be a valid UUID.
- `firstName` and `lastName` are mandatory, non-empty.
- `nationalProviderIdentifier` must be unique across the database.

### Mental State Exam:
- `examDate` must be a valid date in `YYYY-MM-DD` format and not later than the current date.
- `examinerNationalProviderIdentifier` must correspond to an existing examiner.
- All score fields must be within the specified ranges:
  - `orientationScore`: 0-10
  - `registrationScore`: 0-3
  - `attentionAndCalculationScore`: 0-5
  - `recallScore`: 0-3
  - `languageScore`: 0-9

---

## Technical Constraints
- **Java Version:** Java 22
- **Spring Boot Version:** 3.X
- **Database:** MySQL (Schema: `hign`)

### Naming Conventions:
- Use Upper-Camel-Case for class names and lower-camel-case for attributes and methods.
- Database table names should be in snake_case.
- API URLs should use lowercase and hyphens (-) for multi-word terms.

### Dependencies:
- **Spring Boot Starter Web:** For building web applications and exposing RESTful APIs.
- **Spring Data JPA:** For interacting with the MySQL database.
- **Lombok:** For reducing boilerplate code.
- **H2 Database (for testing):** In-memory database for local testing and development.
- **Spring Boot DevTools:** For hot-reloading during development.
- **Validation API:** For validating input data via annotations.

---

## Project Structure

1. **Domain Layer**
   - Contains core business logic and domain models.
   - Defines aggregates for `Examiner` and `MentalStateExam`.

2. **Application Layer**
   - Implements business services.
   - Contains service classes that interact with the domain layer.
   - Exposes functionality through interfaces.

3. **Infrastructure Layer**
   - Contains repository implementations.
   - Manages database interactions and external dependencies.

4. **API Layer**
   - Handles HTTP requests and responses.
   - Defines controllers for exposing the API endpoints.
   - Implements request validation and error handling.

---

## Audit Fields
- Automatically populated `createdAt` and `updatedAt` fields for both `Examiner` and `MentalStateExam`.

---

## Assembler Pattern
- Used for Object Mapping in the interface layer.

---

## Records
- Used for immutable value objects.