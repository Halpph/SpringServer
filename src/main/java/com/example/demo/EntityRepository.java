package com.example.demo;

import com.example.demo.domain.Entity;

import java.util.HashMap;
import java.util.UUID;

public class EntityRepository {

    private HashMap<UUID, Entity> map;

    public EntityRepository() {

        this.map = new HashMap<UUID,Entity>();
    }

    public HashMap<UUID, Entity> getEntityRepository() {
        return map;
    }



    @Override
    public String toString() {
        return "EntityRepository{" +
                "entityRepository=" + map +
                '}';
    }
}
