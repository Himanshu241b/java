-- Table: Customer

-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | customer_id | int     |
-- | product_key | int     |
-- +-------------+---------+
-- product_key is a foreign key to Product table.


-- Table: Product

-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | product_key | int     |
-- +-------------+---------+
-- product_key is the primary key column for this table.


-- Write an SQL query for a report that provides the customer ids from the Customer table that bought all the products in the Product table.

-- Return the result table in any order.

-- The query result format is in the following example:



-- Customer table:
-- +-------------+-------------+
-- | customer_id | product_key |
-- +-------------+-------------+
-- | 1           | 5           |
-- | 2           | 6           |
-- | 3           | 5           |
-- | 3           | 6           |
-- | 1           | 6           |
-- +-------------+-------------+

-- Product table:
-- +-------------+
-- | product_key |
-- +-------------+
-- | 5           |
-- | 6           |
-- +-------------+

-- Result table:
-- +-------------+
-- | customer_id |
-- +-------------+
-- | 1           |
-- | 3           |
-- +-------------+
-- The customers who bought all the products (5 and 6) are customers with id 1 and 3.

USE TestDb;

-- create table product
CREATE TABLE Product(product_key INT PRIMARY KEY
);

-- Insert data into Product table
INSERT INTO Product (product_key) VALUES
(5),
(6);

-- create table customer
CREATE TABLE Customer(customer_id INT,
product_key INT,
FOREIGN KEY (product_key) REFERENCES Product(product_key)
);

-- Insert data into Customer table
INSERT INTO Customer (customer_id, product_key) VALUES
(1, 5),
(2, 6),
(3, 5),
(3, 6),
(1, 6);

--  query for a report that provides the customer ids from the Customer table that bought all the products in the Product table
SELECT customer_id
FROM Customer
GROUP BY customer_id
HAVING COUNT(DISTINCT product_key) = (SELECT COUNT(*) FROM Product);
