package com.ebohost.roomservice.service;

import com.ebohost.roomservice.dto.RoomRequest;
import com.ebohost.roomservice.entity.Room;
import com.ebohost.roomservice.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> findAll() {
        return List.of();
    }

    @Override
    public Room findById(int id) {
        return null;
    }

    @Override
    public Room save(RoomRequest roomRequest) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Room update(int id, RoomRequest roomRequest) {
        return null;
    }
}
