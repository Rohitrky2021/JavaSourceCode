--* CASCADING FOR FOREIGN KEY 
-- ON DELETE AND UPDATE 



 Create Table temp1(
 id int,
 name Varchar(50),
 dept_id int unqiue,
 age int default 20 , 
 PRIMARY KEY (id));


Create Table temp2(
 id int,
 dept_id int,
foreign key (dept_id) references temp1(dept_id)
on update CASCADE -- NOw ab in dono m se kissi m bhi change hoga tho dono fk values Related m saath m change hoga 
on delete CASCADE
 );

INSERT into dept 
Values
(101,"english"),
(102,"hindi");

update dept
   set id=103
 where id=102; -- Readm below ye dono m change hoga 

--* NOw if Update the  dept_id of temp1 then auto related dept_id of tem2 will be change 