Count()
Max()
Min()
sum()
Avg()
-- THey All Return a Single Value

select max(marks)
  from student;

select Count(rollno)--Count the Distinct Roll NUmbers and  return the count 
  from student;

--** GROUP BY CLAUSE

select city,Count(NAME)
  from student
 GROUP By city;

 select city,AVG(Marks)  
  from student
 GROUP By city
--  Order by city; --- jispe  order chahiye ho any can be used 
 Order by AVG(Marks) DESC ;

 -- Class m grade k bases p student ko krna
 
select grade,Count(rollno)
  from student
 GROUP By grade
 order by grade;
