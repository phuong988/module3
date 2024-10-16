create database QuanLyDiemThi;
use QuanLyDiemThi;
create table student(
	MaHS varchar(20) primary key,
    TenHS varchar(500),
    NgaySinh date,
    Lop varchar(20),
    GT varchar(020)
); 
create table MonHoc(
	MaMH varchar(20) primary key,
    TenMH varchar(50),
    MaGV varchar(20)
);
create table BangDiem(
	MaHS varchar(20),
    MaMH varchar(20),
    DiemThi float,
    NgayKT date,
    primary key (MaHS, MaMH),
    foreign key (MaHS) references student(MaHS),
    foreign key (MaMH) references MonHoc(MaMH)
);
create table GiaoVien(
	MaGV varchar(20) primary key,
    TenGV varchar(50),
    SDT varchar(15)
);

alter table MonHoc add constraint FK_MaGV foreign key (MaGV) references GiaoVien(MaGV);