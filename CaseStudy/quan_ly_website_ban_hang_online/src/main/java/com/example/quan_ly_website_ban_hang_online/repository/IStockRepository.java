package com.example.quan_ly_website_ban_hang_online.repository;

import com.example.quan_ly_website_ban_hang_online.Model.Kho;

import java.util.List;

public interface IKhoRepository {
    List<Kho> addStock(Kho kho);
    List<Kho> deleteStock(Kho kho);
}
