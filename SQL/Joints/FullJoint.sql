in Sql full joint not available
-- so we create by doing 

-- Left Joint  Union Right Joint 

select *
  from student as s -- Left table 
 Left join Cources as c -- Right Table 
 on s.id=c.id;
Union
select *
  from student as s -- Left table 
 Right join Cources as c -- Right Table 
 on s.id=c.id;