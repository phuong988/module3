create database quan_ly_vat_tu;
use quan_ly_vat_tu;
create table if not exists phieu_nhap(
	so_phieu_nhap int primary key,
    ngay_xuat date
);
create table if not exists phieu_xuat(
	so_phieu_xuat int auto_increment primary key,
    ngay_xuat date
);
create table if not exists nha_cung_cap(
	ma_nha_cung_cap int,
    ten_ncc varchar(50) not null,
    dia_chi varchar(100),
    sdt varchar(10) not null
);
create table if not exists don_dat_hang(
	so_don_hang int primary key,
    ngay_dat_hang date
);
create table vat_tu(
	ma_vat_tu int primary key,
    ten_vat_tu varchar(50)
);
create table if not exists chi_tiet_phieu_nhap(
	ma_vat_tu int ,
	so_phieu_nhap int,
	don_gia float,
	so_luong float,
	primary key (ma_vat_tu,so_phieu_nhap),
	foreign key (ma_vat_tu) references vat_tu(ma_vat_tu),
	foreign key (so_phieu_nhap) references phieu_nhap(so_phieu_nhap)
 );
create table if not exists chi_tiet_phieu_xuat(
ma_vat_tu int ,
so_phieu_xuat int,
don_gia float,
so_luong float,
primary key (ma_vat_tu,so_phieu_xuat),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key (so_phieu_xuat) references phieu_xuat(so_phieu_xuat)
 );
 create table if not exists don_dat_hang(
 so_dat_hang int primary key auto_increment,
 ngay date
 );
 
 create table if not exists chi_tiet_dat_hang(
 so_dat_hang int ,
 ma_vat_tu int ,
 so_luong float,
 primary key (so_dat_hang,ma_vat_tu),
 foreign key (so_dat_hang) references don_dat_hang(so_dat_hang),
 foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
 );

