use projectdb

create table location(
id int primary key,
code varchar(20),
name varchar(30),
type varchar(10)
)

select * from location

drop table location
