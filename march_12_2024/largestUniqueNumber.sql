-- Table my_numbers contains many numbers in column num including duplicated ones.
--  Can you write a SQL query to find the biggest number, which only appears once.

--  +---+
-- |num|
-- +---+
-- | 8 |
-- | 8 |
-- | 3 |
-- | 3 |
-- | 1 |
-- | 4 |
-- | 5 |
-- | 6 | 

-- For the sample data above, your query should return the following result:
-- +---+
-- |num|
-- +---+
-- | 6 |
-- Note: If there is no such number, just output null.

USE TestDb;

-- create table my_numbers
CREATE TABLE my_numbers(num INT);

-- Insert sample data into the table my_numbers
INSERT INTO my_numbers (num) VALUES
(8),
(8),
(3),
(3),
(1),
(4),
(5),
(6);
                        
--  query to find the biggest number, which only appears once
SELECT 
    num
FROM
    my_numbers
GROUP BY num
HAVING COUNT(num) = 1
ORDER BY num DESC
LIMIT 1;