create database if not exists march_13;
use march_13;

-- Create the Submissions table
CREATE TABLE Submissions (
    sub_id INT,
    parent_id INT
);

-- Insert values into the Submissions table
INSERT INTO Submissions (sub_id, parent_id) VALUES
(1, NULL),
(2, NULL),
(1, NULL),
(12, NULL),
(3, 1),
(5, 2),
(3, 1),
(4, 1),
(9, 1),
(10, 2),
(6, 7);

with helper as 
(select distinct sub_id as post from Submissions where parent_id is null)

select h.post as post_id, count(distinct s.sub_id) as number_of_comments
from
	helper h left join Submissions s
    on
		h.post = s.parent_id
group by h.post;


