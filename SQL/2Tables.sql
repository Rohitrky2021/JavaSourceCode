create database college;
create database if not exists college;
-- Ab warning Dega if  Exist 
Use college;

-- primary key waala element ki Values hmesha unqiue honi chahiye 


CREATE TABLE student (
 id INT PRIMARY KEY ,
 name VARCHAR(50),
 age INT NOT NULL
 );
 



 insert INTO student values(1,"Rohit",24);
 insert INTO student values(2,"aman",24);
 
  -- Or in This way 
  insert into student (id,name) values (4,"Rohit");

  
 -- Now to print  
 select * from student;
  show tables;
  --  this show the available one tables data !!;
 show databases
 --  this show the available ones Database Data!!;
 


















--** Having Clause ==> Jha Where nhi lga skte i.e Group by k baad

select COUNT(NAME),City
  from student
 GROUP BY city
 Having max(marks) > 90; -- When  Group p apply krna ho 
--  only answer of that city that have max condn Satisfy


