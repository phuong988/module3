create database codegym_management;
use codegym_management;
create table student(
	student_id int auto_increment primary key,
	name varchar(50) not null,
    date_of_birth date not null,
    gender Enum('Male', 'Female','Other') not null,
    email varchar(50) unique not null,
    score float default 0,
    class_id int
);

create table jame(
	username varchar(50) unique,
    `password` varchar(30),
    id varchar(10) unique,
    student_id int unique,
    constraint fk_student Foreign key(id) references student(student_id) on delete cascade
);

create table class(
	class_id int auto_increment primary key,
	theory_class varchar(20),
    practice_class varchar(20),
    id varchar(10) unique,
    constraint fk_student Foreign key(id) references student(student_id)
);

create table lecturer(
	lecturer_id int auto_increment primary key,
	name varchar(50),
    day_of_birth date,
    wage double
);

create table room(
	theory varchar(40),
    practice varchar(50)
    
);    