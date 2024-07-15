
create database collg;
use collg;

-- Default ka yhi use h ki if Not given then Assign that value

  Create Table temp1(
 id int,
 name Varchar(50),
 age int default 20 , 
 PRIMARY KEY (id,name)
 );
 
 Create Table temp3(
 id int,
salary int default 2000
 );

 insert into temp3 (id) values (2);
  select * from temp3;
 
Create Table temp2(
 id int,
foreign key (id) references temp1(id)
 );
 
 -- Constrains for Check ---->can  limit the values Allowed in Cloumn 
 Create Table temp4(
 id int,
 name Varchar(50),
 age int default 20 , 
Constraint agecheck check (age>=18  AND name="Delhi")
 );
 
  Create Table temp5(
 age int check(age>=18)
 )
   
 
 select * from temp1,temp2;
 