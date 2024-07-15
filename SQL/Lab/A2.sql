CREATE DATABASE IF NOT EXISTS Sail;

USE Sail;

CREATE TABLE Sailors (
  SID INT PRIMARY KEY,
  SNAME VARCHAR(50),
  AGE INT,
  RATING DECIMAL(5, 2)
);

INSERT INTO Sailors VALUES
  (22, 'Gagan', 7, 45),
  (29, 'Magan', 1, 33),
  (31, 'Kite', 8, 55),
  (32, 'Andy', 8, 25.5),
  (58, 'Rawan', 10, 35),
  (64, 'Julia', 7, 35),
  (71, 'Zorba', 10, 40),
  (74, 'Recordo', 9, 40),
  (85, 'Messi', 3, 25.5),
  (95, 'Kohli', 3, 63.5);

CREATE TABLE Reserves (
  SID INT,
  BID INT,
  DAY DATE,
  PRIMARY KEY (SID, BID),
  FOREIGN KEY (SID) REFERENCES Sailors(SID)
  
);
ALTER TABLE Reserves
ADD CONSTRAINT fk_bid
FOREIGN KEY (BID) REFERENCES Boat(BID);

truncate table Reserves;
DROP TABLE Reserves;

CREATE TABLE IF NOT EXISTS Reserves (
    SID INT,
    BID INT,
    DAY VARCHAR(10),
    FOREIGN KEY (SID) REFERENCES Sailors(SID),
    FOREIGN KEY (BID) REFERENCES Boat(BID)
);


INSERT INTO Reserves VALUES
  (22, 101, '2022-10-10'),
  (29, 102, '2022-10-10'),
  (31, 103, '2022-08-10'),
  (32, 104, '2023-07-10'),
  (58, 102, '2022-10-11'),
  (64, 103, '2023-06-11'),
  (71, 104, '2022-12-11'),
  (74, 101, '2023-05-09'),
  (85, 102, '2023-08-09'),
  (95, 104, '2023-08-09');

CREATE TABLE Boat (
  BID INT PRIMARY KEY,
  BNAME VARCHAR(50),
  COLOR VARCHAR(50)
);

INSERT INTO Boat VALUES
  (101, 'Interlake', 'Blue'),
  (102, 'Interlake', 'Red'),
  (103, 'Clipper', 'Green'),
  (104, 'Marine', 'Red'),
  (105, 'Patratu', 'Blue'),
  (106, 'Patratu', 'Red');

-- 2.Describe the schema of all the three relations.
DESCRIBE Sailors;
DESCRIBE Reserves;
DESCRIBE Boat;

-- 3.Formulate a query for selecting all the record one by one from all the three relations.
SELECT * FROM Sailors;
SELECT * FROM Reserves;
SELECT * FROM Boat;

-- 4.From the above given boat table find the names of sailors who have reserved boat 103.
SELECT S.SNAME
FROM Sailors S
JOIN Reserves R ON S.SID = R.SID
WHERE R.BID = 103;

SELECT SNAME FROM Sailors WHERE SID IN (SELECT SID FROM Reserves WHERE BID = 103);

-- 5.From the above given boat table find the names of sailors who have reserved a red boat.
SELECT DISTINCT SNAME FROM Sailors WHERE SID IN (SELECT SID FROM Reserves WHERE BID IN (SELECT BID FROM Boat WHERE Color = 'Red'));
SELECT DISTINCT S.SNAME
FROM Sailors S
JOIN Reserves R ON S.SID = R.SID
JOIN Boat B ON R.BID = B.BID
WHERE B.COLOR = 'Red';

-- 6.From the above given sailors table find the name and age of the oldest sailors.
SELECT SNAME, AGE FROM Sailors WHERE AGE = (SELECT MAX(AGE) FROM Sailors);
SELECT SNAME, AGE
FROM Sailors
WHERE AGE = (SELECT MAX(AGE) FROM Sailors);

