create database if not exists march_13;
use march_13;

-- Step 1: Create the triangle table
CREATE TABLE triangle (
    x INT,
    y INT,
    z INT
);

-- Step 2: Insert values into the triangle table
INSERT INTO triangle (x, y, z) VALUES
(13, 15, 30),
(10, 20, 15);

select x, y, z,
	case
		when x + y > z and y + z > x and x + z > y then "Yes"
        else "No"
    end as triangle  
from triangle;    