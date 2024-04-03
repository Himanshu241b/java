create database march_12;
use march_12;

CREATE TABLE Accounts (
    account_id INT PRIMARY KEY,
    income INT
);

INSERT INTO Accounts (account_id, income) VALUES
(3, 108939),
(2, 12747),
(8, 87709),
(6, 91796);

select "Low Salary" as category, 
	count(case when income < 20000 then 1 end) as account_count
from 
	Accounts
union all
select "Average Salary",
	count(case when income >= 20000 and income <= 50000 then 1 end)
from 
	Accounts
union all 
select "High Salary",
	count(case when income > 50000 then 1 end)
from 
	Accounts;
    
    
s   