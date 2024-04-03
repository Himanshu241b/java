create database march_11;
use march_11;

CREATE TABLE Orders (
    order_number INT PRIMARY KEY,
    customer_number INT
);


INSERT INTO Orders (order_number, customer_number) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 3);

select max(customer_number) as customer_number
from Orders
limit 1;