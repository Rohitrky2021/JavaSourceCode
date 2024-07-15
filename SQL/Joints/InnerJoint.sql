-- Let 2 tables of Student and other of Cources 

--  Common data of 2 tables in single table 

select *
  from student
 inner join Cources -- Right cirle m kya bnega uska 
 on student.id=course.id;

-- * Can Use Alias Also==> NAkli naam , when name is bigger an random short name we use 



select *
  from student as s
 inner join Cources as c
 on s.id=c.id;