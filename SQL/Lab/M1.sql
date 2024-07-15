
INDIAN INSTITUTE OF INFORMATION TECHNOLOGY

Submitted By: Medha Tripathi
Branch: CSE
Group: A
Semester: V
Course: DBMS
Course Code: CS 3001
Submitted To: Dr. Nidhi Kushwaha


LAB ASSIGNMENT 1:

Creating table Employee:
CREATE TABLE Employee (
    EMPLOYEE_ID NUMBER,
    FIRST_NAME CHAR(50),
    LAST_NAME CHAR(50),
    SALARY NUMBER,
    JOINING_DATE CHAR(50),
    DEPARTMENT CHAR(50)
);

insert into Employee values (001, 'Monika', 'Arora', 100000, '2014-02-20 09:00:00','HR');
insert into Employee values (002, 'Niharika', 'Verma', 80000, '2014-06-11 09:00:00','Admin');
insert into Employee values (003, 'Vishal', 'Singhal', 300000, '2014-02-20 09:00:00', 'HR');
insert into Employee values (004, 'Amitabh', 'Singh', 500000, '2014-02-20 09:00:00', 'Admin');
insert into Employee values (005, 'Vivek', 'Bhati', 500000, '2014-06-11 09:00:00', 'Admin');
insert into Employee values (006, 'Vipul', 'Diwan', 200000, '2014-06-11 09:00:00', 'Account');
insert into Employee values (007, 'Satish', 'Kumar', 75000, '2014-01-20 09:00:00', 'Account');
insert into Employee values (008, 'Geetika', 'Chauhan', 90000, '2014-04-11 09:00:00', 'Admin');



