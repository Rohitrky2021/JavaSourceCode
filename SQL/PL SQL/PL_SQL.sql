-- You've provided several PL/SQL code snippets and SQL queries. Let's review them:

-- PL/SQL program to display 'Hello, World!':
 
DECLARE
  message VARCHAR2(20) := 'Hello, World!';
BEGIN
  DBMS_OUTPUT.PUT_LINE(message);
END;
 

-- PL/SQL program with subtypes and variables:
 
DECLARE
  SUBTYPE name IS CHAR(20);
  SUBTYPE message IS VARCHAR2(100);
  salutation name;
  greetings message;
BEGIN
  salutation := 'Reader ';
  greetings := 'Welcome to the World of PL/SQL';
  DBMS_OUTPUT.PUT_LINE('Hello ' || salutation || greetings);
END;

 
-- PL/SQL program for arithmetic operations:
 
DECLARE
  a INTEGER := 10;
  b INTEGER := 20;
  c INTEGER;
  f REAL;
BEGIN
  c := a + b;
  DBMS_OUTPUT.PUT_LINE('Value of c: ' || c);
  f := 70.0 / 3.0;
  DBMS_OUTPUT.PUT_LINE('Value of f: ' || f);
END;
 

-- Nested PL/SQL blocks with inner and outer variables:
DECLARE
  -- Global variables
  num1 NUMBER := 95;
  num2 NUMBER := 85;
BEGIN
  DBMS_OUTPUT.PUT_LINE('Outer Variable num1: ' || num1);
  DBMS_OUTPUT.PUT_LINE('Outer Variable num2: ' || num2);
  DECLARE
    -- Local variables
    num1 NUMBER := 195;
    num2 NUMBER := 185;
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Inner Variable num1: ' || num1);
    DBMS_OUTPUT.PUT_LINE('Inner Variable num2: ' || num2);
  END;
END;
/

-- SQL commands to create a table (CUSTOMERS) and insert data:
CREATE TABLE CUSTOMERS (
  ID INT NOT NULL,
  NAME VARCHAR(20) NOT NULL,
  AGE INT NOT NULL,
  ADDRESS CHAR(25),
  SALARY DECIMAL(18, 2),
  PRIMARY KEY (ID)
);

-- INSERT statements
INSERT INTO CUSTOMERS (ID, NAME, AGE, ADDRESS, SALARY)
VALUES (1, 'Ramesh', 32, 'Ahmedabad', 2000.00);

-- Repeat INSERT statements for other records
-- PL/SQL program to retrieve data from the CUSTOMERS table:
 
DECLARE
  c_id CUSTOMERS.ID%TYPE := 1;
  c_name CUSTOMERS.NAME%TYPE;
  c_addr CUSTOMERS.ADDRESS%TYPE;
  c_sal CUSTOMERS.SALARY%TYPE;
BEGIN
  SELECT NAME, ADDRESS, SALARY INTO c_name, c_addr, c_sal
  FROM CUSTOMERS
  WHERE ID = c_id;
  DBMS_OUTPUT.PUT_LINE('Customer ' || c_name || ' from ' || c_addr || ' earns ' || c_sal);
END;
/
-- PL/SQL program for calculating factorial:
DECLARE
  num NUMBER := 6;
  fact NUMBER := 1;
  temp NUMBER;

BEGIN
  temp := num;
  WHILE (temp > 0) LOOP
    fact := fact * temp;
    temp := temp - 1;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE('Factorial of ' || num || ' is ' || fact);
END;
/

-- PL/SQL program to print a pattern:
DECLARE
  n NUMBER := 5;
  i NUMBER;
  j NUMBER;
BEGIN
  FOR i IN 1..n LOOP
    FOR j IN 1..i LOOP
      DBMS_OUTPUT.PUT('*');
    END LOOP;
    DBMS_OUTPUT.NEW_LINE;
  END LOOP;
END;
/

-- Example of a database trigger to track salary changes:
-- CREATE OR REPLACE TRIGGER display_salary_changes
-- (Trigger code not provided)
Example of a loop in PL/SQL:
sql
Copy code
DECLARE
  i INT;
BEGIN
  i := 1;
  LOOP
    IF i > 10 THEN
      EXIT;
    END IF;
    DBMS_OUTPUT.PUT_LINE(i);
    i := i + 1;
  END LOOP;
END;
/
-- These are the PL/SQL programs and SQL queries you've provided. 
-- If you have any specific questions or need further assistance with any of them, please let me know.