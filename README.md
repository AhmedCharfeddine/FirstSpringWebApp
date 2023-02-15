# FirstSpringWebApp
Webapp developed to learn the Spring framework

![demo gif for the app](docs/demo.gif)

## Project description

The project consists of a fullstack Spring boot app hooked to a MySQL database that provides authentication for users with Spring security and lets them manage a list of people with CRUD operations. Only admins are allowed to edit and delete existing users. 

The following components were used for building the app:
- **MySQL** as the RDBMS.
- **Thymeleaf** as the server-side template engine.
- **Hibernate** as the ORM.
- **Spring Security** to manage authentication and authorization.

## Setting up the project for local use

In order to run the app, you'd first have to prepare the database. Start by creating a user `exercise_db` with password `password` and grant him the necessary privileges in order to manage a database `database_db` that will contain the needed tables. (if you wish to change these settings, you can do so by modifying `application.properties`)

Proceed to create the following table:

```
CREATE TABLE personne (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
nom VARCHAR(30) NOT NULL,
prenom VARCHAR(30) NOT NULL,
civilite TINYINT NOT NULL,
adresse VARCHAR(30) NOT NULL,
naissance DATE NOT NULL
);
```

You can then populate it:

```
INSERT INTO personne(nom, prenom, civilite, adresse, naissance)
VALUES
('John','Roberts',0, 'addr1', '1981-04-17'),
('Billy','Bogus',0, 'addr2', '1973-08-03'),
('Jennifer','Kelly', 1, 'addr3', '1978-10-16');
```

## Running the application
Use maven to run the app with `./mvnw spring-boot:run` and log in with the automatically created admin account with username and password **admin**. Newly-created users are automatically assigned the *user* role. Granting admin privileges can be done by changing their role manually in the database.
