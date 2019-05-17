package com.example.demo.service;

import com.example.demo.domain.Entity;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

public interface EntityService {

    Entity addEntity(Entity e);
    Entity findEntity(UUID id);
    Set<Map.Entry<UUID, Entity>> findAllEntities();

}
