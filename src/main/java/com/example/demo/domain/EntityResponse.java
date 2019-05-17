package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class EntityResponse{

    private UUID id;
    private String stationid;
    private LocalDateTime timestamp;

    public EntityResponse(Entity e) {
        this.id = e.getId();
        this.stationid =e.getStationId();
        this.timestamp = e.getStartedAt();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStationid() {
        return stationid;
    }

    public void setStationid(String stationid) {
        this.stationid = stationid;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "EntityResponse{" +
                "id=" + id +
                ", stationid='" + stationid + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
