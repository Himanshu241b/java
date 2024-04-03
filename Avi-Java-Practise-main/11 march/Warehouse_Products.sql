create database march_11;
use march_11;

create table Warehouse(
	name varchar(50),
    product_id int,
	units int
);
create table Products(
	product_id int primary key,
    product_name varchar(50),
	width int,
    length int,
    height int
);

insert into Warehouse values
('LCHouse1', 1, 1),
('LCHouse1', 2, 10),
('LCHouse1', 3, 5),
('LCHouse2', 1, 2),
('LCHouse2', 2, 2),
('LCHouse3', 4, 1);

insert into Products values
(1, 'LC-TV', 5, 50, 40),
(2, 'LC-KeyChain', 5, 5, 5),
(3, 'LC-Phone', 2, 10, 10),
(4, 'LC-Tshirt', 4, 10, 20);


select w.name as warehouse_name,
  SUM(p.width * p.height * p.length * w.units) as volume
  from Warehouse w join Products p on w.product_id = p.product_id 
  group by w.name;
