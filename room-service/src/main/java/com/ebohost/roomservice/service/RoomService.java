package com.ebohost.roomservice.service;

import com.ebohost.roomservice.dto.RoomRequest;
import com.ebohost.roomservice.entity.Room;

import java.util.List;

public interface RoomService {

    List<Room> findAll();
    Room findById(int id);
    Room save(RoomRequest roomRequest);
    void deleteById(int id);
    Room update(int id, RoomRequest roomRequest);

}
