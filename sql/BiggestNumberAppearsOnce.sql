--Table my_numbers contains many numbers in column num including duplicated ones.
-- Can you write a SQL query to find the biggest number, which only appears once.
--
-- +---+
--|num|
--+---+
--| 8 |
--| 8 |
--| 3 |
--| 3 |
--| 1 |
--| 4 |
--| 5 |
--| 6 |
--
--For the sample data above, your query should return the following result:
--+---+
--|num|
--+---+
--| 6 |
--Note: If there is no such number, just output null.

-- create table
CREATE TABLE my_numbers (
    num INT
);

-- insert data in table
INSERT INTO my_numbers (num) VALUES (8);
INSERT INTO my_numbers (num) VALUES (8);
INSERT INTO my_numbers (num) VALUES (3);
INSERT INTO my_numbers (num) VALUES (3);
INSERT INTO my_numbers (num) VALUES (1);
INSERT INTO my_numbers (num) VALUES (4);
INSERT INTO my_numbers (num) VALUES (5);
INSERT INTO my_numbers (num) VALUES (6);

--  query to find the biggest number that appears only once in the my_numbers table,
SELECT MAX(num) AS num
FROM my_numbers
GROUP BY num
HAVING COUNT(num) = 1;

