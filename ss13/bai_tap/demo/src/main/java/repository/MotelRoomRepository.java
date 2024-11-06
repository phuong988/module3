package repository;

import model.RoomRental;
import model.PaymentMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotelRoomRepository implements IMotelRoomRepository {

    private static final String SELECT_ALL_ROOMS = "SELECT * FROM motel_rooms";
    private static final String INSERT_ROOM = "INSERT INTO motel_rooms (tenant_name, phone_number, rental_start_date, payment_method_id, notes) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE_ROOM = "DELETE FROM motel_rooms WHERE rental_room_id = ?";
    private static final String SEARCH_MOTEL_ROOM = "SELECT * FROM motel_rooms WHERE tenant_name LIKE ?";

    @Override
    public List<RoomRental> findAll() {
        List<RoomRental> rooms = new ArrayList<>();
        try (Connection conn = BaseRepository.getConnectDB();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_ROOMS);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int rentalRoomId = rs.getInt("rental_room_id");
                String tenantName = rs.getString("tenant_name");
                String phoneNumber = rs.getString("phone_number");
                Date rentalStartDate = rs.getDate("rental_start_date");
                int paymentMethodId = rs.getInt("payment_method_id");
                String notes = rs.getString("notes");

                // Giả sử bạn có phương thức để lấy PaymentMethod theo ID
                PaymentMethod paymentMethod = getPaymentMethodById(paymentMethodId);

                // Tạo đối tượng MotelRoom và thêm vào danh sách
                RoomRental motelRoom = new RoomRental(rentalRoomId, tenantName, phoneNumber, rentalStartDate, paymentMethod, notes);
                rooms.add(motelRoom);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rooms;
    }

    @Override
    public List<RoomRental> search(String name) {
        List<RoomRental> result = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_MOTEL_ROOM)) {
            preparedStatement.setString(1, '%' + name + '%');
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rentalRoomId = resultSet.getInt("rental_room_id");
                String tenantName = resultSet.getString("tenant_name");
                String phoneNumber = resultSet.getString("phone_number");
                Date rentalStartDate = resultSet.getDate("rental_start_date");
                int paymentMethodId = resultSet.getInt("payment_method_id");
                String notes = resultSet.getString("notes");

                // Giả sử bạn có phương thức để lấy PaymentMethod theo ID
                PaymentMethod paymentMethod = getPaymentMethodById(paymentMethodId);

                RoomRental motelRoom = new RoomRental(rentalRoomId, tenantName, phoneNumber, rentalStartDate, paymentMethod, notes);
                result.add(motelRoom);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void add(RoomRental motelRoom) {
        try (Connection conn = BaseRepository.getConnectDB();
             PreparedStatement stmt = conn.prepareStatement(INSERT_ROOM)) {
            stmt.setString(1, motelRoom.getTenantName());
            stmt.setString(2, motelRoom.getPhoneNumber());
            stmt.setDate(3, new java.sql.Date(motelRoom.getRentalStartDate().getTime()));
            stmt.setInt(4, motelRoom.getPaymentMethod().getPaymentMethodId());
            stmt.setString(5, motelRoom.getNotes());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection conn = BaseRepository.getConnectDB();
             PreparedStatement stmt = conn.prepareStatement(DELETE_ROOM)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteMultiple(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return; // Không làm gì nếu danh sách rỗng
        }

        StringBuilder sql = new StringBuilder("DELETE FROM motel_rooms WHERE rental_room_id IN (");
        for (int i = 0; i < ids.size(); i++) {
            sql.append("?");
            if (i < ids.size() - 1) {
                sql.append(",");
            }
        }
        sql.append(")");

        try (Connection conn = BaseRepository.getConnectDB();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
            for (int i = 0; i < ids.size(); i++) {
                stmt.setInt(i + 1, ids.get(i));
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Phương thức để lấy PaymentMethod theo ID (bạn cần triển khai)
    private PaymentMethod getPaymentMethodById(int paymentMethodId) {
        // Triển khai logic để lấy PaymentMethod từ DB
        return null; // Placeholder
    }
}

