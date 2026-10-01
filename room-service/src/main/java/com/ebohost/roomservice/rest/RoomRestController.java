package com.ebohost.roomservice.rest;

import com.ebohost.roomservice.dto.RoomRequest;
import com.ebohost.roomservice.entity.Room;
import com.ebohost.roomservice.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomRestController {

    private final RoomService roomService;

    public RoomRestController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public List<Room> getRooms() {
        return roomService.findAll();
    }

    @GetMapping("/rooms/{roomId}")
    public Room getRoom(@PathVariable int roomId) {
        return roomService.findById(roomId);
    }

    @PostMapping("/rooms")
    public Room addRoom(@Valid @RequestBody RoomRequest roomRequest) {
        return roomService.save(roomRequest);
    }

    @PutMapping("/rooms/{roomId}")
    public Room updateRoom(@PathVariable int roomId,
                           @Valid @RequestBody RoomRequest roomRequest) {
        return roomService.update(roomId, roomRequest);
    }

    @DeleteMapping("/rooms/{roomId}")
    public String deleteRoom(@PathVariable int roomId) {
        roomService.deleteById(roomId);
        return "Room deleted with id: " + roomId;
    }
}
