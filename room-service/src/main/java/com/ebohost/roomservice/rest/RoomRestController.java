package com.ebohost.roomservice.rest;

import com.ebohost.roomservice.service.RoomService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomRestController {

    private final RoomService roomService;

    public RoomRestController(RoomService roomService) {
        this.roomService = roomService;
    }
}
