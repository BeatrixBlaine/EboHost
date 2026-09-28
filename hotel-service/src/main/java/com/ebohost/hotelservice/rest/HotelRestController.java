package com.ebohost.hotelservice.rest;

import com.ebohost.hotelservice.entity.Hotel;
import com.ebohost.hotelservice.service.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HotelRestController {

    private final HotelService hotelService;

    public HotelRestController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotels")
    public List<Hotel> getHotels() {
        return hotelService.findAll();
    }

}
