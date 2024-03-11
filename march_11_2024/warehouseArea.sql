-- Table: Warehouse

-- +--------------+---------+
-- | Column Name  | Type    |
-- +--------------+---------+
-- | name         | varchar |
-- | product_id   | int     |
-- | units        | int     |
-- +--------------+---------+
-- (name, product_id) is the primary key for this table.
-- Each row of this table contains the information of the products in each warehouse.


-- Table: Products

-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | product_id    | int     |
-- | product_name  | varchar |
-- | Width         | int     |
-- | Length        | int     |
-- | Height        | int     |
-- +---------------+---------+
-- product_id is the primary key for this table.
-- Each row of this table contains the information about the product dimensions (Width, Lenght and Height) in feets of each product.


-- Write an SQL query to report, How much cubic feet of volume does the inventory occupy in each warehouse.

-- warehouse_name
-- volume
-- Return the result table in any order.

-- The query result format is in the following example.



-- Warehouse table:
-- +------------+--------------+-------------+
-- | name       | product_id   | units       |
-- +------------+--------------+-------------+
-- | LCHouse1   | 1            | 1           |
-- | LCHouse1   | 2            | 10          |
-- | LCHouse1   | 3            | 5           |
-- | LCHouse2   | 1            | 2           |
-- | LCHouse2   | 2            | 2           |
-- | LCHouse3   | 4            | 1           |
-- +------------+--------------+-------------+

-- Products table:
-- +------------+--------------+------------+----------+-----------+
-- | product_id | product_name | Width      | Length   | Height    |
-- +------------+--------------+------------+----------+-----------+
-- | 1          | LC-TV        | 5          | 50       | 40        |
-- | 2          | LC-KeyChain  | 5          | 5        | 5         |
-- | 3          | LC-Phone     | 2          | 10       | 10        |
-- | 4          | LC-T-Shirt   | 4          | 10       | 20        |
-- +------------+--------------+------------+----------+-----------+

-- Result table:
-- +----------------+------------+
-- | warehouse_name | volume     | 
-- +----------------+------------+
-- | LCHouse1       | 12250      | 
-- | LCHouse2       | 20250      |
-- | LCHouse3       | 800        |
-- +----------------+------------+
-- Volume of product_id = 1 (LC-TV), 5x50x40 = 10000
-- Volume of product_id = 2 (LC-KeyChain), 5x5x5 = 125 
-- Volume of product_id = 3 (LC-Phone), 2x10x10 = 200
-- Volume of product_id = 4 (LC-T-Shirt), 4x10x20 = 800
-- LCHouse1: 1 unit of LC-TV + 10 units of LC-KeyChain + 5 units of LC-Phone.
--         Total volume: 1*10000 + 10*125  + 5*200 = 12250 cubic feet
-- LCHouse2: 2 units of LC-TV + 2 units of LC-KeyChain.
--         Total volume: 2*10000 + 2*125 = 20250 cubic feet
-- LCHouse3: 1 unit of LC-T-Shirt.
--         Total volume: 1*800 = 800 cubic feet.

USE TestDb;

-- create products table
CREATE TABLE Products (
				product_id INT PRIMARY KEY,
				product_name VARCHAR(255),
                width INT,
                length INT,
                height INT
               );
               
-- insert into products table
INSERT INTO Products (product_id, product_name, Width, Length, Height)
VALUES
    (1, 'LC-TV', 5, 50, 40),
    (2, 'LC-KeyChain', 5, 5, 5),
    (3, 'LC-Phone', 2, 10, 10),
    (4, 'LC-T-Shirt', 4, 10, 20);
    
-- create warehouse table
CREATE TABLE Warehouse(
					name VARCHAR(255),
                    product_id INT,
					units INT,
					PRIMARY KEY (name, product_id), -- composite key
					FOREIGN KEY (product_id) REFERENCES Products(product_id) -- foreign key constraint
                    );
-- insert in Warehouse table
INSERT INTO Warehouse (name, product_id, units) VALUES
										('LCHouse1',1, 1),
                                        ('LCHouse1',2, 10),
                                        ('LCHouse1',3, 5),
                                        ('LCHouse2',1, 2),
                                        ('LCHouse2',2, 2),
                                        ('LCHouse3',4, 1);
                                        
-- query to return the volume that the inventory occupy in each warehouse
WITH ProductVolumes AS (
	SELECT 	
		p.product_id,
		p.product_name,
        p.width * p.height * p.length AS Volume
	FROM 
		Products p
)
SELECT 
    w.name AS warehouse_name, 
    SUM(pv.volume * w.units) AS volume
FROM
    Warehouse w
        JOIN
    ProductVolumes pv ON w.product_id = pv.product_id
GROUP BY w.name;   -- The GROUP BY clause groups the result set by the name column of the Warehouse table, ensuring that the SUM function is applied to each warehouse separately.