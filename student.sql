CREATE DATABASE smartstudent;
USE smartstudent;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    roll_no VARCHAR(20) NOT NULL UNIQUE,
    department VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    marks DECIMAL(5,2) NOT NULL,
    
    CHECK (marks >= 0 AND marks <= 100)
);
