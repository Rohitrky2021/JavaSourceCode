create database lab;
-- Create the DEPARTMENT table
use lab;
CREATE TABLE DEPARTMENT (
  Dno INT,
  Dname VARCHAR(50) DEFAULT 'NULL',
  Loc VARCHAR(50) DEFAULT 'New Delhi',
  PRIMARY KEY (Dno)
);

-- Insert data into the DEPARTMENT table
INSERT INTO DEPARTMENT VALUES
(10, 'ACCOUNTING', 'NEW YORK'),
(20, 'RESEARCH', 'DALLAS'),
(30, 'SALES', 'CHICAGO'),
(40, 'OPERATIONS', 'BOSTON');

-- Create the EMPLOYEE table
CREATE TABLE EMPLOYEE (
  Eno CHAR(4) NOT NULL,
  Ename VARCHAR(50) NOT NULL,
  Job_type VARCHAR(50) NOT NULL,
  Manager CHAR(4) DEFAULT NULL,
  Hire_date DATE NOT NULL,
  Dno INT(11) DEFAULT NULL,
  Commission DECIMAL(10, 2) DEFAULT NULL,
  Salary DECIMAL(7, 2) NOT NULL,
  PRIMARY KEY (Eno),
  FOREIGN KEY (Dno) REFERENCES DEPARTMENT (Dno)
);

drop table EMPLOYEE;


INSERT INTO EMPLOYEE VALUES
('7369', 'Smith', 'Clerk', '7566', '1980-12-17', 20, 0.00, 800.00),
('7499', 'Allen', 'Sales_man', '7698', '1981-02-20', 30, 300.00, 1600.00),
('7521', 'Ward', 'Sales_man', '7698', '1981-02-22', 30, 500.00, 1250.00),
('7566', 'Jones', 'Manager', '7839', '1981-04-02', 20, 0.00, 2975.00),
('7654', 'Martin', 'Sales_man', '7698', '1981-04-22', 30, 1400.00, 1250.00),
('7698', 'Blake', 'Manager', '7839', '1981-05-01', 30, 0.00, 2850.00),
('7782', 'Clark', 'Manager', '7839', '1981-06-09', 10, 0.00, 2450.00),
('7788', 'Scott', 'Analyst', '7566', '1982-12-09', 20, 0.00, 3000.00),
('7839', 'King', 'President', NULL, '1981-11-17', 10, 0.00, 5000.00),
('7844', 'Turner', 'Sales_man', '7698', '1981-09-08', 30, 0.00, 1500.00),
('7876', 'Adams', 'Clerk', '7788', '1983-01-12', 20, 0.00, 1100.00),
('7900', 'James', 'Clerk', '7698', '1981-12-03', 30, 0.00, 950.00),
('7902', 'Ford', 'Analyst', '7566', '1981-12-03', 20, 0.00, 3000.00),
('7934', 'Miller', 'Clerk', '7782', '1982-01-23', 10, 0.00, 1300.00);

select * from department; 

select * from Employee;


CREATE TABLE EMPLOYEE ( Eno char(4) NOT NULL,  
Ename varchar(50) NOT NULL,  
Job_type varchar(50) NOT NULL,  
Manager char(4) DEFAULT NULL,  
Hire_date date NOT NULL,  
Dno int(11) DEFAULT NULL,  
Commission decimal(10,2) DEFAULT NULL,  
Salary decimal(7,2) NOT NULL,  
PRIMARY KEY (Eno),  
FOREIGN KEY (Dno) REFERENCES DEPARTMENT (Dno),  
-- FOREIGN KEY (Manager) REFERENCES EMPLOYEE (Eno));


CREATE TABLE EMPLOYEE (
  Eno CHAR(4) NOT NULL,
  Ename VARCHAR(50) NOT NULL,
  Job_type VARCHAR(50) NOT NULL,
  Manager CHAR(4) DEFAULT NULL,
  Hire_date DATE NOT NULL,
  Dno INT,
  Commission DECIMAL(10, 2) DEFAULT NULL,
  Salary DECIMAL(7, 2) NOT NULL,
  PRIMARY KEY (Eno),
  CONSTRAINT Dno FOREIGN KEY (Dno) REFERENCES DEPARTMENT (Dno),
  CONSTRAINT Manager FOREIGN KEY (Manager) REFERENCES EMPLOYEE (Eno)
);

