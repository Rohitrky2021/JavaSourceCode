SELECT column(s)
FROM table_name
Where condition --> where Rows p condition lgata or 
GROUP BY column(s)
HAVING condition --> Having Groups p condition lgata or 
ORDER BY colmn(s) ASC
 

insert into  student
values (101,"rohit",78,"C","Pune");

select Distinct city from student;

select city
  from student
 where grade="A"-- Apply to All Row 
 Group by city 
 HAVING Max(marks)>90; -- Apply to all Groups
Order by city ASC 