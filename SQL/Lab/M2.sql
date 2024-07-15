
INDIAN INSTITUTE OF INFORMATION TECHNOLOGY

Submitted By: Medha Tripathi
Branch: CSE
Group: A
Semester: V
Course: DBMS
Course Code: CS 3001
Submitted To: Dr. Nidhi Kushwaha



DBMS LAB ASSIGNMENT 2

Creating Table Sailors:
CREATE TABLE Sailors (
    SID NUMBER,
    SNAME VARCHAR2(50),
    AGE NUMBER,
    RATING NUMBER
);
INSERT INTO Sailors VALUES (22, 'Gagan', 7, 45);
INSERT INTO Sailors VALUES (29, 'Magan', 1, 33);
INSERT INTO Sailors VALUES (31, 'Kite', 8, 55);
INSERT INTO Sailors VALUES (32, 'Andy', 8, 25.5);
INSERT INTO Sailors VALUES (58, 'Rawan', 10, 35);
INSERT INTO Sailors VALUES (64, 'Julia', 7, 35);
INSERT INTO Sailors VALUES (71, 'Zorba', 10, 40);
INSERT INTO Sailors VALUES (74, 'Recordo', 9, 40);
INSERT INTO Sailors VALUES (85, 'Messi', 3, 25.5);
INSERT INTO Sailors VALUES (95, 'Kohli', 3, 63.5);



   

Creating Table Reserves:
CREATE TABLE Reserves (
    SID NUMBER,
    BID NUMBER,
    DAY DATE
);
INSERT INTO Reserves VALUES (22, 101, TO_DATE('10-OCT-22', 'DD-MON-YY'));
INSERT INTO Reserves VALUES (29, 102, TO_DATE('10-OCT-22', 'DD-MON-YY'));
INSERT INTO Reserves VALUES (31, 103, TO_DATE('10-AUG-22', 'DD-MON-YY'));
INSERT INTO Reserves VALUES (32, 104, TO_DATE('10-JUL-23', 'DD-MON-YY'));
INSERT INTO Reserves VALUES (58, 102, TO_DATE('11-OCT-22', 'DD-MON-YY'));
INSERT INTO Reserves VALUES (64, 103, TO_DATE('11-JUN-23', 'DD-MON-YY'));
INSERT INTO Reserves VALUES (71, 104, TO_DATE('11-DEC-22', 'DD-MON-YY'));
INSERT INTO Reserves VALUES (74, 101, TO_DATE('09-MAY-23', 'DD-MON-YY'));
INSERT INTO Reserves VALUES (85, 102, TO_DATE('09-AUG-23', 'DD-MON-YY'));
INSERT INTO Reserves VALUES (95, 104, TO_DATE('09-AUG-23', 'DD-MON-YY'));



Creating Table Boat:
CREATE TABLE Boat (
    BID NUMBER,
    BNAME VARCHAR2(50),
    COLOR VARCHAR2(50)
);
INSERT INTO Boat VALUES (101, 'Interlake', 'Blue');
INSERT INTO Boat VALUES (102, 'Interlake', 'Red');
INSERT INTO Boat VALUES (103, 'Clipper', 'Green');
INSERT INTO Boat VALUES (104, 'Marine', 'Red');
INSERT INTO Boat VALUES (105, 'Patratu', 'Blue');
INSERT INTO Boat VALUES (106, 'Patratu', 'Red');



Perform the following queries on the above tables. 
1.Write an SQL syntax for joining SAILORS, RESERVES, and BOAT tables. 
a.First sailors and reserves then the result should be join with boat 
SELECT *
FROM Sailors
JOIN Reserves ON Sailors.SID = Reserves.SID
JOIN Boat ON Reserves.BID = Boat.BID;

b.First reserves and boat then the result should be join with sailors Use the following concept SELECT * FROM Table1 JOIN Table2 ON Table1.fielda=Table2.fielda JOIN Table3 ON Table2.fieldb = Table3.fieldb 
SELECT *
FROM Reserves
JOIN Boat ON Reserves.BID = Boat.BID
JOIN Sailors ON Sailors.SID = Reserves.SID;


2.Select BNAME which is assigned to at least two BID. 
SELECT BNAME
FROM Boat
GROUP BY BNAME
HAVING COUNT(BID) >= 2;


3.Apply SQL RIGHT JOIN two tables, the RESERVES table and the BOAT table. 
SELECT *
FROM Reserves
RIGHT JOIN Boat ON Reserves.BID = Boat.BID;


4.Apply SQL LEFT JOIN two tables, the SAILORS and the RESERVES table. 
SELECT *
FROM Sailors
LEFT JOIN Reserves ON Sailors.SID = Reserves.SID;


5.Get the complete record (SNAME, DAY) from both tables([SAILORS], [RESERVERS]), if no match is found in any table, then show NULL. 
SELECT SNAME, DAY
FROM Sailors
FULL OUTER JOIN Reserves ON Sailors.SID = Reserves.SID;


6.Write a query to find out the SNAME whose BID is 101, and display it. 
SELECT SNAME FROM Sailors
JOIN Reserves ON Sailors.SID = Reserves.SID
WHERE Reserves.BID = 101;


7.Write down the query to fetch BID which is assigned to the Sailors whose age is less than 5 years. 
SELECT BID
FROM Sailors
JOIN Reserves ON Sailors.SID = Reserves.SID
WHERE Sailors.AGE < 5;


8.Apply SQL FULL JOIN on two tables, the RESERVES table and the BOAT table. 
SELECT *
FROM Reserves
FULL OUTER JOIN Boat ON Reserves.BID = Boat.BID;


