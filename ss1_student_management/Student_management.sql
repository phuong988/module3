Create database student_management1;
use student_management1;
create table Class(
id int primary key auto_increment,
name varchar(50) 
);

insert into class(id, name) values(1, "c07");
insert into class(id, name) values(2, "c08");
select * from class;

alter table class add primary key(id);
create table Teacher(
id int primary key auto_increment,
name varchar(50),
age int check(age between 22 and 70),
country varchar(50)
);
select * from Teacher;
insert into Teacher(id,name, age, country) values (01, "aChanh",36,"da nang");
insert into Teacher(id,name, age, country) values(02,"aHai", 27, "quang nam");

alter table Teacher drop column country;
alter table Teacher add column country varchar(50);

update teacher set name = "aTrung" where id = 3;
delete from Teacher where id = 3;
drop table class;
drop database student_management;






