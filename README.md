# Messages Application

## Overview

The **Messages Application** is a Spring Boot-based CRUD application for managing messages. It is built with Maven and
uses an in-memory H2 database.

## Setup Instructions

The project uses Maven wrappers to build and run the application. If you wish to use your local Maven installation, you
can replace `./mvnw` with `mvn` in the commands below.

### Prerequisites

- Java 22

### Steps

1. Clone the repository:
   ```sh
   git clone https://github.com/dohyunjohnkim2412/messages-application.git

2. Build the project:
   ```sh
   UNIX
    ./mvnw clean install
   
   Windows
    ./mvnw.cmd clean install
    ```

3. Run the application:
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
        └── data.sql                             Sample SQL data for initializing the database.
        
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