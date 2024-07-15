drop  table student;
create database college;
use college;

-- primary key waala element ki Values hmesha unqiue honi chahiye && Not Null 
-- It will be one 
-- And IMP jo Column Ek table ka dusre m Primary key hota h --> Wo Foreign Key hota h 
-- It can be Multiple FK + have duplicates + Null values too 
CREATE TABLE if not exists student (
 id INT PRIMARY KEY ,
 name VARCHAR(50)
 );
 
 insert into student
 (id,name)
 values
 (1,"Rohit"),
 (2,"Ro"),
 (3,"Roh");
 
 -- Or in This way 
  insert into student (id,name) values (4,"Rohit");
  
  
   -- Constrains ==>
   -- one More Can use is == col1 int NOT Null  in id place 
  Create Table temp1(
 id int unique
 );
 
 insert into temp1 values(10);
 -- Duplicate Not Allow So Now Show Error  But
 -- IMP we can make 2 columns values combonation or pair as New primary KEy 
  insert into temp1 values(10);
  
  Create Table temp2(
 id int,
 name Varchar(50),
 age int ,
 PRIMARY KEY (id,name)
 );
 -- Direct Mean ki id can same be same , name can be same but the pair of both cant be same 
 
 
  select * from temp1



 
 
 
 
 
 
 