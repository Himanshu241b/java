--.Select all employee's name and bonus whose bonus is < 1000.
--
--Table:Employee
--
--+-------+--------+-----------+--------+
--| empId |  name  | supervisor| salary |
--+-------+--------+-----------+--------+
--|   1   | John   |  3        | 1000   |
--|   2   | Dan    |  3        | 2000   |
--|   3   | Brad   |  null     | 4000   |
--|   4   | Thomas |  3        | 4000   |
--+-------+--------+-----------+--------+
--empId is the primary key column for this table.
--Table: Bonus
--
--+-------+-------+
--| empId | bonus |
--+-------+-------+
--| 2     | 500   |
--| 4     | 2000  |
--+-------+-------+
--empId is the primary key column for this table.
--
--Example output:
--
-- +-------+-------+
-- | name  | bonus |
--+-------+-------+
--| John  | null  |
--| Dan   | 500   |
--| Brad  | null  |
--+-------+-------+
--1

-- create table employee
CREATE TABLE employee (
    empId INT PRIMARY KEY,
    name VARCHAR(255),
    supervisor INT,
    salary INT
);

-- insert into employee table
INSERT INTO employee (empId, name, supervisor, salary) VALUES (1, 'John', 3, 1000);
INSERT INTO employee (empId, name, supervisor, salary) VALUES (2, 'Dan', 3, 2000);
INSERT INTO employee (empId, name, supervisor, salary) VALUES (3, 'Brad', NULL, 4000);
INSERT INTO employee (empId, name, supervisor, salary) VALUES (4, 'Thomas', 3, 4000);

-- create Bonus table
CREATE TABLE Bonus (
    empId INT PRIMARY KEY,
    bonus INT
);

-- insert into bonus table
INSERT INTO Bonus (empId, bonus) VALUES (2, 500);
INSERT INTO Bonus (empId, bonus) VALUES (4, 2000);

-- query selects all employee names and their corresponding bonuses where the bonus is less than 1000. It performs a left join between the Employee table and the Bonus table based on the empId column. Then, it filters the result based on the condition that the bonus is less than 1000, or null.
SELECT e.name, b.bonus
FROM employee e
LEFT JOIN Bonus b ON e.empId = b.empId
WHERE IFNULL(b.bonus, 0) < 1000;

