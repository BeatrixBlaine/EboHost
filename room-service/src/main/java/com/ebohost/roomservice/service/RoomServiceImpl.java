package com.ebohost.roomservice.service;

import com.ebohost.roomservice.dto.RoomRequest;
import com.ebohost.roomservice.entity.Room;
import com.ebohost.roomservice.exception.HotelNotFoundException;
import com.ebohost.roomservice.exception.RoomNotFoundException;
import com.ebohost.roomservice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;
    private final RestClient restClient;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository, RestClient restClient) {
        this.roomRepository = roomRepository;
        this.restClient = restClient;
    }

    private void validateHotel(int hotelId) {
        try {
            restClient.get()
                    .uri("http://localhost:8081/api/hotels/" + hotelId)
                    .retrieve()
                    .toBodilessEntity();
        } catch (HttpClientErrorException.NotFound e) {
            throw new HotelNotFoundException(
                    "Hotel with ID " + hotelId + " does not exist"
            );
        }
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room findById(int id) {

        Optional<Room> tempRoom = roomRepository.findById(id);

        Room theRoom;

        if(tempRoom.isPresent()) {
            theRoom = tempRoom.get();
        } else {
            throw new RoomNotFoundException("Room not found with id: " + id);
        }

        return theRoom;
    }

    @Override
    public Room save(RoomRequest roomRequest) {

        // validate hotelId from hotel-service
        validateHotel(roomRequest.getHotelId());

        Room tempRoom = new Room();
        tempRoom.setHotelId(roomRequest.getHotelId());
        tempRoom.setRoomNumber(roomRequest.getRoomNumber());
        tempRoom.setRoomType(roomRequest.getRoomType());
        tempRoom.setPrice(roomRequest.getPrice());
        tempRoom.setCapacity(roomRequest.getCapacity());
        tempRoom.setDescription(roomRequest.getDescription());

        return roomRepository.save(tempRoom);
    }

    @Override
    public void deleteById(int id) {
        findById(id);
        roomRepository.deleteById(id);
    }

    @Override
    public Room update(int id, RoomRequest roomRequest) {

        Room tempRoom = findById(id);

        validateHotel(roomRequest.getHotelId());

        tempRoom.setHotelId(roomRequest.getHotelId());
        tempRoom.setRoomNumber(roomRequest.getRoomNumber());
        tempRoom.setRoomType(roomRequest.getRoomType());
        tempRoom.setPrice(roomRequest.getPrice());
        tempRoom.setCapacity(roomRequest.getCapacity());
        tempRoom.setDescription(roomRequest.getDescription());

        return roomRepository.save(tempRoom);
    }
}
