create database Depart;
use Depart;

CREATE TABLE DEPARTMENT (
  Dno INT,
  Dname VARCHAR(50) DEFAULT 'NULL',
  Loc VARCHAR(50) DEFAULT 'New Delhi',
  PRIMARY KEY (Dno)
);

INSERT INTO DEPARTMENT VALUES
  (10, 'ACCOUNTING', 'NEW YORK'),
  (20, 'RESEARCH', 'DALLAS'),
  (30, 'SALES', 'CHICAGO'),
  (40, 'OPERATIONS', 'BOSTON');
 

 
CREATE TABLE EMPLOYEE (
  Eno CHAR(4) NOT NULL,
  Ename VARCHAR(50) NOT NULL,
  Job_type VARCHAR(50) NOT NULL,
  Manager CHAR(4) DEFAULT NULL,
  Hire_date DATE NOT NULL,
  Dno INT DEFAULT NULL,
  Commission DECIMAL(10,2) DEFAULT NULL,
  Salary DECIMAL(7,2) NOT NULL,
  PRIMARY KEY (Eno),
  FOREIGN KEY (Dno) REFERENCES DEPARTMENT (Dno),
  FOREIGN KEY (Manager) REFERENCES EMPLOYEE (Eno)
); 

INSERT INTO EMPLOYEE VALUES
  ('7839', 'King', 'President', NULL, '1981-11-17', 10, 0.00, 5000.00),
  ('7698', 'Blake', 'Manager', '7839', '1981-05-01', 30, 0.00, 2850.00),
  ('7782', 'Clark', 'Manager', '7839', '1981-06-09', 10, 0.00, 2450.00),
  ('7566', 'Jones', 'Manager', '7839', '1981-04-02', 20, 0.00, 2975.00),
  ('7788', 'Scott', 'Analyst', '7566', '1982-12-09', 20, 0.00, 3000.00),
  ('7902', 'Ford', 'Analyst', '7566', '1981-12-03', 20, 0.00, 3000.00),
  ('7369', 'Smith', 'Clerk', '7902', '1980-12-17', 20, 0.00, 800.00),
  ('7499', 'Allen', 'Sales_man', '7698', '1981-02-20', 30, 300.00, 1600.00),
  ('7521', 'Ward', 'Sales_man', '7698', '1981-02-22', 30, 500.00, 1250.00),
  ('7654', 'Martin', 'Sales_man', '7698', '1981-04-22', 30, 1400.00, 1250.00),
  ('7844', 'Turner', 'Sales_man', '7698', '1981-09-08', 30, 0.00, 1500.00),
  ('7900', 'James', 'Clerk', '7698', '1981-12-03', 30, 0.00, 950.00),
  ('7876', 'Adams', 'Clerk', '7788', '1983-01-12', 20, 0.00, 1100.00),
  ('7934', 'Miller', 'Clerk', '7782', '1982-01-23', 10, 0.00, 1300.00);


-- 1.Check the schema of Department Table.
DESCRIBE DEPARTMENT;

-- 3.See the record of Department Table.
select * from DEPARTMENT;

-- 2.Check the schema of Employee table.
DESCRIBE EMPLOYEE;

-- 4.See the record of Employee table.
SELECT * FROM EMPLOYEE;

-- 5.Query to display Employee Name, Job, Hire Date, Employee Number; for each employee with the Employee Number appearing first.
SELECT Eno, Ename, Job_type, Hire_date
FROM EMPLOYEE
ORDER BY Eno;


-- 6.Query to display unique Jobs from the Employee Table.
SELECT DISTINCT Job_type FROM EMPLOYEE;

-- 7.Query to display the Employee Name concatenated by a Job separated by a comma.              
SELECT CONCAT(Ename, ', ', Job_type) AS Name_Job FROM EMPLOYEE;
SELECT CONCAT(Ename ,',' , Job_type) AS Name_Job FROM EMPLOYEE;




-- 9.Query to display the Employee Name and Salary of all the employees earning more than $2850.
SELECT Ename AS Employee_Name, Salary
FROM EMPLOYEE
WHERE Salary > 2850;
 
-- 8.Query to display all the data from the Employee Table. Separate each Column by a comma and name the said column as THE_OUTPUT. 

SELECT CONCAT(Eno , ', ', Ename, ',', Job_type, ', ',Manager, ',' ,Hire_date, ',' ,Dno, ',' ,Commission, ',' ,Salary) AS THE_OUTPUT FROM EMPLOYEE;

SELECT CONCAT(Eno, ', ', Ename, ', ', Job_type, ', ', Manager, ', ', Hire_date, ', ', Dno, ', ', Commission, ', ', Salary) AS THE_OUTPUT
FROM EMPLOYEE;



-- https://www.geeksforgeeks.org/find-nth-highest-salary-table/w