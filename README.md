### 📘 MongoDB Project with Spring Boot
🚀 Overview

This project demonstrates how to build a RESTful API using Spring Boot integrated with MongoDB, focusing on document-oriented data modeling and best practices.

<img width="1236" height="556" alt="image" src="https://github.com/user-attachments/assets/d161aa23-7870-4968-86ed-b2c744b18498" />

- Client Application
- REST Controllers
- Service Layer
- Repository Layer (MongoRepository)
- Domain Layer
  
---

### 🎯 Main Objectives

- Understand the differences between document-oriented and relational databases
- Implement CRUD operations
- Apply design decisions for document databases
- Implement relationships:
  - Embedded documents
  - References
  - Perform queries using Spring Data MongoDB

---

### 🧠 Relational vs Document-Oriented

```
| Relational (SQL) | MongoDB (NoSQL)             |
| ---------------- | --------------------------- |
| Tables           | Collections                 |
| Rows             | Documents (JSON/BSON)       |
| JOINs            | Embedded or referenced data |
| Fixed schema     | Flexible schema             |
```
---

### 🔄 CRUD Operations

```
| Operation  | HTTP   | Endpoint    |
| ---------- | ------ | ----------- |
| Create     | POST   | /users      |
| Read       | GET    | /users      |
| Read by ID | GET    | /users/{id} |
| Update     | PUT    | /users/{id} |
| Delete     | DELETE | /users/{id} |
```
---

# ⚙️ Technologies Used
Java 17+
Spring Boot 3.2.5 (started 4.0 but returned 3.2.5 because the TDD)
Spring Data MongoDB
MongoDB
Maven

---

### 📁 Project Structure

Below is the project structure following a layered architecture (Controller → Service → Repository → Domain):

```
src/
├── main/
│   ├── java/com/viegas/workshopmongo/
│   │
│   │   ├── WorkshopmongoApplication.java
│   │
│   │   ├── config/
│   │   │   ├── Instantiation.java
│   │   │   └── MongoConfig.java
│   │
│   │   ├── domain/
│   │   │   └── User.java
│   │
│   │   ├── dto/
│   │   │   └── UserDTO.java
│   │
│   │   ├── repository/
│   │   │   └── UserRepository.java
│   │
│   │   ├── resources/
│   │   │   └── UserResource.java
│   │
│   │   ├── services/
│   │   │   └── UserService.java
│   │
│   │   └── services/exception/
│   │       ├── ObjectNotFoundException.java
│   │       ├── ResourceExceptionHandler.java
│   │       └── StandardError.java
│
│   └── resources/
│
├── test/
│   └── java/com/viegas/workshopmongo/
│       ├── WorkshopmongoApplicationTests.java
│       ├── controller/
│       │   └── MeuControllerTest.java
│       ├── repository/
│       │   └── MeuRepositoryTest.java
│       └── service/
│           └── UserServiceTest.java
```

---

### 🧩 Layer Responsibilities

- Controller (resources)
  - Handles HTTP requests and responses.
- Service
  - Contains business logic and validations.
- Repository
  - Responsible for data access using MongoRepository.
- Domain
  - Represents MongoDB documents.
- DTO
  - Used to transfer data between layers.
- Exception Handling
  - Centralized error handling for REST APIs.

---

### 🔥 Key Design Highlight

👉 The service layer returns a DTO instead of the entity, which:

- Protects domain model
- Avoids exposing internal structure
- Improves API design

---

### 🧪 Testing Documentation

This project includes unit and integration tests covering the main layers of the application.

🎯 Testing Strategy

The tests are divided into:

- Controller Tests → API layer validation
- Service Tests → Business logic validation
- Repository Tests → Data access validation

---

🧰 Main Testing Libraries

✅ JUnit 5
- Core testing framework used for writing and running tests.
- Provides annotations like:
  - @Test
  - @BeforeEach

✅ Spring Boot Test
- Provides integration with Spring context.
- Allows loading only specific parts of the application.

Examples:

- @WebMvcTest → loads only controller layer
- @SpringBootTest → loads full context
  

✅ MockMvc
- Used to simulate HTTP requests without starting the server.
- Enables testing REST endpoints in isolation.

👉 Example usage:

- Perform GET requests
- Validate HTTP status
- Validate JSON response

✅ Mockito
- Used to mock dependencies.
- Avoids calling real services or database.

Key features:

- @MockBean → inject mock into Spring context
- when(...).thenReturn(...) → define behavior


✅ JSONPath
- Used to validate JSON responses.

Examples:

- Check field values
- Validate response structure

---

⚡ Difference: Controller vs Service Tests

```
| Layer      | Tool        | Purpose             |
| ---------- | ----------- | ------------------- |
| Controller | MockMvc     | Test HTTP layer     |
| Service    | Mockito     | Test business logic |
| Repository | Spring Data | Test data access    |
```

---

### 🔍 Controller Test Approach

The controller tests use:

- @WebMvcTest
- MockMvc
- @MockBean for service layer

✔ Focus:

- Validate endpoints
- Validate HTTP status
- Validate response body

---

👨‍💻 Author

Peter Viegas
Full-stack Developer | Java & Spring Boot | Angular | React Native