-- 7.From the above given sailors table count the number of sailors.
SELECT COUNT(*) AS Sailor_Count FROM Sailors;
SELECT COUNT(*) FROM Sailors; 
SELECT COUNT(*) AS NumOfSailors
FROM Sailors;

-- 8.From the above given sailors table count the number of different sailors names.

 SELECT COUNT(DISTINCT SNAME) AS NumOfDistinctNames
FROM Sailors;
SELECT COUNT(DISTINCT SNAME) AS Unique_Sailor_Names FROM Sailors;
SELECT COUNT(DISTINCT SNAME) FROM Sailor;

-- From the Sailors table, find the names of sailors who have not reserved a red boat:

 SELECT SNAME FROM Sailor WHERE SID NOT IN (SELECT SID FROM Reserves WHERE BID IN (SELECT BID FROM Boat WHERE Color = 'Red'));
SELECT DISTINCT S.SNAME
FROM Sailors S
LEFT JOIN Reserves R ON S.SID = R.SID
LEFT JOIN Boat B ON R.BID = B.BID AND B.COLOR = 'Red'
WHERE B.BID IS NULL;

SELECT S.SNAME
FROM Sailors S
WHERE S.SID NOT IN (
    SELECT R.SID
    FROM Reserves R
    JOIN Boat B ON R.BID = B.BID
    WHERE B.COLOR = 'Red'
);

-- From the Sailors table, find the names of sailors who have not reserved Boat 103:
SELECT DISTINCT S.SNAME
FROM Sailors S
LEFT JOIN Reserves R ON S.SID = R.SID AND R.BID = 103
WHERE R.BID IS NULL;

SELECT S.SNAME
FROM Sailors S
WHERE S.SID NOT IN (
    SELECT R.SID
    FROM Reserves R
    WHERE R.BID = 103
);
SELECT SNAME FROM Sailor WHERE SID NOT IN (SELECT SID FROM Reserves WHERE BID = 103);

 -- Find the names of sailors who have reserved a red or a green boat:
 SELECT DISTINCT S.SNAME
FROM Sailors S
JOIN Reserves R ON S.SID = R.SID
JOIN Boat B ON R.BID = B.BID
WHERE B.COLOR IN ('Red', 'Green');

SELECT DISTINCT S.SNAME FROM Sailor S JOIN Reserves R ON S.SID = R.SID JOIN Boat B ON R.BID = B.BID WHERE B.Color IN ('Red', 'Green');

SELECT S.SNAME
FROM Sailors S
JOIN Reserves R ON S.SID = R.SID
JOIN Boat B ON R.BID = B.BID
WHERE B.COLOR IN ('Red', 'Green');

-- Find all SID of sailors who have a rating of 10 or have reserved Boat 104:
SELECT SID FROM Sailor WHERE RATING = 10 OR SID IN (SELECT SID FROM Reserves WHERE BID = 104); 

SELECT S.SID
FROM Sailors S
WHERE S.RATING = 10
UNION
SELECT R.SID
FROM Reserves R
WHERE R.BID = 104;


SELECT DISTINCT S.SID
FROM Sailors S
LEFT JOIN Reserves R ON S.SID = R.SID AND R.BID = 104
WHERE S.RATING = 10 OR R.BID IS NOT NULL;

-- Find the minimum age of the sailor:
SELECT MIN(AGE) FROM Sailor;
SELECT MIN(AGE) AS MinAge
FROM Sailors; 
SELECT MIN(AGE) AS Minimum_Age FROM Sailors;

-- Find the sum of the ratings of sailors:
SELECT SUM(RATING) AS TotalRating
FROM Sailors;
SELECT SUM(RATING) FROM Sailor;
SELECT SUM(RATING) AS Total_Rating FROM Sailors;

-- Find the IDs and names of sailors who have reserved ID 22 or are under 25 years old:
SELECT S.SID, S.SNAME
FROM Sailors S
JOIN Reserves R ON S.SID = R.SID
WHERE S.SID = 22 OR S.AGE < 25;

SELECT SID, SNAME FROM Sailor WHERE SID = 22 OR AGE < 25;
 
