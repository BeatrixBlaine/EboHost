package com.ebohost.hotelservice.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HotelRestController {

    @GetMapping("/hotels")
    public String getHotels() {
        return "this is hotels";
    }

}
