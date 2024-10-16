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
	ma_nha_cung_cap int primary key,
    ten_ncc varchar(50) not null,
    dia_chi varchar(100)
    
);
create table if not exists so_dien_thoai(
	id int primary key auto_increment,
    nha_cung_cap_id int ,
    so_dien_thoai varchar(10) not null,
	foreign key (nha_cung_cap_id) references nha_cung_cap(ma_nha_cung_cap)
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
 
 create table if not exists chi_tiet_dat_hang(
 so_dat_hang int ,
 ma_vat_tu int ,
 so_luong float,
 primary key (so_dat_hang,ma_vat_tu),
 foreign key (so_dat_hang) references don_dat_hang(so_don_hang),
 foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
 );

