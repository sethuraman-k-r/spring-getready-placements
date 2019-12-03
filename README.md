# Spring Boot - Assignment Tracking System (ATS)
ATS application in Spring Boot

>This application covers most of the web concepts using Spring Boot

ATS is a web application in which the database maintains two types of users (Admin and Student)

##### This application includes the concepts of Spring Core, Spring Security, Spring Data JPA, Thymeleaf (Template Engine), Postgres (Database) and Project Lombok

###### Steps to run the project:
  1. Clone this project into a local directory
  2. Open the project in any IDE includes Netbeans, Eclipse, STS, etc
  3. Update the required maven dependencies for this project
  4. Find **GetreadyApplication.java** from the project location
  5. Restore **spring-ats.sql** to the postgres database using **pg_dump spring-ats < spring-ats.sql**
  6. Update the postgres *username* and *password* in the **application.properties** by your database username and password
  7. Update the *file.upload-path* in the **application.properties** by your local file path
  8. Run the java file **GetreadyApplication.java** from your IDE
  9. Open the [http://localhost:8080/ats](http://localhost:8080/ats) in the browser
  10. Username is 'admin@spring.ats' and Password is 'Admin@ABC' - Admin Credentials
