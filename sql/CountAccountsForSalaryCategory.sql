--Table: Accounts
--
--+-------------+------+
--| Column Name | Type |
--+-------------+------+
--| account_id  | int  |
--| income      | int  |
--+-------------+------+
--account_id is the primary key for this table.
--Each row contains information about the monthly income for one bank account.
--
--
--Write an SQL query to report the number of bank accounts of each salary category. The salary categories are:
--
--"Low Salary": All the salaries strictly less than $20000.
--"Average Salary": All the salaries in the inclusive range [$20000, $50000].
--"High Salary": All the salaries strictly greater than $50000.
--The result table must contain all three categories. If there are no accounts in a category, then report 0. Return the result table in any order.
--
--The query result format is in the following example.
--
--
--
--Accounts table:
--+------------+--------+
--| account_id | income |
--+------------+--------+
--| 3          | 108939 |
--| 2          | 12747  |
--| 8          | 87709  |
--| 6          | 91796  |
--+------------+--------+
--
--Result table:
--+----------------+----------------+
--| category       | accounts_count |
--+----------------+----------------+
--| Low Salary     | 1              |
--| Average Salary | 0              |
--| High Salary    | 3              |
--+----------------+----------------+
--
--Low Salary: Account 2.
--Average Salary: No accounts.
--High Salary: Accounts 3, 6, and 8.


-- create table
CREATE TABLE Accounts (
    account_id INT PRIMARY KEY,
    income INT
);

-- insert data in table
INSERT INTO Accounts (account_id, income) VALUES (3, 108939);
INSERT INTO Accounts (account_id, income) VALUES (2, 12747);
INSERT INTO Accounts (account_id, income) VALUES (8, 87709);
INSERT INTO Accounts (account_id, income) VALUES (6, 91796);

-- query provides the count of accounts for each salary category, even if there are no accounts in a particular category, in which case it reports 0
SELECT
    'Low Salary' AS category,
    COUNT(CASE WHEN income < 20000 THEN 1 END) AS accounts_count
FROM
    Accounts
UNION ALL
SELECT
    'Average Salary' AS category,
    COUNT(CASE WHEN income BETWEEN 20000 AND 50000 THEN 1 END) AS accounts_count
FROM
    Accounts
UNION ALL
SELECT
    'High Salary' AS category,
    COUNT(CASE WHEN income > 50000 THEN 1 END) AS accounts_count
FROM
    Accounts;

