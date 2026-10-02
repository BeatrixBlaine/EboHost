package com.ebohost.availabilityservice.dto;

import com.ebohost.availabilityservice.entity.AvailabilityStatus;

import java.time.LocalDate;

public class AvailabilityRequest {

    private int roomId;
    private LocalDate date;
    private AvailabilityStatus status;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AvailabilityStatus getStatus() {
        return status;
    }

    public void setStatus(AvailabilityStatus status) {
        this.status = status;
    }
}
