create database quan_ly_sinh_vien;
use Quan_ly_sinh_vien;
create table Class(
	id int primary key auto_increment,
    name varchar(60) not null,
    startDate datetime not null,
    status bit
);
create table Student(
	id int primary key auto_increment,
    name varchar(50) not null,
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
insert into Class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);
insert into Student(name, address, phone,status, class_id)
values('Hung', 'Ha Noi', '0912113113', 1, 1);
insert into Student(name, address, status, class_id)
values('Hoa','Hai phong',1, 1);
insert into Student(name, address, phone, status, class_id)
values('Manh','HCM','0123123123', 0, 2);
INSERT INTO Subject
VALUES (1, 'CF', 5, 1),
 (2, 'C', 6, 1),
 (3, 'HDJ', 5, 1),
 (4, 'RDBMS', 10, 1);
INSERT INTO Mark (Sub_id,Student_id,mark,examtimes)
VALUES (1, 1, 8, 1),
 (1, 2, 10, 2),
 (2, 1, 12, 1);
 -- danh sach moon hoc co thoi gian hoc nho hon 10
 select* from subject
 where credit < 10;
 -- hien thi danh sach hoc ven lop A1
 select S.id, S.name, C.name
 from Student S 
 join class C on S.class_id = C.id
 where c.name = 'A1';
 -- hien thi tat ca cac diem dang co cua hoc vien
 select S.id, S.name, S.name,M.mark
 from Student S join Mark M on S.id = M.Student_id join subject Sub on M.id = Sub.id;
 -- hien thi diem mon CF cua hoc vien
 select S.id, S.name, S.name,M.mark
 from Student S join Mark M on S.id = M.Student_id join subject Sub on M.id = Sub.id
 where Sub.name = 'CF';
 
 -- **bai tap truy van du lieu **
 -- hien thi tat ca cac sinh vien co ten 'h'
select* from Student
where name like 'h%';

-- hien thi thong tin lop hoc cos thoi gian bat dau vao thang 12
select* from class
where Month(startDate) = '12';

 -- hien thi ta ca cac thong tin mon hoc co credit tu 3-5
select* from Subject
where credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
Set sql_safe_updates = 0;
update Student
set class_id = 2
where name = 'Hung';

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
SELECT S.name AS StudentName, Sub.name AS SubjectName, M.mark
FROM Student S
JOIN Mark M ON S.id = M.Student_id
JOIN Subject Sub ON M.Sub_id = Sub.id
ORDER BY M.mark DESC, S.name ASC;

select S.name as StudentName,M.mark, sub.name as Subjectname
from Student S
join Subject Sub on S.id = Sub.id
join Mark M on Sub.id = M.Student_id
order by M.mark desc, s.name asc; 

-- Hiển thị số lượng sinh viên ở từng nơi
select address, count(*) as StudentCount
 from Student
 group by address;

-- Tính điểm trung bình các môn học của mỗi học viên
select S.id StudentID, S.name StudentName, avg(M.mark) as AverageMark
from Student S
join Mark M on S.id = M.Student_id
group by S.id;
-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
select  S.id StudentID, S.name StudentName, avg(M.mark) AverageMark
from Student S
join Mark M on S.id = M.Student_id
group by S.id
having avg(M.mark) >15;
-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
select  S.id StudentID, S.name StudentName, avg(M.mark) AverageMark
from Student S
join Mark M on S.id = M.Student_id
group by S.id
having avg(M.mark) >= All(select avg(Mark) from Mark Group by Mark.Student_id);