-- Inserting dummy data into the EMPLOYEE table

-- Inserting Employee 1
INSERT INTO EMPLOYEE (Eno, Ename, Job_type, Manager, Hire_date, Dno, Commission, Salary)
VALUES ('E001', 'John Smith', 'Manager', NULL, '2020-01-15', 101, NULL, 60000.00);

-- Inserting Employee 2
INSERT INTO EMPLOYEE (Eno, Ename, Job_type, Manager, Hire_date, Dno, Commission, Salary)
VALUES ('E002', 'Jane Doe', 'Supervisor', 'E001', '2021-03-20', 101, NULL, 50000.00);

-- Inserting Employee 3
INSERT INTO EMPLOYEE (Eno, Ename, Job_type, Manager, Hire_date, Dno, Commission, Salary)
VALUES ('E003', 'Mike Johnson', 'Clerk', 'E001', '2022-05-10', 102, 500.00, 35000.00);

-- Inserting Employee 4
INSERT INTO EMPLOYEE (Eno, Ename, Job_type, Manager, Hire_date, Dno, Commission, Salary)
VALUES ('E004', 'Emily Wilson', 'Clerk', 'E001', '2021-09-05', 102, 300.00, 32000.00);

-- Inserting Employee 5
INSERT INTO EMPLOYEE (Eno, Ename, Job_type, Manager, Hire_date, Dno, Commission, Salary)
VALUES ('E005', 'David Brown', 'Analyst', 'E002', '2020-12-12', 103, NULL, 70000.00);

CREATE TABLE EMPLOYEE (
  Eno CHAR(4) NOT NULL,
  Ename VARCHAR(50) NOT NULL,
  Job_type VARCHAR(50) NOT NULL,
  Manager CHAR(4) DEFAULT NULL,
  Hire_date DATE NOT NULL,
  Dno INT(11) DEFAULT NULL,
  Commission DECIMAL(10, 2) DEFAULT NULL,
  Salary DECIMAL(7, 2) NOT NULL,
  PRIMARY KEY (Eno),
  FOREIGN KEY (Dno) REFERENCES DEPARTMENT (Dno),
  FOREIGN KEY (Manager) REFERENCES EMPLOYEE (Eno)
);


INSERT INTO EMPLOYEE VALUES ('7369','Smith','Clerk','7902','1980-12-17',20,0.00,800.00),
('7499','Allen','Sales_man','7698','1981-02-20',30,300.00,1600.00),
('7521','Ward','Sales_man','7698','1981-02-22',30,500.00,1250.00),
('7566','Jones','Manager','7839','1981-04-02',20,0.00,2975.00),
('7654','Martin','Sales_man','7698','1981-04-22',30,1400.00,1250.00),
('7698','Blake','Manager','7839','1981-05-01',30,0.00,2850.00),
('7782','Clark','Manager','7839','1981-06-09',10,0.00,2450.00),
('7788','Scott','Analyst','7566','1982-12-09',20,0.00,3000.00),
('7839','King','President',NULL,'1981-11-17',10,0.00,5000.00),
('7844','Turner','Sales_man','7698','1981-09-08',30,0.00,1500.00),
('7876','Adams','Clerk','7788','1983-01-12',20,0.00,1100.00),
('7900','James','Clerk','7698','1981-12-03',30,0.00,950.00),
('7902','Ford','Analyst','7566','1981-12-03',20,0.00,3000.00),
('7934','Miller','Clerk','7782','1982-01-23',10,0.00,1300.00);

DESCRIBE DEPARTMENT;
DESCRIBE EMPLOYEE;

SELECT DISTINCT Job_type
FROM EMPLOYEE;

SELECT CONCAT(Ename, ', ', Job_type) AS Name_Job
FROM EMPLOYEE;

SELECT CONCAT_WS(', ', Eno, Ename, Job_type, Manager, Hire_date, Dno, Commission, Salary) AS THE_OUTPUT
FROM EMPLOYEE;

SELECT Ename, Salary
FROM EMPLOYEE
WHERE Salary > 2850.00;




