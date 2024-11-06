create database quan_ly_thue_phong_tro;
use quan_ly_thue_phong_tro;
CREATE TABLE HinhThucThanhToan (
    MaHinhThuc INT PRIMARY KEY AUTO_INCREMENT,
    TenHinhThuc VARCHAR(50) NOT NULL
);

-- Chèn các hình thức thanh toán vào bảng HinhThucThanhToan
INSERT INTO HinhThucThanhToan (TenHinhThuc)
VALUES ('Theo tháng'), ('Theo quý'), ('Theo năm');

-- Tạo bảng PhongTro
CREATE TABLE PhongTro (
    MaPhongTro INT PRIMARY KEY AUTO_INCREMENT,
    TenNguoiThue VARCHAR(100) NOT NULL,
    SoDienThoai VARCHAR(15),
    NgayBatDauThue DATE,
    MaHinhThucThanhToan INT,
    GhiChu TEXT,
    FOREIGN KEY (MaHinhThucThanhToan) REFERENCES HinhThucThanhToan(MaHinhThuc)
);