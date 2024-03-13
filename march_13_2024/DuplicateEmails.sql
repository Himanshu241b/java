-- Write a SQL query to find all duplicate emails in a table named Person.

-- +----+---------+
-- | Id | Email   |
-- +----+---------+
-- | 1  | a@b.com |
-- | 2  | c@d.com |
-- | 3  | a@b.com |
-- +----+---------+
-- For example, your query should return the following for the above table:

-- +---------+
-- | Email   |
-- +---------+
-- | a@b.com |

use TestDb;

-- Create the Person table
CREATE TABLE Person (
    Id INT,
    Email VARCHAR(100)
);

-- Insert data into the Person table
INSERT INTO Person (Id, Email) VALUES
(1, 'a@b.com'),
(2, 'c@d.com'),
(3, 'a@b.com');

-- -- Query to find duplicate emails
SELECT Email 
FROM Person 
GROUP BY Email
HAVING COUNT(*) > 1;