SELECT SID, SNAME
FROM Sailors
WHERE SID = 22 OR AGE < 25;
-- List all sailors' names in ascending order:
SELECT SNAME
FROM Sailors
ORDER BY SNAME ASC;
SELECT SNAME FROM Sailor ORDER BY SNAME ASC;

SELECT SNAME
FROM Sailors
ORDER BY SNAME ASC;
-- List all sailors' SIDs in descending order:
SELECT SID
FROM Sailors
ORDER BY SID DESC;

SELECT SID FROM Sailor ORDER BY SID DESC; 

SELECT SID
FROM Sailors
ORDER BY SID DESC;
-- Display the ratings in increasing order for those whose age is greater than 10:

SELECT RATING
FROM Sailors
WHERE AGE > 10
ORDER BY RATING ASC;
SELECT RATING FROM Sailor WHERE AGE < 10 ORDER BY RATING ASC;
 
SELECT RATING
FROM Sailors
WHERE AGE > 10
ORDER BY RATING ASC;

-- Count the number of boats of different colors:
SELECT Color, COUNT(*) AS Count FROM Boat GROUP BY Color;
SELECT COLOR, COUNT(*) AS NumOfBoats
FROM Boat
GROUP BY COLOR;
 
SELECT COLOR, COUNT(*) AS Color_Count
FROM Boat
GROUP BY COLOR;



-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> A3==named 4  

--1 SQL syntax for joining SAILORS, RESERVES, and BOAT tables:

-- a. First, join SAILORS and RESERVES, then join the result with BOAT:
 
SELECT *
FROM Sailors
JOIN Reserves ON Sailors.SID = Reserves.SID
JOIN Boat ON Reserves.BID = Boat.BID;
-- b. First, join RESERVES and BOAT, then join the result with SAILORS:
 
SELECT *FROM Reserves
JOIN Boat ON Reserves.BID = Boat.BID
JOIN Sailors ON Sailors.SID = Reserves.SID;

-- 2. Select BNAME that is assigned to at least two BIDs:
 
SELECT BName
FROM Boat
WHERE BID IN (
    SELECT BID
    FROM Reserves
    GROUP BY BID
    HAVING COUNT(*) >= 2
);
-- Apply SQL RIGHT JOIN on two tables, the RESERVES table and the BOAT table:
 
SELECT *
FROM Reserves
RIGHT JOIN Boat ON Reserves.BID = Boat.BID;
-- Apply SQL LEFT JOIN on two tables, the SAILORS and the RESERVES table:
 
SELECT *
FROM Sailors
LEFT JOIN Reserves ON Sailors.SID = Reserves.SID;
-- Get the complete record (SNAME, DAY) from both tables (SAILORS and RESERVES). If no match is found in any table, then show NULL:
 
-- SELECT S.SNAME, R.DAY
-- FROM Sailors S
-- FULL JOIN Reserves R ON S.SID = R.SID;

SELECT COALESCE(S.SNAME, NULL) AS SNAME, R.DAY
FROM Sailors S
LEFT JOIN Reserves R ON S.SID = R.SID

UNION

SELECT NULL AS SNAME, R.DAY
FROM Sailors S
RIGHT JOIN Reserves R ON S.SID = R.SID;

-- Write a query to find the SNAME of the sailor whose BID is 101 and display it:
 
SELECT S.SNAME
FROM Sailors S
JOIN Reserves R ON S.SID = R.SID
WHERE R.BID = 101;
-- Write a query to fetch BID assigned to sailors whose age is less than 5 years:
 
SELECT R.BID
FROM Reserves R
JOIN Sailors S ON R.SID = S.SID
WHERE S.AGE < 5;
-- Apply SQL FULL JOIN on two tables, the RESERVES table and the BOAT table:
 
SELECT *
FROM Reserves
FULL JOIN Boat ON Reserves.BID = Boat.BID;
-- Write a query to fetch SID and COLOR of boats that have the same color:
 
