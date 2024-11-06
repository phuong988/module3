package repository;

import DTO.PhongTroDTO;
import model.PhongTro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhongTroRepository implements IPhongTroRepository {
    BaseRepository baseRepository = new BaseRepository();

    String GET_ALL_PHONG_TRO = "SELECT pt.ma,pt.ten_nguoi_thue,pt.so_dien_thoai,pt.ngay_thue,ht.ten as ten_hinh_thuc,pt.ghi_chu FROM phong_tro pt join hinh_thuc ht ON pt.hinh_thuc_ma = ht.ma ";
    String GET_ALl_PHONG_TRO_THEO_TEN = "SELECT pt.ma,pt.ten_nguoi_thue,pt.so_dien_thoai,pt.ngay_thue,ht.ten as ten_hinh_thuc,pt.ghi_chu FROM phong_tro pt join hinh_thuc ht ON pt.hinh_thuc_ma = ht.ma where pt.ten_nguoi_thue LIKE ?";

    public List<PhongTroDTO> getAllPhongTro() {
        List<PhongTroDTO> phongTros = new ArrayList<>();
        try (Connection connection = baseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_PHONG_TRO)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ma");
                String tenNguoiThue = resultSet.getString("ten_nguoi_thue");
                int soDienThoai = resultSet.getInt("so_dien_thoai");
                Date ngayThue = resultSet.getDate("ngay_thue");
                String hinhThucThue = resultSet.getString("ten_hinh_thuc");
                String ghiChu = resultSet.getString("ghi_chu");

                PhongTroDTO phongTro = new PhongTroDTO(id, tenNguoiThue,soDienThoai, ngayThue, hinhThucThue, ghiChu);
                phongTros.add(phongTro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return phongTros;
    }

    public List<PhongTroDTO> timTheoTen(String tenNguoiThue) {
        List<PhongTroDTO> phongTros = new ArrayList<>();
        try (Connection connection = baseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(GET_ALl_PHONG_TRO_THEO_TEN)) {
            statement.setString(1, "%" + tenNguoiThue + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ma");
                String ten = resultSet.getString("ten_nguoi_thue");
                int soDienThoai = resultSet.getInt("so_dien_thoai");
                Date ngayThue = resultSet.getDate("ngay_thue");
                String hinhThucMa = resultSet.getString("ten_hinh_thuc");
                String ghiChu = resultSet.getString("ghi_chu");

                PhongTroDTO phongTro = new PhongTroDTO(id, ten, soDienThoai, ngayThue, hinhThucMa, ghiChu);
                phongTros.add(phongTro);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return phongTros;

    }

    public void addPhongTro(PhongTro phongTro) {
        String INSERT_PHONG_TRO = "INSERT INTO phong_tro (ten_nguoi_thue, so_dien_thoai, ngay_thue, hinh_thuc_ma, ghi_chu) VALUES (?,?,?,?,?)";
        try (Connection connection = baseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(INSERT_PHONG_TRO)) {
            statement.setString(1, phongTro.tenNguoiThue);
            statement.setInt(2, phongTro.soDienThoai);
            statement.setDate(3,phongTro.ngayThue);
            statement.setInt(4, phongTro.maHinhThucThue);
            statement.setString(5, phongTro.ghiChu);
            statement.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deletePhongTro(int ma) {
        String DELETE_PHONG_TRO = "DELETE FROM phong_tro WHERE ma =?";
        try (Connection connection = baseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(DELETE_PHONG_TRO)) {
            statement.setInt(1, ma);
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
