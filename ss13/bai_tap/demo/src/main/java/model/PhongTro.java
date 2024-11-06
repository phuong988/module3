package model;

import java.sql.Date;

public class PhongTro {
    public int maPhongTro;
    public String tenNguoiThue;
    public int soDienThoai;
    public Date ngayThue;
    public int maHinhThucThue;
    public String ghiChu;

    public PhongTro(int maPhongTro, String tenNguoiThue, int soDienThoai, Date ngayThue, int hinhThucThue, String ghiChu) {
        this.maPhongTro = maPhongTro;
        this.tenNguoiThue = tenNguoiThue;
        this.soDienThoai = soDienThoai;
        this.ngayThue = ngayThue;
        this.maHinhThucThue = hinhThucThue;
        this.ghiChu = ghiChu;
    }

    public PhongTro( String tenNguoiThue, int soDienThoai, Date ngayThue, int hinhThucThue, String ghiChu) {
        this.tenNguoiThue = tenNguoiThue;
        this.soDienThoai = soDienThoai;
        this.ngayThue = ngayThue;
        this.maHinhThucThue = hinhThucThue;
        this.ghiChu = ghiChu;
    }

    public int getMaPhongTro() {
        return maPhongTro;
    }

    public void setMaPhongTro(int maPhongTro) {
        this.maPhongTro = maPhongTro;
    }

    public String getTenNguoiThue() {
        return tenNguoiThue;
    }

    public void setTenNguoiThue(String tenNguoiThue) {
        this.tenNguoiThue = tenNguoiThue;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Date getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(Date ngayThue) {
        this.ngayThue = ngayThue;
    }

    public int getHinhThucThue() {
        return maHinhThucThue;
    }

    public void setHinhThucThue(int hinhThucThue) {
        this.maHinhThucThue = hinhThucThue;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
