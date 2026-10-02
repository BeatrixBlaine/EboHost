package com.ebohost.availabilityservice.repository;

import com.ebohost.availabilityservice.entity.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {
}
