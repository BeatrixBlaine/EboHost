package com.ebohost.hotelservice.service;

import com.ebohost.hotelservice.entity.Hotel;
import com.ebohost.hotelservice.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findById(int id) {

        Optional<Hotel> tempHotel = hotelRepository.findById(id);

        Hotel theHotel;

        if(tempHotel.isPresent()) {
            theHotel = tempHotel.get();
        } else {
            throw new RuntimeException("Hotel not found - " + id);
        }

        return theHotel;
    }

    @Override
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public void deleteById(int id) {
        hotelRepository.deleteById(id);
    }
}
