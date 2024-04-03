create database if not exists march_13;
use march_13;

CREATE TABLE Person (
    Id INT,
    Email VARCHAR(255)
);


INSERT INTO Person (Id, Email) VALUES
(1, 'a@b.com'),
(2, 'c@d.com'),
(3, 'a@b.com');

select Email 
from
	Person
    group by Email
having
	count(Email) > 1;