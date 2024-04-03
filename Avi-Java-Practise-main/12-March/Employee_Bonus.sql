create database march_12;
use march_12;

-- Create the Employee table
CREATE TABLE Employee (
    empId INT PRIMARY KEY,
    name VARCHAR(50),
    supervisor INT,
    salary INT
);

-- Insert values into the Employee table
INSERT INTO Employee (empId, name, supervisor, salary) VALUES
(1, 'John', 3, 1000),
(2, 'Dan', 3, 2000),
(3, 'Brad', NULL, 4000),
(4, 'Thomas', 3, 4000);

-- Create the Bonus table
CREATE TABLE Bonus (
    empId INT PRIMARY KEY,
    bonus INT
);

-- Insert values into the Bonus table
INSERT INTO Bonus (empId, bonus) VALUES
(2, 500),
(4, 2000);

    
select e.name as name, b.bonus as bonus 
from
	Employee e left join Bonus b
on
	e.empId = b.empId
where
	b.bonus is null or b.bonus < 1000;
