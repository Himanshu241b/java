-- Problem statement
-- Table: ActorDirector

-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | actor_id    | int     |
-- | director_id | int     |
-- | timestamp   | int     |
-- +-------------+---------+

-- Timestamp is the primary key column for this table.


-- Write a SQL query for a report that provides the pairs (actor_id, director_id) where the actor have co-worked with the director at least 3 times.

-- Example:

-- ActorDirector table:
-- +-------------+-------------+-------------+
-- | actor_id    | director_id | timestamp   |
-- +-------------+-------------+-------------+
-- | 1           | 1           | 0           |
-- | 1           | 1           | 1           |
-- | 1           | 1           | 2           |
-- | 1           | 2           | 3           |
-- | 1           | 2           | 4           |
-- | 2           | 1           | 5           |
-- | 2           | 1           | 6           |
-- +-------------+-------------+-------------+

-- Result table:
-- +-------------+-------------+
-- | actor_id    | director_id |
-- +-------------+-------------+
-- | 1           | 1           |
-- +-------------+-------------+

-- The only pair is (1, 1) where they co-worked exactly 3 times.

-- create table
CREATE TABLE ActorDirector (
    actor_id INT,
    director_id INT,
    timestamp INT,
    PRIMARY KEY (timestamp)
);

-- insert in table
INSERT INTO ActorDirector (actor_id, director_id, timestamp)
VALUES
    (1, 1, 0),
    (1, 1, 1),
    (1, 1, 2),
    (1, 2, 3),
    (1, 2, 4),
    (2, 1, 5),
    (2, 1, 6);
    
-- query to return the actor and director id where they have worked together 3 or more times.
SELECT actor_id, director_id 
FROM ActorDirector
GROUP BY actor_id, director_id
HAVING COUNT(*) >=3;
