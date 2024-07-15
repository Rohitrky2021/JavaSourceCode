create database Waterways;
use Waterways;

create table Sailors(
SID int,
SNAME varchar(50) default 'NULL',
AGE int ,
RATING int,
primary key(SID)
);

INSERT INTO Sailors (SID, SNAME, AGE, RATING)
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

select * from Sailors;

CREATE TABLE Reserves (
    SID INT,
    BID INT,
    DAY DATE,
    FOREIGN KEY (SID) 
    REFERENCES Sailors(SID)
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

CREATE TABLE Boat_Table (
    BID INT PRIMARY KEY,
    BNAME VARCHAR(255),
    COLOR VARCHAR(255)
);

INSERT INTO Boat_Table (BID, BNAME, COLOR)
VALUES
(101, 'Interlake', 'Blue'),
(102, 'Interlake', 'Red'),
(103, 'Clipper', 'Green'),
(104, 'Marine', 'Red'),
(105, 'Patratu', 'Blue'),
(106, 'Patratu', 'Red');

-- Task 3;
select * from Sailors;
select * from Reserves;
select * from Boat_Table;

-- Task 4;
SELECT S.SNAME
FROM Sailors S
JOIN Reserves R ON S.SID = R.SID
WHERE R.BID = 103;

-- Task 5;
SELECT S.SNAME
FROM Sailors S
JOIN Reserves R ON S.SID = R.SID
JOIN Boat_Table BC ON R.BID = BC.BID
WHERE BC.COLOR = 'Red';


-- Task 6;
SELECT S.SNAME, S.AGE
FROM Sailors S
WHERE S.AGE = (SELECT MAX(AGE) FROM Sailors);

-- Task 7;
SELECT COUNT(*) AS TotalSailors
FROM Sailors;

-- Task 8;
SELECT COUNT(DISTINCT SNAME) AS NumberOfDifferentSailorNames
FROM Sailors;

-- Task 9;
SELECT S.SNAME
FROM Sailors S
LEFT JOIN Reserves R ON S.SID = R.SID
LEFT JOIN Boat_Table BC ON R.BID = BC.BID AND BC.COLOR = 'Red'
WHERE BC.BID IS NULL;


-- Task 10;
SELECT S.SNAME
FROM Sailors S
LEFT JOIN Reserves R ON S.SID = R.SID AND R.BID = 103
WHERE R.SID IS NULL;

-- Task 11;
SELECT DISTINCT S.SNAME
FROM Sailors S
JOIN Reserves R ON S.SID = R.SID
JOIN Boat_Table BC ON R.BID = BC.BID
WHERE BC.COLOR IN ('Red', 'Green');

-- Task 12;
SELECT SID
FROM Sailors
WHERE RATING = 10
UNION
SELECT SID
FROM Reserves
WHERE BID = 104;


-- Task 13;
SELECT MIN(AGE) AS MinimumAge
FROM Sailors;

-- Task 14;
SELECT SUM(RATING) AS TotalRating
FROM Sailors;

-- Task 15;
SELECT SID, SNAME
FROM Sailors
WHERE SID = 22
UNION
SELECT SID, SNAME
FROM Sailors
WHERE AGE < 25;

-- Task 16;
SELECT SNAME
FROM Sailors
ORDER BY SNAME ASC;

-- Task 17;
SELECT SID
FROM Sailors
ORDER BY SID DESC;

-- Task 18;
SELECT SID, SNAME, AGE, RATING
FROM Sailors
WHERE AGE > 10
ORDER BY RATING ASC;

-- Task 19;
SELECT COLOR, COUNT(*) AS NumberOfBoats
FROM Boat_Table
GROUP BY COLOR;