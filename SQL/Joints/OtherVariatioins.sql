to find for 
1. A-B 
select *
  from student as s -- Left table 
 Left join Cources as c -- Right Table 
 on s.id=c.id;
 where c.id is null;


2.B-A 
select *
  from student as s -- Left table 
 Right join Cources as c -- Right Table 
 on s.id=c.id;
  where s.id is null;


3. to remove only the intersection Part 
Union the Above two 

select *
  from student as s -- Left table 
 Left join Cources as c -- Right Table 
 on s.id=c.id;
 where c.id is null;
Union 
select *
  from student as s -- Left table 
 Right join Cources as c -- Right Table 
 on s.id=c.id;
  where s.id is null;
