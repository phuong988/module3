create database QuanLySinhVien;
use QuanLySinhVien;
create table Class(
	id int primary key auto_increment,
    name varchar(60) not null,
    startDate datetime not null,
    status bit
);
create table Student(
	id int primary key auto_increment,
    name varchar(30) not null,
    address varchar(50),
    phone varchar(10),
    status Bit,
    class_id int not null,
    foreign key (class_id) references Class(id)
);
create table Subject(
	id int primary key auto_increment,
    name varchar(30) not null,
    credit tinyint not null default 1 check(credit >= 1),
    Status bit default 1
);
create table Mark(
	id int primary key auto_increment,
    Sub_id int ,
    Student_id int,
    mark float default 0 check(mark between 0 and 100),
    examtimes Tinyint default 1,
    unique(Sub_id, Student_id),
    foreign key (Sub_id) references Subject(id),
    foreign key (Student_id) references Student(id)
);
