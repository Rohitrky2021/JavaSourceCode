create database college;

-- Ab warning Dega if  Exist 
Use college;

-- primary key waala element ki Values hmesha unqiue honi chahiye 
CREATE TABLE student (
 roll INT PRIMARY KEY ,
 name VARCHAR(50),
 marks int not NULL,
 grade VARCHAR(1),
 city VARCHAR(20)
 );

 insert into   (student)
 values (1,"rohit",90,"B","MAU")

 insert into   (student)
 (roll,name,marks,grade,city)
 values 
 (1,"rohit",90,"B","MAU")
 (2,"rohit",90,"B","MAU")

 Select name,marks from student

 select Distinct city from student;

 select *
   into variable
   from student
  where marks>80;

  select *
    into variable
    from student
   where city="MAU";

   
  select *
    into variable
    from student
   where city="MAU" And marks>80;
--    OTher similar operatoers r 
-- Arithmetic ==> +,-,*,/,%
-- comparison ones--> =,!=,>,>=,<=
-- logical operator: AND, OR , NOT , IN , BETWEEN ,ALL , LIKE ,ANY 
-- BITWISE OPERTOR : &(and) , | (OR)

  select *
    into variable
    from student
   where marks BETWEEN 80 and 90;-- both inclusive 

  select *
    into variable
    from student
   where city in ("DElhi","Mumbai");

  select *
    into variable
    from student
   where city NOT in ("DElhi","Mumbai");


--** LIMIT CLAUSE 

SELECT * 
FROM student 
where marks>75
LIMIT 3;-- We Will get the top 3 ones here

--** Order By CLAUSE **
select *
  from student
 Order By city ASc;-- ya DESC
 Limit 3;

 --** GROUP BY CLAUSE

select city
  from student
 GROUP By city;-- Distinct City ko City Column m print kr dega --> With above Queirw if count husa tho

 -- But If Aggreagte use they come with there Count Column
 --** GROUP BY CLAUSE

select city,Count(NAME) -- name ya rollno jiska bhi count lena ho 
  from student
 GROUP By city;

 --**IMP to take care 
 -->Jitna Select m Column h utna Group by m use nhi kiya tho error aa skta  h
 select city,name,Count(NAME) -- name ya rollno jiska bhi count lena ho 
  from student
 GROUP By city;-- here error for name

--  correct one 
 select city,name,Count(NAME) -- name ya rollno jiska bhi count lena ho 
  from student
 GROUP By city,name;