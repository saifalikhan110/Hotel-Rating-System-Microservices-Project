# Hotel-Rating-System-Microservices-Project
Scalable Hotel Rating System using Spring Boot Microservices with Service Discovery, API Gateway, Config Server, and distributed databases.

# Hotel Rating System

## Overview

Hotel Rating System is a microservices-based backend application built using Java, Spring Boot, and Spring Cloud. The system allows users to view hotels, submit ratings, and retrieve aggregated hotel information through independent microservices communicating with each other.

This project demonstrates the implementation of modern microservices architecture using Service Discovery, API Gateway, Centralized Configuration, and Inter-Service Communication.

---

## Architecture

The application consists of the following microservices:

### User Service

* Manages user information.
* Retrieves user details along with hotel ratings.

### Hotel Service

* Manages hotel data.
* Provides hotel information to other services.

### Rating Service

* Manages hotel ratings submitted by users.
* Stores and retrieves rating information.

### Service Registry (Eureka Server)

* Handles service registration and discovery.
* Enables dynamic communication between microservices.

### Config Server

* Centralized configuration management.
* Externalizes application configuration from services.

### API Gateway

* Single entry point for client requests.
* Handles routing and request forwarding.

---

## Technologies Used

### Backend

* Java 17
* Spring Boot
* Spring Cloud

### Spring Cloud Components

* Eureka Server
* Spring Cloud Config Server
* Spring Cloud Gateway
* OpenFeign Client

### Databases

* MySQL
* PostgreSQL
* MongoDB

### Build & Tools

* Maven
* Git & GitHub
* Postman

---

## Features

* Microservices-based architecture
* Service Discovery using Eureka Server
* Centralized Configuration using Config Server
* API Gateway for request routing
* Inter-service communication using OpenFeign Client
* RESTful API design
* Multiple database integration
* Scalable and maintainable architecture

---

## Project Structure

```text
Hotel-Rating-System
│
├── API-Gateway
├── Config-Server
├── Service-Registry
├── User-Service
├── Hotel-Service
└── Rating-Service
```

---

## Inter-Service Communication

The User Service communicates with:

* Rating Service to fetch user ratings.
* Hotel Service to retrieve hotel details.

OpenFeign Client is used for declarative REST communication between services.

---

## Running the Project

### 1. Start Config Server

```bash
mvn spring-boot:run
```

### 2. Start Service Registry (Eureka Server)

```bash
mvn spring-boot:run
```

### 3. Start Hotel Service

```bash
mvn spring-boot:run
```

### 4. Start Rating Service

```bash
mvn spring-boot:run
```

### 5. Start User Service

```bash
mvn spring-boot:run
```

### 6. Start API Gateway

```bash
mvn spring-boot:run
```

---

## API Flow

1. Client sends request to API Gateway.
2. API Gateway routes request to User Service.
3. User Service retrieves user ratings from Rating Service.
4. User Service retrieves hotel information from Hotel Service.
5. Aggregated response is returned to the client.

---

## Learning Outcomes

This project helped me gain practical experience with:

* Microservices Architecture
* Spring Boot
* Spring Cloud
* Eureka Service Discovery
* API Gateway
* OpenFeign Client
* Config Server
* RESTful API Development
* Database Integration
* Distributed Systems Design

---

## Author

**Saif Ali Khan**

* GitHub: https://github.com/saifalikhan110
* LinkedIn: Add your LinkedIn profile link here

---

⭐ If you found this project useful, consider giving it a star.