Creating table Profit:
CREATE TABLE Profit (
    EMPLOYEE_REF_ID NUMBER,
    PROFIT_DATE DATE,
    PROFIT_AMOUNT NUMBER
);
INSERT INTO Profit VALUES (1, TO_DATE('2016-02-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 5000);
INSERT INTO Profit VALUES (2, TO_DATE('2016-06-11 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 3000);
INSERT INTO Profit VALUES (3, TO_DATE('2016-02-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 4000);
INSERT INTO Profit VALUES (1, TO_DATE('2016-02-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 4500);
INSERT INTO Profit VALUES (2, TO_DATE('2016-06-11 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 3500);




Creating table Category:
create table Category(
Employee_Ref_Id number(3), 
Employee_Title char(20), 
Affected_From char(30));

insert into Category values(1, 'Manager', '2016-02-20 00:00:00');
insert into Category values(2, 'Executive', '2016-06-11 00:00:00');
insert into Category values(8, 'Executive', '2016-06-11 00:00:00');
insert into Category values(5, 'Manager', '2016-06-11 00:00:00');
insert into Category values(4, 'Asst. Manager', '2016-06-11 00:00:00');
insert into Category values(7, 'Executive', '2016-06-11 00:00:00');
insert into Category values(6, 'Lead', '2016-06-11 00:00:00');
insert into Category values(3, 'Lead', '2016-06-11 00:00:00');

For the tables created above, write the SQL queries for the following:
-- 1.Write an SQL query to determine the nth (say n=5) highest salary from a table. 
SELECT DISTINCT SALARY
FROM Employee E1
WHERE 5 = (
    SELECT COUNT(DISTINCT SALARY)
    FROM Employee E2
    WHERE E1.SALARY <= E2.SALARY
);


-- 2.Write an SQL query to determine the 5th highest salary without using the TOP or limit method.
SELECT DISTINCT SALARY
FROM Employee E1
WHERE 5 = (
    SELECT COUNT(DISTINCT SALARY)
    FROM Employee E2
    WHERE E1.SALARY <= E2.SALARY
);


-- 3.Write an SQL query to fetch the list of employees with the same salary. 
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY
FROM Employee
WHERE SALARY IN (SELECT SALARY FROM Employee
    GROUP BY SALARY HAVING COUNT(*) > 1);


-- 4.Write an SQL query to show the second-highest salary from a table. 
SELECT MAX(SALARY) AS SecondHighestSalary
FROM Employee
WHERE SALARY < (
    SELECT MAX(SALARY)
    FROM Employee);


-- 5.Write an SQL query to show one row twice in the results from a table. 
with sort_tab as(
SELECT * FROM Employee 
UNION ALL SELECT * 
FROM Employee) 
SELECT * FROM sort_tab 
WHERE First_Name = 'Vishal'


-- 6.Write an SQL query to fetch intersecting records of two tables. 
SELECT Employee_ID, 
First_Name, 
Last_name 
Department FROM Employee 
intersect select Employee_ID, 
First_Name, Last_name 
FROM Employee;


-- 7.Write an SQL query to fetch the first 50% of records from a table. 
SELECT *
FROM Employee
where Employee_ID <= (
SELECT COUNT(Employee_ID)/2 
FROM Employee);


-- 8.Write an SQL query to fetch the departments that have less than five people in them. 
SELECT DEPARTMENT
FROM Employee
GROUP BY DEPARTMENT
HAVING COUNT(*) < 5;


-- 9.Write an SQL query to show the last record from a table. 
SELECT * FROM (
SELECT * FROM
 Employee ORDER BY 
Employee_ID DESC) 
fetch WHERE ROWNUM=1;


-- 10.Write an SQL query to fetch the first row of a table. 
SELECT * FROM 
Employee fetch 
WHERE ROWNUM=1;

-- 11.Write an SQL query to fetch the last five records from a table. 
SELECT * FROM (
SELECT * FROM Employee 
order by Employee_ID desc) 
fetch WHERE ROWNUM<=5;



-- 12.Write an SQL query to print the name of employees having the highest salary in each department. 
SELECT E.First_Name, 
E.Department FROM Employee 
E WHERE E.Salary in (
SELECT max(Salary) 
FROM Employee GROUP 
BY Department);


-- 13.Write an SQL query to fetch three max salaries from a table. 
SELECT * FROM (
SELECT * FROM Employee 
ORDER BY Salary DESC) 
fetch WHERE ROWNUM<=3;


-- 14.Write an SQL query to fetch three min salaries from a table. 
SELECT * FROM (
SELECT * FROM Employee 
ORDER BY Salary DESC) 
fetch WHERE ROWNUM<=3;


-- 15.Write an SQL query to fetch nth max salaries from a table. 
SELECT * FROM (
SELECT * FROM Employee 
ORDER BY Salary DESC) 
fetch WHERE ROWNUM<=n;

SELECT DISTINCT salary
from employee e1
where n=(select count(DISTINCT Salary) from employee e2 where e1.salary>=e2.salary);



-- 16.Write an SQL query to fetch departments along with the total salaries paid for each of them. 
SELECT DEPARTMENT, SUM(SALARY) AS TotalSalary
FROM Employee
GROUP BY DEPARTMENT;


-- 17.Write an SQL query to fetch the names of employees who earn the highest salary. 
SELECT FIRST_NAME, LAST_NAME
FROM Employee
WHERE SALARY = (SELECT MAX(SALARY) FROM Employee);


-- 18.Write an SQL query to show the top n (say 10) records of a table. 
select * from 
employee where 
ROWNUM<=10;


-- 19.Write an SQL query to clone a new table from another table. 
CREATE TABLE Employee_Clone AS
SELECT *
FROM Employee;




-- 20.Write an SQL query to show only even rows from a table. 
SELECT *
FROM Employee
WHERE MOD(EMPLOYEE_ID, 2) = 0;


-- 21.Write an SQL query to show only odd rows from a table. 
SELECT *
FROM Employee
WHERE MOD(EMPLOYEE_ID, 2) <> 0;


-- 22.Write an SQL query to fetch “FIRST_NAME” from the EMPLOYEE table using the alias name.
SELECT FIRST_NAME AS EMPLOYEE_NAME FROM Employee;


-- 23.Write an SQL query to fetch “FIRST_NAME” from the Employee table in upper case. 
SELECT UPPER(FIRST_NAME) AS UPPER_CASE_FIRST_NAME
FROM Employee;


-- 24.Write an SQL query to fetch unique values of DEPARTMENT from the Employee table. 
SELECT DISTINCT DEPARTMENT
FROM Employee;


-- 25.Write an SQL query to print the first three characters of FIRST_NAME from the Employee table.
SELECT SUBSTR(FIRST_NAME, 1, 3) AS FIRST_THREE_CHARACTERS
FROM Employee;


-- 26.Write an SQL query to find the position of the alphabet (‘a’) in the first name column ‘Amitabh’ from the Employee table. 
SELECT INSTR(FIRST_NAME, 'a') AS 
POSITION_OF_A FROM Employee 
WHERE FIRST_NAME = 'Amitabh';


-- 27.Write an SQL query that fetches the unique values of DEPARTMENT from the Employee table and prints its length. 
SELECT DEPARTMENT, LENGTHB(
TRIM(DEPARTMENT)) AS DEPARTMENT_LENGTH
FROM Employee


-- 28.Write an SQL query to print the FIRST_NAME from the Employee table after replacing ‘a’ with ‘A’. 
SELECT REPLACE(FIRST_NAME, 'a', 'A') AS UPDATED_FIRST_NAME
FROM Employee;


-- 29.Write an SQL query to print the FIRST_NAME and LAST_NAME from the Employee table into a single column COMPLETE_NAME. A space char should separate them. 
SELECT FIRST_NAME || ' ' || LAST_NAME 
AS COMPLETE_NAME
FROM Employee;


-- 30.Write an SQL query to print all Employee details from the Employee table order by FIRST_NAME Ascending and DEPARTMENT Descending. 
SELECT *
FROM Employee
ORDER BY FIRST_NAME ASC, DEPARTMENT DESC;


-- 31.Write an SQL query to print details of employee excluding first names, “Vipul” and “Satish” from the Employee table. 
SELECT *
FROM Employee
WHERE FIRST_NAME NOT IN ('Vipul', 'Satish');


-- 32.Write an SQL query to print details of Employee with DEPARTMENT name as “Admin”. 
SELECT *
FROM Employee
WHERE DEPARTMENT = 'Admin';


-- 33.Write an SQL query to print details of the Employees whose FIRST_NAME contains ‘a’. 
SELECT *
FROM Employee
-- WHERE FIRST_NAME LIKE '%a%’;


-- 34.Write an SQL query to print details of the Workers Employees whose FIRST_NAME ends with ‘h’ and contains six alphabets. 
SELECT *
FROM Employee
WHERE FIRST_NAME LIKE '______h%';


-- 35.Write an SQL query to print details of the Employees whose SALARY lies between 100000 and 500000. 
SELECT *
FROM Employee
WHERE SALARY BETWEEN 100000 AND 500000;


-- 36.Write an SQL query to print details of the Employees who joined in Feb’2014. 
SELECT *
FROM Employee
WHERE JOINING_DATE BETWEEN ('2014-02-01') AND ('2014-02-28');


-- 37.Write an SQL query to fetch worker names with salaries >= 50000 and <= 100000. 
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM Employee
WHERE SALARY BETWEEN 50000 AND 100000;


-- 38.Write an SQL query to print details of the Employees who are also Managers. 
SELECT e.*
FROM Employee e
JOIN Category c ON e.EMPLOYEE_ID = c.EMPLOYEE_REF_ID
WHERE c.EMPLOYEE_TITLE = 'Manager';


-- 39.Write an SQL query to show records from one table that another table does not have. 
SELECT e.*
FROM Employee e
LEFT JOIN Profit p ON e.EMPLOYEE_ID = p.EMPLOYEE_REF_ID
WHERE p.EMPLOYEE_REF_ID IS NULL;


-- 40.Write an SQL query to fetch the count of employees working in the department ‘Admin’
SELECT COUNT(*)
FROM Employee
WHERE DEPARTMENT = 'Admin';
