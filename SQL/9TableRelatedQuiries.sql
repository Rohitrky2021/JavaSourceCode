insert into  student
values (101,"rohit",78,"C","Pune");


--* To Update Existing Rows in Table 

-- Q-> College Decide kiya ki ab top waale to A nhi O milega
update student
   set grade="O"
 where grade="A";

update student
   set marks=82
 where rollno=105;

 update student
   set grade="B"
 where marks BETWEEN 80 AND 90;

-- if subka marks incrase krna ho
 update student
   set marks=marks+1;


--* IMP IN sql By Default Safe mode  On HOta h so off k liye have to type following command ;

SET SQL_SAFE_UPDATE=0; --> 1 TO AGAIN OFF UNSAFE
--  O means off 1 means on


--* To Delete Existing Rows in Table 
delete from student
 where marks<33;

 delete from student -- Only This Line se Pura data bhi delete ho skta h tho be carefull
 

