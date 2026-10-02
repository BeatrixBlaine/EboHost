package com.ebohost.availabilityservice.service;

import com.ebohost.availabilityservice.dto.AvailabilityRequest;
import com.ebohost.availabilityservice.entity.Availability;

import java.util.List;

public interface AvailabilityService {

    List<Availability> findAll();
    Availability findById(int id);
    Availability save(AvailabilityRequest availabilityRequest);
    void deleteById(int id);
    Availability update(int id, AvailabilityRequest availabilityRequest);

}
