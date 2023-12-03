# Webservice Authentication Application
by Sandra Jeppsson Kristiansson

### Needed:
- An IDEA - for an example IntelliJ
- Postman
- MySQL Workbench

### Setup
- Open the project in the prefered IDEA
- In the "src" -> "main" -> "resources" -> "application properties" -> change database-name, username and password.
- Run the Main class
- Open the "postman.md"-documentation in the project
- Open Postman

- To register a new User: 
  - Open a tab and enter "http://localhost:8000/auth/register" with "POST"-request
  - Press "Body", "raw" and change the message to "JSON" 


### Dependencies
- Spring Boot Starter Data Web
- Spring Boot Starter Data Jpa
- Spring Boot Starter Security
- Spring Boot Starter oauth2
- Spring Boot DevTools
- MySql Connector J

