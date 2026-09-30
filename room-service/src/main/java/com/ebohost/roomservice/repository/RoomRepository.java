package com.ebohost.roomservice.repository;

import com.ebohost.roomservice.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
