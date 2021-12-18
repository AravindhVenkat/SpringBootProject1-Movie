# SpringBootProjectServerSide-Movie
Movie based ***Spring Boot project*** made on **Spring Tool Suite 4** (STS 4)

**Run using - http://localhost:8080/movies**

### Specifications
Created **Spring Starter Project** with dependencies auto-generated on *pom.xml* for the following:
1) Spring Web Services
2) Spring Data JPA
3) PostgreSQL Driver

**localhost** server from **PostgreSQL & pgAdmin4**

***Apache Tomcat*** - Default **Port 8080** - No Configuration

***Postman API*** tool used for **GET PUT POST DELETE** by using **@GetMapping, @PutMapping, @PostMapping, @DeleteMapping** etc

### Java Packages: 
1) Controller – MyRestController.java - class with annotation **@RestController** - calls methods based on Strings written on the address bar
2) Entities  – Movie Class - **@Entity, @ApiModel, @Table**
3) Exceptions - **Custom exception** class IdnotfoundException.java for non-existent Movie ID
4) GlobalExceptionHandler - GlobalExceptionHandler.java  class with **@RestControllerAdvice**
5) Repository - MovieRepository
6) Response - Class with HttpStatus, URL, statusCode, statusName
7) Services – ServiceClass & ServiceClassInterface to perform *methods* - This is **@Autowired in MyRestController**
