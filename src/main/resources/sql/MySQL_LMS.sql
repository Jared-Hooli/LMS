DROP DATABASE IF EXISTS LMS;
CREATE DATABASE LMS;

USE LMS;

SELECT * FROM User_table;
SELECT * FROM Course_Id_Name;
SELECT * FROM Assigned_courses;

CREATE TABLE User_table (
    User_id VARCHAR(255) NOT NULL,
    User_Name VARCHAR(50),
    User_Role VARCHAR(1),
    PRIMARY KEY (User_id)
);

INSERT INTO User_table (User_id, User_Name, User_Role) VALUES
('madhu@infowaygroup.com', 'Madhu', 'P'),
('srinivasan@infowaygroup.com', 'Srinivasan', 'P'),
('peter@infowaygroup.com', 'Peter', 'P'),
('pavan@infowygroup.com', 'Pavan', 'U'),
('prathik@infowaygroup.com', 'Prathik', 'P'),
('jayaraman@infowaygroup.com', 'jayaraman', 'U'),
('emma@infowaygroup.com', 'emma', 'U'),
('vishwa@infowaygroup.com', 'vishwa', 'U'),
('ganesh@infowaygroup.com', 'ganesh', 'U'),
('mary@infowaygroup.com', 'mary', 'U'),
('gayathri@infowaygroup.com', 'gayathri', 'U');

CREATE TABLE Course_Id_Name (
    Course_id VARCHAR(30) NOT NULL,
    Course_name VARCHAR(255),
    PRIMARY KEY (Course_id)
);

INSERT INTO Course_Id_Name (Course_id, Course_name) VALUES
('Java_01', 'Java Basics for beginners'),
('Java_03', 'Java Spring & Microservices'),
('AWS_01', 'AWS Cloud professional'),
('AWS_03', 'AWS Solution architecture'),
('AWS_05', 'AWS Analytic tools'),
('GCP_01', 'Google cloud basics'),
('GCP_03', 'Google cloud DevOps'),
('GCP_05', 'Google cloud solution architecture'),
('Azu_01', 'Azure basics'),
('Azu_03', 'Azure configuration'),
('Azu_05', 'Azure security'),
('GenAi_01', 'Gen AI introduction and use cases');

UPDATE Course_Id_Name SET Course_id = 'Azu_05' WHERE Course_id = 'Azu-05';

CREATE TABLE Assigned_courses (
    User_id VARCHAR(255),
    Course_id VARCHAR(30),
    Capability VARCHAR(30),
    Target_date_completion DATE,
    Training_status VARCHAR(10),
    Score INT,
    PRIMARY KEY (User_id, Course_id),
    FOREIGN KEY (User_id) REFERENCES User_table(User_id),
    FOREIGN KEY (Course_id) REFERENCES Course_Id_Name(Course_id)
);

INSERT INTO Assigned_courses (User_id, Course_id, Capability, Target_date_completion) VALUES
('srinivasan@infowaygroup.com', 'AWS_01', 'Cloud', '2024-01-07'),
('srinivasan@infowaygroup.com', 'GCP_03', 'Cloud', '2024-01-07'),
('srinivasan@infowaygroup.com', 'Azu_01', 'Cloud', '2024-01-07'),
('srinivasan@infowaygroup.com', 'GenAi_01', 'AI_ML', '2024-01-07'),
('jayaraman@infowaygroup.com', 'AWS_03', 'Cloud', '2024-01-07'),
('jayaraman@infowaygroup.com', 'GCP_05', 'Cloud', '2024-01-07'),
('jayaraman@infowaygroup.com', 'Azu_03', 'Cloud', '2024-01-07'),
('jayaraman@infowaygroup.com', 'GenAi_01', 'AI_ML', '2024-01-07'),
('vishwa@infowaygroup.com', 'AWS_01', 'Cloud', '2024-01-07'),
('vishwa@infowaygroup.com', 'GCP_03', 'Cloud', '2024-01-07'),
('vishwa@infowaygroup.com', 'Azu_05', 'Cloud', '2024-01-07'),
('vishwa@infowaygroup.com', 'GenAi_01', 'Cloud', '2024-01-07');

CREATE TABLE User_passwords (
    User_id VARCHAR(255) NOT NULL,
    Password_hash VARCHAR(255) NOT NULL,
    PRIMARY KEY (User_id),
    FOREIGN KEY (User_id) REFERENCES User_table (User_id)
);

INSERT INTO User_passwords (User_id, Password_hash) VALUES
('madhu@infowaygroup.com', 'Madhu'),
('srinivasan@infowaygroup.com', 'Srinivasan'),
('peter@infowaygroup.com', 'Peter'),
('pavan@infowygroup.com', 'Pavan'),
('prathik@infowaygroup.com', 'Prathik'),
('jayaraman@infowaygroup.com', 'Jayaraman'),
('emma@infowaygroup.com', 'Emma'),
('vishwa@infowaygroup.com', 'Vishwa'),
('ganesh@infowaygroup.com', 'Ganesh'),
('mary@infowaygroup.com', 'Mary'),
('gayathri@infowaygroup.com', 'Gayathri');