Q.) Find all the student who score more than the  Avg of the class 

select name,marks
  from student
 where marks>(select Avg(Marks)
   from student);

-- * Also helpfulll when the data will be Dynamic 


Q2.) Find all the student who score is even 

M1 ->Brute Force 
select name,rollno
  from student
 where rollno in (2,4,6,8);

M2 -> Dynamic One 
 select name,rollno
  from student
 where rollno in (select  rollno 
   from student
  where rollno % 2=0);