-- Let 2 tables of Student and other of Cources 

-- Return All Mathched Data With Left table And + All data of Right Table 



select *
  from student as s -- Left table 
 Right join Cources as c -- Right Table 
 on s.id=c.id;