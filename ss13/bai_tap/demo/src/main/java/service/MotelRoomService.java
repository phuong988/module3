package service;

import model.RoomRental;
import repository.IMotelRoomRepository;
import repository.MotelRoomRepository;


import java.util.List;

public class MotelRoomService implements IMotelRoomService {
    IMotelRoomRepository motelRoomRepository= new MotelRoomRepository();
    @Override
    public List<RoomRental> findAll() {
        return motelRoomRepository.findAll();
    }

    @Override
    public List<RoomRental> searchByTenantName(String name) {
        return motelRoomRepository.searchByTenantName(name);
    }

    @Override
    public void add(RoomRental motelRoom) {
        motelRoomRepository.add(motelRoom);
    }

    @Override
    public void delete(int id) {
        motelRoomRepository.delete(id);
    }

    @Override
    public void deleteMultiple(List<Integer> ids) {

    }
}
