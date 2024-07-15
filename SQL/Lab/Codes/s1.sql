Q1.
CREATE DATABASE IF NOT EXISTS Sail;

USE Sail;

CREATE TABLE Sailor (
    SID INT AUTO_INCREMENT PRIMARY KEY,
    SNAME VARCHAR(255) NOT NULL,
    AGE INT,
    RATING DECIMAL(5, 2)
);
INSERT INTO Sailor (SID, SNAME, AGE, RATING)
VALUES
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
    
CREATE TABLE IF NOT EXISTS Reserves (
    SID INT,
    BID INT,
    DAY VARCHAR(10),
    FOREIGN KEY (SID) REFERENCES Sailor(SID),
    FOREIGN KEY (BID) REFERENCES Boat(BID)
);

INSERT INTO Reserves (SID, BID, DAY)
VALUES
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
    
CREATE TABLE IF NOT EXISTS Boat (
    BID INT PRIMARY KEY,
    BName VARCHAR(255) NOT NULL,
    Color VARCHAR(50)
);

INSERT INTO Boat (BID, BName, Color)
VALUES
    (101, 'Interlake', 'Blue'),
    (102, 'Interlake', 'Red'),
    (103, 'Clipper', 'Green'),
    (104, 'Marine', 'Red'),
    (105, 'Patratu', 'Blue'),
    (106, 'Patratu', 'Red');



-- 3.	Formulate a query for selecting all the record one by one from all the three relations.
SELECT * FROM Sailor;
SELECT * FROM Boat;
SELECT * FROM Reserves;
-- 4.	From the above given boat table find the names of sailors who have reserved boat 103.
SELECT SNAME FROM Sailor WHERE SID IN (SELECT SID FROM Reserves WHERE BID = 103);
-- 5.	From the above given boat table find the names of sailors who have reserved a red boat.
SELECT DISTINCT SNAME FROM Sailor WHERE SID IN (SELECT SID FROM Reserves WHERE BID IN (SELECT BID FROM Boat WHERE Color = 'Red'));
-- 6.	From the above given sailors table find the name and age of the oldest sailors.
SELECT SNAME, AGE FROM Sailor WHERE AGE = (SELECT MAX(AGE) FROM Sailor);
-- 7 Count the number of sailors:
SELECT COUNT(*) FROM Sailor;
-- 8 Count the number of different sailors' names:
SELECT COUNT(DISTINCT SNAME) FROM Sailor;
-- 9 Find the names of sailors who have not reserved a red boat:
SELECT SNAME FROM Sailor WHERE SID NOT IN (SELECT SID FROM Reserves WHERE BID IN (SELECT BID FROM Boat WHERE Color = 'Red'));
-- 10 Find the names of sailors who have not reserved boat 103:
SELECT SNAME FROM Sailor WHERE SID NOT IN (SELECT SID FROM Reserves WHERE BID = 103);
-- 11 Find the names of sailors who have reserved a red or a green boat:
SELECT DISTINCT S.SNAME FROM Sailor S JOIN Reserves R ON S.SID = R.SID JOIN Boat B ON R.BID = B.BID WHERE B.Color IN ('Red', 'Green');
-- 12 Find the SIDs of sailors who have a rating of 10 or have reserved boat 104:
SELECT SID FROM Sailor WHERE RATING = 10 OR SID IN (SELECT SID FROM Reserves WHERE BID = 104);
-- 13 Find the minimum age of the sailor:
SELECT MIN(AGE) FROM Sailor;
-- 14 Find the sum of the ratings of sailors:
SELECT SUM(RATING) FROM Sailor;
-- 15 Find the IDs and names of sailors who have reserved ID 22 or are under 25 years old:
SELECT SID, SNAME FROM Sailor WHERE SID = 22 OR AGE < 25;
-- 16 List all sailor names in ascending order:
SELECT SNAME FROM Sailor ORDER BY SNAME ASC;
-- 17 List all sailor SIDs in descending order:
SELECT SID FROM Sailor ORDER BY SID DESC;
-- 18 Display ratings in increasing order for those whose age is greater than 10:
SELECT RATING FROM Sailor WHERE AGE < 10 ORDER BY RATING ASC;
-- 19 Count the number of boats of different colors:
SELECT Color, COUNT(*) AS Count FROM Boat GROUP BY Color;

Q2.
use Waterways;

-- Task 1 a;
SELECT *
FROM Sailors
JOIN Reserves ON Sailors.SID = Reserves.SID
JOIN Boat_Table ON Reserves.BID = Boat_Table.BID;

-- Task 2 b;
SELECT *
FROM Reserves
JOIN Boat_Table ON Reserves.BID = Boat_Table.BID
JOIN Sailors ON Reserves.SID = Sailors.SID;

-- Task 2;
SELECT BNAME
FROM Boat_Table
GROUP BY BNAME
HAVING COUNT(BID) >= 2;

-- Task 3;
SELECT *
FROM Reserves
RIGHT JOIN Boat_Table ON Reserves.BID = Boat_Table.BID;

-- Task 4;
SELECT *
FROM Sailors
LEFT JOIN Reserves ON Sailors.SID = Reserves.SID;

-- Task 5;

SELECT S.SNAME, R.DAY
FROM Sailors S
LEFT JOIN Reserves R ON S.SID = R.SID
UNION ALL

SELECT NULL AS SNAME, R.DAY
FROM Reserves R
LEFT JOIN Sailors S ON S.SID = R.SID
WHERE S.SID IS NULL;

-- Task 6;
SELECT S.SNAME
FROM Sailors S
JOIN Reserves R ON S.SID = R.SID
WHERE R.BID = 101;

-- Task 7;
SELECT DISTINCT R.BID
FROM Sailors S
JOIN Reserves R ON S.SID = R.SID
WHERE S.AGE < 5;

-- Task 8;

SELECT R., B.
FROM Reserves R
LEFT JOIN Boat_Table B ON R.BID = B.BID
UNION ALL
SELECT R., B.
FROM Reserves R
RIGHT JOIN Boat_Table B ON R.BID = B.BID
WHERE R.BID IS NULL;