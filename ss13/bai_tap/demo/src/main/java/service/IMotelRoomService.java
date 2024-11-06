package service;

import model.RoomRental;

import java.util.List;

public interface IMotelRoomService  {
    List<RoomRental> findAll();
    List<RoomRental> searchByTenantName(String name);
    void add(RoomRental motelRoom);
    void delete(int id);
    void deleteMultiple(List<Integer> ids);

}
