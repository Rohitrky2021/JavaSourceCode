CREATE TABLE Sailors (
    SID INT PRIMARY KEY,
    SNAME VARCHAR(255),
    AGE INT,
    RATING FLOAT
);


-- Insert data into Sailors table
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
    
    

-- Create Reserves table
CREATE TABLE Reserves (
    SID INT,
    BID INT,
    DAY DATE,
    PRIMARY KEY (SID, BID)
);

-- Insert data into Reserves table
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

-- Create Boat table
CREATE TABLE Boat (
    BID INT PRIMARY KEY,
    BName VARCHAR(255),
    Color VARCHAR(255)
);

-- Insert data into Boat table
INSERT INTO Boat (BID, BName, Color)
VALUES
    (101, 'Interlake', 'Blue'),
    (102, 'Interlake', 'Red'),
    (103, 'Clipper', 'Green'),
    (104, 'Marine', 'Red'),
    (105, 'Patratu', 'Blue'),
    (106, 'Patratu', 'Red');
    
    desc sailors;
    desc Boat;
    desc reserves;
    select BName from Boat where BID=103;
    select BName from Boat where BID!=103;
    select BName from Boat where Color='Red';
    select BName from Boat where Color='Red' or Color='Green';
    
    select min(age) from sailors;
    select count(Rating) from sailors;
    select SID,SNAME from sailors where SID=22 or age<25;
    select SNAME from sailors order by SNAME ASC;
    select SID from sailors order by SID desc;
    select Rating from sailors WHERE AGE>10 order by rating asc  ;
    select count(Color) from Boat;
    select BName from Boat where Color!='Red';
    select SNAME,AGE  from sailors WHERE age =10;
    select count(SID) from Sailors;
    select count(SNAME) from Sailors;