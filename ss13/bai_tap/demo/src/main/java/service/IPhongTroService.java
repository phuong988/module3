package service;

import DTO.PhongTroDTO;
import model.PhongTro;

import java.util.List;

public interface IPhongTroService {
    List<PhongTroDTO> getAllPhongTro();
    List<PhongTroDTO> timTheoTen(String tenNguoiThue);
    void addPhongTro(PhongTro phongTro);
    void deletePhongTro(int ma);


}
