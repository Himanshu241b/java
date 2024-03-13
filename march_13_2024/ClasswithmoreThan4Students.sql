-- There is a table courses with columns: student and class

-- Please list out all classes which have more than or equal to 5 students.

-- For example, the table:

-- +---------+------------+
-- | student | class      |
-- +---------+------------+
-- | A       | Math       |
-- | B       | English    |
-- | C       | Math       |
-- | D       | Biology    |
-- | E       | Math       |
-- | F       | Computer   |
-- | G       | Math       |
-- | H       | Math       |
-- | I       | Math       |
-- +---------+------------+

-- Should output:

-- +---------+
-- | class   |
-- +---------+
-- | Math    |
-- +---------+

USE TestDb;

-- Create the table
CREATE TABLE courses (
    student VARCHAR(1),
    class VARCHAR(50)
);

-- Insert data into the table
INSERT INTO courses (student, class) VALUES
('A', 'Math'),
('B', 'English'),
('C', 'Math'),
('D', 'Biology'),
('E', 'Math'),
('F', 'Computer'),
('G', 'Math'),
('H', 'Math'),
('I', 'Math');

-- -- Query to list classes with 5 or more students
SELECT class 
FROM courses
GROUP BY class
HAVING COUNT(*) >=5;