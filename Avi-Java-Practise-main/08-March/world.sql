create database world;
use world;

create table worldTable(
	title varchar(50),
    continent varchar(50),
    area int,
    population bigint,
    gdp bigint
);

insert into worldTable values
("Afghanistan", "Asia", 652230, 25500100, 20343000),
("Albania", "Europe", 28748, 2831741, 12960000),
("Algeria", "Africa", 2381741, 37100000, 188681000),
("Andorra", "Europe", 468, 78115, 3712000),
("Angola", "Africa", 12467000, 20609294, 100990000);

select * 
from worldTable
where area > 300000  and population > 2500000;