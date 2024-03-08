--Table: Friends
--
--+---------------+---------+
--| Column Name   | Type    |
--+---------------+---------+
--| id            | int     |
--| name          | varchar |
--| activity      | varchar |
--+---------------+---------+
--id is the id of the friend and primary key for this table.
--name is the name of the friend.
--activity is the name of the activity which the friend takes part in.
--Table: Activities
--
--+---------------+---------+
--| Column Name   | Type    |
--+---------------+---------+
--| id            | int     |
--| name          | varchar |
--+---------------+---------+
--id is the primary key for this table.
--name is the name of the activity.
--
--
--Write an SQL query to find the names of all the activities with neither maximum, nor minimum number of participants.
--
--Return the result table in any order. Each activity in table Activities is performed by any person in the table Friends.
--
--The query result format is in the following example:
--
--Friends table:
--+------+--------------+---------------+
--| id   | name         | activity      |
--+------+--------------+---------------+
--| 1    | Jonathan D.  | Eating        |
--| 2    | Jade W.      | Singing       |
--| 3    | Victor J.    | Singing       |
--| 4    | Elvis Q.     | Eating        |
--| 5    | Daniel A.    | Eating        |
--| 6    | Bob B.       | Horse Riding  |
--+------+--------------+---------------+
--
--Activities table:
--+------+--------------+
--| id   | name         |
--+------+--------------+
--| 1    | Eating       |
--| 2    | Singing      |
--| 3    | Horse Riding |
--+------+--------------+
--
--Result table:
--+--------------+
--| activity     |
--+--------------+
--| Singing      |
--+--------------+
--
--Eating activity is performed by 3 friends, maximum number of participants, (Jonathan D. , Elvis Q. and Daniel A.)
--Horse Riding activity is performed by 1 friend, minimum number of participants, (Bob B.)
--Singing is performed by 2 friends (Victor J. and Jade W.)

-- Create the Friends table
CREATE TABLE Friends (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    activity VARCHAR(255)
);

-- Insert sample data into the Friends table
INSERT INTO Friends (id, name, activity) VALUES
(1, 'Jonathan D.', 'Eating'),
(2, 'Jade W.', 'Singing'),
(3, 'Victor J.', 'Singing'),
(4, 'Elvis Q.', 'Eating'),
(5, 'Daniel A.', 'Eating'),
(6, 'Bob B.', 'Horse Riding');

-- Create the Activities table
CREATE TABLE Activities (
    id INT PRIMARY KEY,
    name VARCHAR(255)
);

-- Insert sample data into the Activities table
INSERT INTO Activities (id, name) VALUES
(1, 'Eating'),
(2, 'Singing'),
(3, 'Horse Riding');

-- Query to find activities with neither maximum nor minimum participants
SELECT activity
FROM Activities
WHERE id NOT IN (
    SELECT a.id
    FROM Activities a
    JOIN Friends f ON a.name = f.activity
    GROUP BY a.id
    HAVING COUNT(f.id) = (
        SELECT COUNT(*)
        FROM Friends
        GROUP BY activity
        ORDER BY COUNT(*) ASC
        LIMIT 1
    ) OR COUNT(f.id) = (
        SELECT COUNT(*)
        FROM Friends
        GROUP BY activity
        ORDER BY COUNT(*) DESC
        LIMIT 1
    )
);
