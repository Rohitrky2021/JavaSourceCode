-- Let 2 tables of Student and other of Cources 

-- Return All Mathched Data With Right table And + All data of Left Table 



select *
  from student as s -- Left table 
 Left join Cources as c -- Right Table 
 on s.id=c.id;