# **Micro-Cursos Project**

A Spring Boot application to manage courses and students, using MySQL for the database and Docker for containerization. This project provides RESTful APIs to perform CRUD operations on courses and students.

---

## **Features**
- Manage courses (CRUD operations).
- Manage students (CRUD operations).
- Uses MySQL for persistent data storage.
- Runs seamlessly in Docker containers using Docker Compose.

---

## **Prerequisites**
Ensure you have the following installed on your machine:
- [Java 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven 3.8+](https://maven.apache.org/download.cgi)
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/install/)

---

## **How to Run the Project**

### **1. Clone the Repository**
Clone the project to your local machine:
```bash
git clone <repository-url>
cd micro-cursos
mvn clean package
docker-compose up -d
```

This command will:
	•	Build the Docker image for the Spring Boot application.
	•	Start the application on port 8082.
	•	Start a MySQL container for the database on port 3306.

 
4. Access the Application

The application will be available at:
	•	API Base URL: http://localhost:8082/api

 Testing the APIs

You can use tools like Postman, cURL, or any HTTP client to test the endpoints. Below are some example endpoints:

1. Courses Endpoints

HTTP Method	Endpoint	Description
POST	/api/cursos	Create a new course
GET	/api/cursos	List all courses
GET	/api/cursos/{id}	Get a course by ID
PUT	/api/cursos/{id}	Update a course by ID
DELETE	/api/cursos/{id}	Delete a course by ID

POST /api/cursos
Content-Type: application/json

{
    "nombre": "Mathematics",
    "descripcion": "Advanced Mathematics Course",
    "creditos": 4
}

2. Students Endpoints

HTTP Method	Endpoint	Description
POST	/api/estudiantes	Create a new student
GET	/api/estudiantes	List all students
GET	/api/estudiantes/{id}	Get a student by ID
PUT	/api/estudiantes/{id}	Update a student by ID
DELETE	/api/estudiantes/{id}	Delete a student by ID

POST /api/estudiantes
Content-Type: application/json

{
    "nombre": "Carlos",
    "apellido": "Hernandez",
    "email": "carlos.hernandez@example.com",
    "fechaNacimiento": "1995-05-15",
    "telefono": "1234567890"
}

docker-compose down

micro-cursos/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── espe/
│   │   │           └── micro_cursos/
│   │   │               ├── controllers/
│   │   │               │   ├── CursoController.java
│   │   │               │   └── EstudianteController.java
│   │   │               ├── model/
│   │   │               │   └── entity/
│   │   │               │       ├── Cursos.java
│   │   │               │       └── Estudiantes.java
│   │   │               ├── repositories/
│   │   │               │   ├── CursoRepository.java
│   │   │               │   └── EstudianteRepository.java
│   │   │               ├── services/
│   │   │               │   ├── CursoService.java
│   │   │               │   ├── CursoServiceImplement.java
│   │   │               │   ├── EstudianteService.java
│   │   │               │   └── EstudianteServiceImplement.java
│   │   │               └── MicroCursosApplication.java
│   │   ├── resources/
│   │   │   ├── application.properties
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md

Environment Variables

The following environment variables are configured in docker-compose.yml for the database:
	•	MYSQL_ROOT_PASSWORD: root
	•	MYSQL_DATABASE: sisdb2025
	•	MYSQL_USER: springuser
	•	MYSQL_PASSWORD: springpassword
