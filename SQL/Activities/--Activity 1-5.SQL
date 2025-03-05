--Activity 1
DROP TABLE salesman;
CREATE TABLE salesman(salesman_id int, salesman_name varchar(32),salesman_city varchar(32), commission int);
DESCRIBE salesman;

--Activity 2
INSERT ALL 
INTO salesman VALUES (5001,'James Hoog', 'New York', 15)
INTO salesman VALUES (5002,'Nail Knite', 'Paris', 13)
INTO salesman VALUES (5005,'Pit Alex' , 'London', 11)
INTO salesman VALUES (5006,'McLyon', 'Paris', 14)
INTO salesman VALUES (5007,'Paul Adam' , 'Rome', 13)
INTO salesman VALUES (5003,'Lauson Hen', 'San Jose', 12)
SELECT 1 FROM DUAL;
SELECT * FROM salesman;

--Activity 3
--Show data from the salesman_id and salesman_city columns
SELECT salesman_id, salesman_city FROM salesman;
--Show data of salesman from Paris
SELECT * FROM salesman WHERE salesman_city='Paris';
-- Show salesman_id and commission of Paul Adam
SELECT salesman_id, commission FROM salesman WHERE salesman_name='Paul Adam';

--Activity 4
 --Add the grade column
 ALTER TABLE salesman ADD grade int;
 --Update the values in the grade column
 UPDATE salesman SET grade = 100;
 --Display data
 SELECT * FROM salesman;

 --Activity 5 

--Update the grade score of salesmen from Rome to 200
UPDATE salesman SET grade = 200 WHERE salesman_city='Rome';
--Update the grade score of James Hoog to 300
UPDATE salesman SET grade = 300 WHERE salesman_Name = 'James Hoog';
-- Update the name McLyon to Pierre
UPDATE salesman SET salesman_Name ='Pierre' WHERE salesman_Name='McLyon';
SELECT * FROM salesman;
