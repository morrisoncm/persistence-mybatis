DROP TABLE IF EXISTS administrator;

CREATE TABLE administrator (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  firstname VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  email VARCHAR(75) NOT NULL
);

CREATE TABLE role (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  role_name VARCHAR(50) NOT NULL,
 role_description VARCHAR(100) NOT NULL
);

CREATE TABLE administrator_role (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  administratorId INT, FOREIGN KEY (administratorId) REFERENCES administrator(id),
  roleId INT, FOREIGN KEY (roleId) REFERENCES role(id)
);

CREATE TABLE privilege (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  privilege_name VARCHAR(50) NOT NULL,
  privilege_description VARCHAR(100) NOT NULL
);

CREATE TABLE role_privilege (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  roleId INT, FOREIGN KEY (roleId) REFERENCES role(id),
  privilegeId INT, FOREIGN KEY (privilegeId) REFERENCES privilege(id)
);