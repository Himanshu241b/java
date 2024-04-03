create database rankScores;
use rankScores;

create table scores(
	id int auto_increment primary key,
    score double
);

insert into scores values(1, 3.5), (2, 3.65), (3, 4.0), (4, 3.85), (5, 4.00), (6, 3.65);

select s2.score, (select COUNT(distinct score) from s2 where s1.score >= s1.score) as "Rank" 
from scores s1 order by score desc;