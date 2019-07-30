# springbootjdbc
Sample Spring Boot MyBatis API with Junit 5  

<http://www.mybatis.org/mybatis-3/>

#Database - H2
By default, Spring Boot will configure an H2 database for us. H2 is a  database to develop against because it has an Oracle compatibility mode. The application.properties initializes the datasource and the data.sql and schema.dql with initialize a sample demo_users db with a default user. To access the database. 

The h2 console can be accessed at the following location http://127.0.0.1:8080/h2-console with the following credentials

jbdc url = jdbc:h2:mem:administratordb
username = sa
password =


#Postman scripts
To test using Postman the scripts are in the following location postman/demo - users.postman_collection.json. Simply import and start the application using the com.demo.jdbc.Application.java