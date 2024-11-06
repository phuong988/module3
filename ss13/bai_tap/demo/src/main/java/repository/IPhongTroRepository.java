package repository;

import DTO.PhongTroDTO;
import model.PhongTro;

import java.util.List;

public interface IPhongTroRepository {
    List<PhongTroDTO> getAllPhongTro();
    List<PhongTroDTO> timTheoTen(String tenNguoiThue);
    void addPhongTro(PhongTro phongTro);
    void deletePhongTro(int ma);
}
