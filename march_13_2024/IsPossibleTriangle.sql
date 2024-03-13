-- A pupil Tim gets homework to identify whether three line segments could possibly form a triangle.

--  However, this assignment is very heavy because there are hundreds of records to calculate.

-- Could you help Tim by writing a query to judge whether these three  sides can form a triangle, assuming table triangle holds the length of the three sides x, y and z.

-- | x  | y  | z  |
-- |----|----|----|
-- | 13 | 15 | 30 |
-- | 10 | 20 | 15 |

--  For the sample data above, your query should return the follow result:
--  | x  | y  | z  | triangle |
--  |----|----|----|----------|
--  | 13 | 15 | 30 | No       |
--  | 10 | 20 | 15 | Yes      |

USE TestDb;

-- create table triangle
CREATE TABLE Triangle(x INT,
y INT,
z INT);

-- insert data in triangle table
INSERT INTO Triangle (x, y, z) VALUES (13, 15, 30),
(10, 20, 15);

-- query to return if the sides can make a triangle or not
SELECT 
    x,
    y,
    z,
    CASE
        WHEN x + y > z AND y + z > x AND x + z > y THEN 'yes'
        ELSE 'no'
    END AS triangle
FROM
    Triangle;