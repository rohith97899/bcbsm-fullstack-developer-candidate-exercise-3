# BCBSM Full Stack Developer Candidate Coding Exercise
  
## Requirements:
1.	Create a single page web application with a login screen (username, password)
2.	Demonstrate user login and authentication/authorization using Spring WebSecurity with USER and ADMIN roles
3.	Upon login as a USER present the user with the ability to submit feedback with a number rating and a comment. User must be logged in to access this page
4.	Upon login for ADMIN users show the feedback of all users
5.	regular users should only be able to see their feedback. Admin users should be able to see all feedback
6.	Create a REST service to receive the feedback form input and store in a database with the below structure:  
    a.  rating_value    
    b.  comment  
    c.  user  
    d.  date  
7.	Display success message on web page and show the feedback entered. If any error show the error message as well.
8.	Fork this repository and we will review your code from the fork.
9.  Mandatory to provide a code and workable application walk through 

## Tech Stack:  
Springboot  
Angular/NextJS/ReactJS  
MongoDB/MySql


Intro of the project - 
The project aims to create a robust single-page web application that incorporates user authentication and authorization using Spring WebSecurity, allowing for both regular USER and ADMIN roles.
This application is built on a technology stack that uses Spring Boot for the backend, and  Angular for front end
 The structure of the feedback includes rating value, comment, the user who submitted it
 we are using Mysql for the database 
 Upon successful feedback submission, users receive a success message, and their feedback is displayed.


 Spring Boot Application:
1. Launch the Spring Boot application using the command: `mvn spring-boot:run`.

Front End:
1. Utilize `npm install` to set up the necessary node modules.
2. Commence the client-side by running `ng serve` in the front end.
3. You can access the application by visiting http://localhost:4200/.
