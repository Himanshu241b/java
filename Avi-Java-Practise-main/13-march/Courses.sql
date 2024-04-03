create database if not exists march_13;
use march_13;

-- Step 1: Create the courses table
CREATE TABLE courses (
    student VARCHAR(255),
    class VARCHAR(255)
);

-- Step 2: Insert values into the courses table
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

select class from courses group by class having count(*) >= 5;