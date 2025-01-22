# **Micro-Paquetes**

A Spring Boot application to manage courses and students, using MySQL for the database and Docker for containerization. This project provides RESTful APIs to perform CRUD operations on courses and students.

Instructions:
git clone <repository-url>
cd paquetes

Run on the terminal:
docker-compose up --build -d

docker ps
You should see two containers:
	•	paquete-turistico-app: The Spring Boot application container.
	•	paquete-turistico-db: The MySQL database container.

 
Run the project on IntelliJ

Test the API using PostMan:
The application will be available at:
	•	API Base URL: http://localhost:8080/api/paquetes

# Paquetes Turísticos Service - API Documentation

This service allows you to manage "Paquete Turístico" records. Below are examples of how to test the service using the provided API endpoints.

---

## **1. Create a New Paquete Turístico**

**Endpoint**: `POST /api/paquetes`  
**URL**: `http://localhost:8080/api/paquetes`  
**Method**: `POST`  
**Headers**:  
`Content-Type: application/json`

**Request Body**:
```json
{
    "nombre": "Aventura en la Selva",
    "descripcion": "Explora la selva amazónica con guías locales.",
    "duracionDias": 5,
    "fechaInicio": "2025-06-10"
}
