package com.example.demo.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


public  class Entity {

    static public enum StatusEnum {
        IN_PROGRESS,
        FINISHED
    }

    private UUID id;
    private String stationId;
    private LocalDateTime startedAt;
    private StatusEnum status;


    public Entity(UUID id, String stationId, LocalDateTime startedAt, StatusEnum status) {
        this.id = id;
        this.stationId = stationId;
        this.startedAt = startedAt;
        this.status = status;
    }

    public Entity(String stationId, LocalDateTime startedAt){
        this.id= UUID.randomUUID();
        this.stationId = stationId;
        this.startedAt = startedAt;
        this.status = StatusEnum.IN_PROGRESS;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return id.equals(entity.id) &&
                stationId.equals(entity.stationId) &&
                startedAt.equals(entity.startedAt) &&
                status == entity.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stationId, startedAt, status);
    }


    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", stationId='" + stationId + '\'' +
                ", startedAt=" + startedAt +
                ", status=" + status +
                '}';
    }
}
