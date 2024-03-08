--Several friends at a cinema ticket office would like to reserve consecutive available seats.
-- Can you help to query all the consecutive available seats order by the seat_id using the following cinema table?
--
-- | seat_id | free |
-- |------- |------|
-- | 1       | 1    |
-- | 2       | 0    |
-- | 3       | 1    |
-- | 4       | 1    |
-- | 6       | 1    |
--
-- Your query should return the following result for the sample case above.
--
--| seat_id |
--|---------|
--| 3       |
--| 4       |
--Note:
--The seat_id is an auto increment int, and free is bool ('1' means free, and '0' means occupied.).
-- Consecutive available seats are more than 2(inclusive) seats consecutively available.


-- create the table
CREATE TABLE cinema (
    seat_id INT AUTO_INCREMENT PRIMARY KEY,
    free BOOL
);

-- Insert into table
INSERT INTO cinema (free) VALUES (1);
INSERT INTO cinema (free) VALUES (0);
INSERT INTO cinema (free) VALUES (1);
INSERT INTO cinema (free) VALUES (1);
INSERT INTO cinema (free) VALUES (1);
INSERT INTO cinema (free) VALUES (1);

-- all consecutive available seats with more than 2 (inclusive) seats consecutively available,
SELECT seat_id
FROM cinema c1
WHERE c1.free = 1
AND NOT EXISTS (
    SELECT *
    FROM cinema c2
    WHERE c2.free = 0
    AND c2.seat_id BETWEEN c1.seat_id AND c1.seat_id + 2
)
ORDER BY seat_id;

