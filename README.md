# Messages Application

## Overview

The **Messages Application** is a Spring Boot-based CRUD application for managing messages. It is built with Maven and
uses an in-memory H2 database.

## Setup Instructions

### 1. With Docker

Build the Docker image:

   ```sh
   docker build -t messages-application .
   ```

Run the Docker container:

   ```sh
   docker run -p 8080:8080 messages-application
   ```

### 2. Without Docker

We will use the Maven Wrapper to build and run the application. If you have Maven installed, you can use the local Maven
by replacing `./mvnw` with `mvn`.

#### Prerequisites

- Java 22

Build the application:

   ```sh
   UNIX
    chmod +x mvnw
    ./mvnw clean install
   
   Windows
    ./mvnw.cmd clean install
   ```

Run the application:

   ```sh
   UNIX
    ./mvnw spring-boot:run
   
   Windows
    ./mvnw.cmd spring-boot:run
   ```

## Project Structure

```
src
└── main
    ├── java
    │   └── com.example.messages
    │       ├── MessagesApplication              Main application class.
    │       └── message                          Package for message-related classes.
    │           ├── dto
    │           │   ├── MessageRequestDTO        DTO for creating/updating messages.
    │           │   └── MessageResponseDTO       DTO for response when retrieving messages.
    │           ├── errors
    │           │   ├── MessageNotFoundAdvice    Advice for handling MessageNotFoundException.
    │           │   └── MessageNotFoundException Custom exception for message not found.
    │           ├── Message                      Entity class representing a Message.
    │           ├── MessageController            Message controller for handling API requests.
    │           ├── MessageRepository            Repository for data access using JPA.
    │           └── MessageService               Service layer handling business logic.
    └── resources
        ├── application.properties               Configuration properties.
        ├── data.sql                             Sample SQL data for initializing the database.
        └── schema.sql                           Database schema.
        
.mvn                                             Maven wrapper files. 
mvnw                                             Maven wrapper for Unix-based systems.
mvnw.cmd                                         Maven wrapper for Windows systems.
pom.xml                                          Maven project object model file.
```

## API Endpoints

**Retrieve All Messages**

- **Method**: GET
- **URL**: `/messages`
- **Query Parameters**:
    - `top`: Number of messages to retrieve.
    - `sort`: Sort messages by `id`, `content`, or `createdOn`.
- **Response**: Returns a list of all messages using `MessageResponseDTO`.

**Retrieve a Message by ID**

- **Method**: GET
- **URL**: `/messages/{id}`
- **Response**: Returns a specific message identified by its ID using `MessageResponseDTO`.

**Create a New Message**

- **Method**: POST
- **URL**: `/messages`
- **Request Body**: Accepts `MessageRequestDTO`.
- **Response**: Returns the created message using `MessageResponseDTO`.

**Update a Message**

- **Method**: PUT
- **URL**: `/messages/{id}`
- **Request Body**: Accepts `MessageRequestDTO`.
- **Response**: Returns the updated message using `MessageResponseDTO`.

**Delete a Message**

- **Method**: DELETE
- **URL**: `/messages/{id}`
- **Response**: Returns a status code 200 if the message is successfully deleted. No content is returned.

**H2 Database Console**

- **URL**: `/h2-console`
