package repository;

import model.RoomRental;

import java.util.List;

public interface IMotelRoomRepository {
    RoomRental findById(int rentalRoomId);
    List<RoomRental> findAll();
    List<RoomRental> search(String keyword);
    void add(RoomRental motelRoom);
    void remove(int id);
    void save(List<Integer> ids);

}
