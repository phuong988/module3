package com.example.quan_ly_website_ban_hang_online.Model;

import javax.xml.crypto.Data;

public class Kho {
    private int id;
    private int idSanPham;
    private double soLuong;
    private Data ngayNhap;
    private boolean isDelete;

    public Kho() {
    }

    public Kho(Data ngayNhap, double soLuong, int idSanPham) {
        this.ngayNhap = ngayNhap;
        this.soLuong = soLuong;
        this.idSanPham = idSanPham;
    }

    public Kho(int idSanPham, double soLuong, Data ngayNhap, boolean isDelete) {
        this.idSanPham = idSanPham;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
        this.isDelete = isDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    public Data getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Data ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
