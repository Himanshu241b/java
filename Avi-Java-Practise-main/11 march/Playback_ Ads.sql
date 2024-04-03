create database march_11;
use march_11;

create table Playback(
	session_id int primary key,
    customer_id int,
    start_time int,
    end_time int
);

create table Ads(
	ad_id int primary key,
    customer_id int,
    timestamp int
);

insert into Playback values
(1, 1, 1, 5),
(2, 1, 15, 23),
(3, 2, 10, 12),
(4, 2, 17, 28),
(5, 2, 2, 8);

insert into Ads values
(1, 1, 5),
(2, 2, 17),
(3, 2, 20);

select session_id from Playback p left join Ads a on p.customer_id = a.customer_id and a.timestamp >= p.start_time and a.timestamp <= p.end_time where ad_id is NULL;