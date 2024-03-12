-- Select all employee's name and bonus whose bonus is < 1000.

-- Table:Employee

-- +-------+--------+-----------+--------+
-- | empId |  name  | supervisor| salary |
-- +-------+--------+-----------+--------+
-- |   1   | John   |  3        | 1000   |
-- |   2   | Dan    |  3        | 2000   |
-- |   3   | Brad   |  null     | 4000   |
-- |   4   | Thomas |  3        | 4000   |
-- +-------+--------+-----------+--------+
-- empId is the primary key column for this table.
-- Table: Bonus

-- +-------+-------+
-- | empId | bonus |
-- +-------+-------+
-- | 2     | 500   |
-- | 4     | 2000  |
-- +-------+-------+
-- empId is the primary key column for this table.

-- Example output:

--  +-------+-------+
--  | name  | bonus |
-- +-------+-------+
-- | John  | null  |
-- | Dan   | 500   |
-- | Brad  | null  |
-- +-------+-------+

-- Create Employee 
USE TestDb;

-- create Employee table
CREATE TABLE Employee (
    empId INT PRIMARY KEY,
    name VARCHAR(50),
    supervisor INT,
    salary INT
);

-- Insert data into Employee table
INSERT INTO Employee (empId, name, supervisor, salary) VALUES
(1, 'John', 3, 1000),
(2, 'Dan', 3, 2000),
(3, 'Brad', NULL, 4000),
(4, 'Thomas', 3, 4000);

-- Create Bonus table
CREATE TABLE Bonus (
    empId INT PRIMARY KEY,
    bonus INT
);

-- Insert data into Bonus table
INSERT INTO Bonus (empId, bonus) VALUES
(2, 500),
(4, 2000);

--  Select all employee's name and bonus whose bonus is < 1000.
SELECT 
    e.name, b.bonus
FROM
    Employee e
        LEFT JOIN
    Bonus b ON b.empId = e.empId
WHERE
    b.bonus < 1000 OR b.bonus IS NULL;