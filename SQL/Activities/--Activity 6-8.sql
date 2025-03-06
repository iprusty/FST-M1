--Activity 6
-- Create a table named orders
create table orders(
    order_no int primary key, purchase_amount float, order_date date,
    customer_id int, salesman_id int);

-- Add values to the table
INSERT ALL
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005)
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001)
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003)
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002)
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001)
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001)
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006)
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003)
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002)
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007)
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001)
SELECT 1 FROM DUAL;

-- Get all salesman ids without any repeated values
SELECT DISTINCT salesman_id FROM orders;

-- Display the order number ordered by date in ascending order
SELECT order_no, order_date FROM orders order by order_date;

-- Display the order number ordered by purchase amount in descending order
SELECT order_no, purchase_amount FROM orders ORDER BY purchase_amount DESC;

-- Display the full data of orders that have purchase amount less than 500
SELECT * FROM orders WHERE purchase_amount< 500;
-- Display the full data of orders that have purchase amount between 1000 and 2000.
SELECT * FROM orders WHERE purchase_amount BETWEEN 1000 AND 2000;

 --Activity 7
 -- Write an SQL statement to find the total purchase amount of all orders
 SELECT SUM(purchase_amount) AS "Total sum" FROM orders;

-- Write an SQL statement to find the average purchase amount of all orders.
SELECT AVG(purchase_amount) AS "Average" FROM orders;

-- Write an SQL statement to get the maximum purchase amount of all the orders.
SELECT MAX(purchase_amount) AS "Maximum" FROM orders;
-- Write an SQL statement to get the minimum purchase amount of all the orders.
SELECT MIN(Purchase_amount) AS "Minimum" FROM orders;
-- Write an SQL statement to find the number of salesmen listed in the table.
SELECT COUNT(distinct salesman_id) AS "Total count" FROM orders;

--Activity 8
-- Write an SQL statement to find the highest purchase amount ordered by the each customer with their ID and highest purchase amount.
SELECT customer_id, MAX(purchase_amount)AS "Max Amount" FROM orders GROUP BY customer_id;
-- Write an SQL statement to find the highest purchase amount on '2012-08-17' for each salesman with their ID.
SELECT salesman_id,order_date,MAX(purchase_amount) AS  "Max Amount" FROM orders
WHERE order_date=To_DATE('2012/08/17', 'YYYY/MM/DD') GROUP BY salesman_id, order_date;

-- Write an SQL statement to find the highest purchase amount with their ID and order date, for only those customers who have a higher purchase amount within the list 2030, 3450, 5760, and 6000.
SELECT customer_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders
GROUP BY customer_id, order_date
HAVING MAX(purchase_amount) IN(2030, 3450, 5760, 6000);
