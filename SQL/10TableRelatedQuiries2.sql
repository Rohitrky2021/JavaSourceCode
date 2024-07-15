--* To Alter (to change the Schema) -->(column ,dataytype,Constrain)

-- 1. Adding A column in Existing Table 
   Alter Table student
   Add column age int ;
   or
   Add column age int not null default 90;

 -- 2. Deleting A column in Existing Table 
   Alter Table student
   drop column age;

 -- 3. Rename A column in Existing Table '
   Alter Table student
   change column age newage;

 -- 3. Rename  Existing Table '
   Alter Table student
   Rename to Stu;

 -- 4. Modify DataType  A column in Existing Table 
    Alter Table student
    Modify age Varchar(2); -- abhi only 2 int tuk aa skta h only 

 --*5. To delete all data of Table 
    --> DROP => delete the Table // Truncate Delete the data of table 
    TRUNCATE Table student;   