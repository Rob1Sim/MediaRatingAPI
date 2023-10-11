# MediaRator API   
## Description
REST API for an app that allows users to rate and review movies and tv shows, books, ...
## Installation
1. Clone the repository
2. Install the dependencies
3. Create a ressource folder with the following structure:
```
├───static
├───templates
└───application.properties
```
4. Create a file called `application.properties` and add the following lines:
```
spring.datasource.url=jdbc:
spring.datasource.username=
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.generate-ddl=true
spring.jpa.show-sql=true
```
5. Add your database url, username and password to the `application.properties` file
6. Run the application