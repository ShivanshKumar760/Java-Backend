CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rollNumber INT NOT NULL UNIQUE,
    age INT,
    fname VARCHAR(50),
    lname VARCHAR(50),
    classGrade VARCHAR(20)
);
