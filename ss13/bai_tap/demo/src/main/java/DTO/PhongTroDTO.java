package DTO;

import java.sql.Date;

public class PhongTroDTO {
    int maPhongTro;
    String tenNguoiThue;
    double soDienThoai;
    Date ngayThue;
    String hinhThucThue;
    String ghiChu;

    public PhongTroDTO(int maPhongTro, String tenNguoiThue, double soDienThoai, Date ngayThue, String hinhThucThue, String ghiChu) {
        this.maPhongTro = maPhongTro;
        this.tenNguoiThue = tenNguoiThue;
        this.soDienThoai = soDienThoai;
        this.ngayThue = ngayThue;
        this.hinhThucThue = hinhThucThue;
        this.ghiChu = ghiChu;
    }

    public PhongTroDTO( String tenNguoiThue, double soDienThoai, Date ngayThue, String hinhThucThue, String ghiChu) {
        this.tenNguoiThue = tenNguoiThue;
        this.soDienThoai = soDienThoai;
        this.ngayThue = ngayThue;
        this.hinhThucThue = hinhThucThue;
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

    public double getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(double soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Date getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(Date ngayThue) {
        this.ngayThue = ngayThue;
    }

    public String getHinhThucThue() {
        return hinhThucThue;
    }

    public void setHinhThucThue(String hinhThucThue) {
        this.hinhThucThue = hinhThucThue;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
