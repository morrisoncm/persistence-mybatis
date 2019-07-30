# springbootjdbc
Sample Spring Boot MyBatis API with Junit 5  

<http://www.mybatis.org/mybatis-3/>

## Running the application
Simply clone or download the project. The main starting point for the application is  <https://github.com/morrisoncm/springbootjdbc/blob/master/src/main/java/com/demo/jdbc/Application.java>

## Postman Scripts
To test using Postman the scripts are in the following location <https://github.com/morrisoncm/springbootmybatis/blob/master/postman/demo%20-%20adminusers.postman_collection.json>.

## Database - h2
By default, Spring Boot will configure an H2 database for us. H2 is a  database to develop against because it has an Oracle compatibility mode. The application.properties initializes the datasource and the data.sql and schema.dql with initialize a sample demo_users db with a default user. To access the database. 

The h2 console can be accessed at the following location http://127.0.0.1:8080/h2-console. To sign onto the console the credentials are in the following directory
<https://github.com/morrisoncm/springbootmybatis/blob/master/src/main/java/com/demo/mybatis/Application.java

