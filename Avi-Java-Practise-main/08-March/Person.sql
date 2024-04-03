create database Person;
use Person;


-- Create Person table
CREATE TABLE Person (
    PersonId INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50)
);

-- Insert sample data into Person table
INSERT INTO Person (PersonId, FirstName, LastName) VALUES
(1, 'John', 'Doe'),
(2, 'Jane', 'Smith'),
(3, 'Alice', 'Johnson');

-- Create Address table
CREATE TABLE Address (
    AddressId INT PRIMARY KEY,
    PersonId INT,
    City VARCHAR(50),
    State VARCHAR(50),
    FOREIGN KEY (PersonId) REFERENCES Person(PersonId)
);

-- Insert sample data into Address table
INSERT INTO Address (AddressId, PersonId, City, State) VALUES
(1, 1, 'New York', 'NY'),
(2, 2, 'Los Angeles', 'CA'),
(3, 3, 'Chicago', 'IL');

select p.FirstName, p.LastName, a.City, a.State from Person as p left join Address as a on p.PersonId = a.PersonId;

