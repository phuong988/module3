create database if not exists trung_tam_codegym;
use trung_tam_codegym;
create table jame(
	username varchar(50) primary key,
	`password` varchar(50) 
);

create table class(
	id int auto_increment primary key,
    name varchar(50)
);
create table room(
	id int auto_increment primary key,
    name varchar(50),
    class_id int,
    foreign key(class_id) references class(id) 
);
create table Student(
	id int auto_increment primary key,
    name varchar(50),
    gender varchar(20),
    birthday date,
    email varchar(50),
    point float default 0,
    username varchar(50),
    foreign key(username) references jame(username),
    class_id int,
    foreign key(class_id) references class(id)
);
create table instructor(
	id int auto_increment primary key,
    name varchar(50),
    birthday date,
    salary double,
    username varchar(50),
    foreign key(username) references jame(username)
);
create table instructor_class(
	class_id int,
    instructor_id int,
    starttime time,
    endtime time,
    primary key (class_id, instructor_id), 
    foreign key(class_id) references class(id),
    foreign key(instructor_id) references instructor(id)
);
select * from Student; 
insert into jame(username,password) values('cunn',123);
insert into jame(username,password) values('chunglh',123);
insert into jame(username,password) values('hoanhh',123);
insert into jame(username,password) values('dungd',123);
insert into jame(username,password) values('huynhtd',123);
insert into jame(username,password) values('hainm',123);
insert into jame(username,password) values('namtv',123);
insert into jame(username,password) values('hieuvm',123);
insert into jame(username,password) values('kynx',123);
insert into jame(username,password) values('vulm',123);

insert into class(name) values('c1121g1'),('c1221g1'),('a0821i1'),('a0921i1');

insert into Student( name, gender, birthday, email, point, username, class_id) values
('nguyen ngoc cu', '1', '1981-12-12', 'cunn@gmail.com', 8, 'cunn', 1),
('le hai chung', '1', '1981-12-12', 'chunglh@gmail.com', 5, 'chunglh', 1),
('hoang huu hoan', '1', '1990-12-12', 'hoanhh@gmail.com', 6, 'hoanhh', 2),
('dau dung', '1', '1987-12-12', 'dundq@gmail.com', 1, 'dungd', 1),
('ta dinh huynh', '1', '1981-12-12', 'huynhtd@gmail.com', 9, 'huynhtd', 1),
('nguyen minh hai', '1', '1987-12-12', 'hainm@gmail.com', 1, 'hainm', 1),
('tran van nam', '1', '1981-12-12', 'namtv@gmail.com', 4, 'namtv', 2),
('vo minh hieu', '1', '1981-12-12', 'hieuvm@gmail.com', 3, 'hieuvm', 3),
('le xuan ky', '1', '1981-12-12', 'kykx@gmail.com', 7, 'kynx', 2),
('le minh vu', '1', '1981-12-12', 'vu@gmail.com', 8, 'vulm', 1),
('nguyen van a', '1', '1981-12-12', 'avn@gmail.com', NULL, NULL, NULL),
('tran van b', '1', '1981-12-12', 'btv@gmail.com', 5, NULL, NULL);

select Student.name as StudentName,
	class.name as ClassName
from Student left join class on Student.class_id = class.id;
select * from Student
where name like 'nguyen%';
select * from Student
where name = 'nguyen minh hai';
select * from Student
where name like '%hai%' or name like '%huynh%';
select * from Student 
where name like 'chung%';
select * from Student
where point > 5;
select * from Student
where point in(4,6,8);
select point, count(*) as StudentCount
from student
group by point;
SELECT 
    point, 
    COUNT(*) AS StudentCount 
FROM 
    Student 
WHERE 
    point > 5 
GROUP BY 
    point;
    SELECT 
    point, 
    COUNT(*) AS StudentCount 
FROM Student 
WHERE point > 5 
GROUP BY point
HAVING COUNT(*) >= 2;
SELECT 
    Student.name AS StudentName, 
    Student.point, 
    class.name AS ClassName
FROM Student
JOIN class ON Student.class_id = class.id
WHERE class.name = 'c1121g1'
ORDER BY Student.point DESC;