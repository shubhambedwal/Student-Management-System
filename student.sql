CREATE DATABASE smartstudent;
USE smartstudent;

CREATE TABLE students(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100),
roll_no VARCHAR(20) UNIQUE,
department VARCHAR(50),
email VARCHAR(100),
phone VARCHAR(20),
marks DOUBLE
);