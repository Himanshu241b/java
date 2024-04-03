create database if not exists march_13;
use march_13;

-- Step 1: Create the Customer table
CREATE TABLE Customer (
    customer_id INT,
    product_key INT,
    FOREIGN KEY (product_key) REFERENCES Product(product_key)
);

-- Step 2: Create the Product table
CREATE TABLE Product (
    product_key INT PRIMARY KEY
);

-- Step 3: Insert values into the Customer and Product tables
INSERT INTO Customer (customer_id, product_key) VALUES
(1, 5),
(2, 6),
(3, 5),
(3, 6),
(1, 6);



INSERT INTO Product (product_key) VALUES
(5),
(6);


select c.customer_id from Customer c group by c.customer_id having count(distinct c.product_key) = (select count(*) from Product);