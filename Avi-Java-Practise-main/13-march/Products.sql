create database if not exists march_13;
use march_13;

-- Step 1: Create the Products table
CREATE TABLE Products (
    product_id INT PRIMARY KEY,
    low_fats ENUM('Y', 'N'),
    recyclable ENUM('Y', 'N')
);

-- Step 2: Insert values into the Products table
INSERT INTO Products (product_id, low_fats, recyclable) VALUES
(0, 'Y', 'N'),
(1, 'Y', 'Y'),
(2, 'N', 'Y'),
(3, 'Y', 'Y'),
(4, 'N', 'N');

select product_id 
from Products
where low_fats = "Y" and recyclable = "Y";
