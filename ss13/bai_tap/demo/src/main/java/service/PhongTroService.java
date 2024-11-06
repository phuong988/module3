package service;

import DTO.PhongTroDTO;
import model.PhongTro;
import repository.IPhongTroRepository;
import repository.PhongTroRepository;

import java.util.List;

public class PhongTroService implements IPhongTroService {
    IPhongTroRepository phongTroRepository = new PhongTroRepository();

    @Override
    public List<PhongTroDTO> getAllPhongTro() {
        return phongTroRepository.getAllPhongTro();
    }

    @Override
    public List<PhongTroDTO> timTheoTen(String tenNguoiThue) {
        return phongTroRepository.timTheoTen(tenNguoiThue);
    }

    @Override
    public void addPhongTro(PhongTro phongTro) {
        phongTroRepository.addPhongTro(phongTro);
    }

    @Override
    public void deletePhongTro(int ma) {
        phongTroRepository.deletePhongTro(ma);
    }
}