SELECT B1.BID AS BID1, B2.BID AS BID2, B1.COLOR
FROM Boat B1
JOIN Boat B2 ON B1.COLOR = B2.COLOR AND B1.BID < B2.BID;
-- Find the name and age of the sailor who has reserved both red and blue color boats:
 
SELECT S.SNAME, S.AGE
FROM Sailors S
WHERE S.SID IN (
    SELECT R.SID
    FROM Reserves R
    JOIN Boat B ON R.BID = B.BID
    WHERE B.COLOR IN ('Red', 'Blue')
    GROUP BY R.SID
    HAVING COUNT(DISTINCT B.COLOR) = 2
);

-- Find the name of the boat whose rating is greater than 40:
 
SELECT B.BName
FROM Boat B
JOIN Reserves R ON B.BID = R.BID
JOIN Sailors S ON R.SID = S.SID
WHERE S.RATING > 40;
-- Perform a natural join between Sailors and Reserves:
 
SELECT *
FROM Sailors
NATURAL JOIN Reserves;
-- Perform a natural join between Boat and Reserves:
 
SELECT *
FROM Boat
NATURAL JOIN Reserves;
-- Find the boat name and color that was booked by Gagan:
 
SELECT B.BName, B.Color
FROM Boat B
JOIN Reserves R ON B.BID = R.BID
JOIN Sailors S ON R.SID = S.SID
WHERE S.SNAME = 'Gagan';
-- Find the name of the boat that was booked in 2023:
 
SELECT B.BName
FROM Boat B
JOIN Reserves R ON B.BID = R.BID
WHERE YEAR(R.DAY) = 2023;
-- Apply a CHECK constraint on the rating attribute that checks that ratings should be greater than or equal to 20:
 
ALTER TABLE Sailors
ADD CONSTRAINT CHK_Rating CHECK (RATING >= 20);
-- Apply UNIQUE and NOT NULL constraints on SNAME and verify it by inserting a NULL value:
 
ALTER TABLE Sailors
ADD CONSTRAINT UNIQUE_SNAME UNIQUE (SNAME),
ADD CONSTRAINT NOT_NULL_SNAME CHECK (SNAME IS NOT NULL);
-- Try to insert NULL value
INSERT INTO Sailors (SID, SNAME, AGE, RATING) VALUES (100, NULL, 25, 30);


-- Show the working of the following ON DELETE actions:
 
-- Create the tables and relationships with ON DELETE actions
CREATE TABLE ParentTable (
    ParentID INT PRIMARY KEY
);

CREATE TABLE ChildTable (
    ChildID INT PRIMARY KEY,
    ParentID INT,
    FOREIGN KEY (ParentID) REFERENCES ParentTable(ParentID)
        ON DELETE CASCADE
);

CREATE TABLE ChildTableSetNull (
    ChildID INT PRIMARY KEY,
    ParentID INT,
    FOREIGN KEY (ParentID) REFERENCES ParentTable(ParentID)
        ON DELETE SET NULL
);

-- Create ChildTableSetDefault
CREATE TABLE ChildTableSetDefault (
    ChildID INT PRIMARY KEY,
    ParentID INT DEFAULT 0, -- Set the default value as needed
    FOREIGN KEY (ParentID) REFERENCES ParentTable(ParentID)
        ON DELETE SET NULL
);

-- Populate the ParentTable and ChildTable
INSERT INTO ParentTable (ParentID) VALUES (1), (2), (3);
INSERT INTO ChildTable (ChildID, ParentID) VALUES (10, 1), (11, 2), (12, 3);

-- Perform actions
-- ON DELETE CASCADE: Delete the parent, and all matching rows in the child table are deleted.
DELETE FROM ParentTable WHERE ParentID = 1;
-- ON DELETE SET NULL: Delete the parent, and set the ParentID to NULL in the child table.
DELETE FROM ParentTable WHERE ParentID = 2;
-- ON DELETE SET DEFAULT: Delete the parent, and set the ParentID to its default value in the child table.
DELETE FROM ParentTable WHERE ParentID = 3;

