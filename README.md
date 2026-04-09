## 🚀 Overview

This project was developed to demonstrate practical experience with MongoDB and Spring Boot in a real-world backend scenario.

The application follows a layered architecture:
- Client Application
- REST Controllers
- Service Layer
- Repository Layer (MongoRepository)
- Domain Layer
  

<img width="1236" height="556" alt="image" src="https://github.com/user-attachments/assets/d161aa23-7870-4968-86ed-b2c744b18498" />
  
---

## 💡 Key Highlights

- Designed a REST API using MongoDB with Spring Boot
- Applied document-oriented modeling (embedding vs referencing)
- Implemented unit testing with Mockito and MockMvc
- Designed a clean layered architecture
  
---

### 🧠 Data Modeling Approach

The application uses MongoDB document modeling strategies:

- Embedded documents for closely related data
- References for loosely coupled relationships

The design decisions were driven by access patterns to optimize read performance.

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

### ⚙️ Technologies Used
- Java 17+
- Spring Boot 3.2.5
- Spring Data MongoDB
- MongoDB
- Maven

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
│   │   ── mapper/             
│   │       └── UserMapper.java
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
  - Handles HTTP requests and responses, exposing REST endpoints.
- Service
  - Contains business logic, validation, and orchestration.
- Repository
  - Responsible for data access using MongoRepository abstraction.
- Domain
  - Represents MongoDB documents and core business entities.
- DTO
  - Used to transfer data between layers and avoid exposing domain entities.
- Exception Handling
  - Provides centralized error handling for REST APIs.

---

### 🔥 Key Design Highlight

👉 The service layer returns a DTO instead of the entity, which:

- Protects domain model
- Avoids exposing internal structure
- Improves API design

---

### 🧪 Testing Documentation

This project includes unit and integration tests covering the main layers of the application.

### 🎯 Testing Strategy

The tests are divided into:

- Controller Tests → API layer validation
- Service Tests → Business logic validation
- Repository Tests → Data access validation

---

### 🧰 Main Testing Libraries

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

### 💡 Testing Strategy Summary

The project uses isolated unit tests to ensure fast execution and clear separation of concerns, avoiding dependency on external systems like databases.

---

### ⚡ Difference: Controller vs Service Tests

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

### 🚀 Future Improvements

- Add integration tests using TestContainers with MongoDB
- Implement pagination and filtering
- Add CI/CD pipeline (GitHub Actions)
- Improve test coverage with JaCoCo

---

### 💡 Final Thoughts

This project reinforces key backend concepts such as clean architecture, document-based data modeling, and test isolation, which are essential for building scalable and maintainable applications.

---

👨‍💻 Author

Peter Viegas
Full-stack Developer | Java & Spring Boot | Angular | React Native