9.Write down the query to fetch SID & COLOR who have the same color boat. 
SELECT Sailors.SID, Boat.COLOR
FROM Sailors
JOIN Reserves ON Sailors.SID = Reserves.SID
JOIN Boat ON Reserves.BID = Boat.BID
GROUP BY Sailors.SID, Boat.COLOR
HAVING COUNT(DISTINCT Boat.BID) > 1;


10.Find the name and age of sailor who is having red and blue color boat. 
SELECT SNAME, AGE
FROM Sailors
JOIN Reserves ON Sailors.SID = Reserves.SID
JOIN Boat ON Reserves.BID = Boat.BID
WHERE Boat.COLOR IN ('Red', 'Blue')
GROUP BY SNAME, AGE
HAVING COUNT(DISTINCT Boat.COLOR) = 2;


11.Find the name of boat whose rating is greater than 40. 
SELECT BName
FROM Boat
WHERE BID IN (
    SELECT BID
    FROM Sailors
    WHERE RATING > 40
);


12.Perform the natural join between sailors and reserves 
SELECT *
FROM Sailors
NATURAL JOIN Reserves;


13.Perform the natural join between boat and reserves. 
SELECT * FROM Boat
NATURAL JOIN Reserves;



14.Find the boat name and color which was booked by Gagan. 
SELECT B.BName, B.Color
FROM Sailors S
JOIN Reserves R ON S.SID = R.SID
JOIN Boat B ON R.BID = B.BID
WHERE S.SNAME = 'Gagan';


15.Find the name of boat that was booked in 2023.
SELECT B.BName
FROM Reserves R
JOIN Boat B ON R.BID = B.BID
WHERE TO_CHAR(R.DAY, 'YYYY') = '2023';


16.Apply CHECK constraint on rating attribute that check the ratings should be greater than or equal to 20. 
ALTER TABLE Sailors
ADD CONSTRAINT chk_rating CHECK (RATING >= 20);


17.Apply UNIQUE, NOT NULL constraints on SName and verify it by inserting NULL value in it.
-- UNIQUE constraint
ALTER TABLE Sailors
ADD CONSTRAINT unique_sname UNIQUE (SNAME);


--NOT NULL constraint
ALTER TABLE Sailors
MODIFY (SNAME NOT NULL);

-- Try to insert NULL value to test NOT NULL constraint
INSERT INTO Sailors (SID, SNAME, AGE, RATING)
VALUES (100, NULL, 25, 35);


18.Show the working of followings:
 • ON DELETE CASCADE: if a row of the referenced table is deleted, then all matching rows in the referencing table are deleted. 
• ON DELETE SET NULL: if a row of the referenced table is deleted, then all referencing columns in all matching rows of the referencing table to be set to null. 
• ON DELETE SET DEFAULT: if a row of the referenced table is deleted, then all referencing columns in all matching rows of the referencing table to be set to the column’s default value. 
• ON DELETE RESTRICT: it is prohibited to delete a row of the referenced table if that row has any matching rows in the referencing table. 
• ON DELETE NO ACTION (the default): there is no referential delete action; the referential constraint only specifies a constraint check. 

Syntax: create table ChildTable
( attr1 int not Null, 
attr2_id int not Null, foreign key(attr1) 
references ParentTable(attr3) on delete cascade 
);

1.ON DELETE CASCADE:
CREATE TABLE ParentTable (
    attr3 INT PRIMARY KEY
);

CREATE TABLE ChildTable (
    attr1 INT NOT NULL,
    attr2_id INT NOT NULL,
    FOREIGN KEY (attr1) REFERENCES ParentTable(attr3) ON DELETE CASCADE
);

In this example, if a row in ParentTable is deleted, all matching rows in ChildTable with the corresponding attr1 values will also be automatically deleted.


2.ON DELETE SET NULL
CREATE TABLE ParentTable (
    attr3 INT PRIMARY KEY
);

CREATE TABLE ChildTable (
    attr1 INT,
    attr2_id INT,
    FOREIGN KEY (attr1) REFERENCES ParentTable(attr3) ON DELETE SET NULL
);

If a row in ParentTable is deleted, all corresponding attr1 values in ChildTable will be set to NULL.


3.ON DELETE SET DEFAULT
CREATE TABLE ParentTable (
    attr3 INT PRIMARY KEY
);

CREATE TABLE ChildTable (
    attr1 INT DEFAULT 0,
    attr2_id INT,
    FOREIGN KEY (attr1) REFERENCES ParentTable(attr3) ON DELETE SET DEFAULT);

If a row in ParentTable is deleted, all corresponding attr1 values in ChildTable will be set to the default value of 0 (or any other default value specified).


4.ON DELETE RESTRICT
CREATE TABLE ParentTable (
    attr3 INT PRIMARY KEY
);

CREATE TABLE ChildTable (
    attr1 INT,
    attr2_id INT,
    FOREIGN KEY (attr1) REFERENCES ParentTable(attr3) ON DELETE RESTRICT);

This option restricts the deletion of a row in ParentTable if there are any matching rows in ChildTable.


5.ON DELETE NO ACTION
CREATE TABLE ParentTable (
    attr3 INT PRIMARY KEY
);

CREATE TABLE ChildTable (
    attr1 INT,
    attr2_id INT,
    FOREIGN KEY (attr1) REFERENCES ParentTable(attr3) ON DELETE NO ACTION);

This is the default option. It specifies that no action should be taken if a row in ParentTable is deleted, and it is mainly used for checking referential integrity without any automatic action.