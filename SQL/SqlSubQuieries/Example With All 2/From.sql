Q1.) Find MAx Marks from Student OF delhi  

select MAx(marks)
  from (select * from student where city="Delhi") as temp;

M2--> Easy one

select Max(marks)
  from student
 where city="Delhi";
