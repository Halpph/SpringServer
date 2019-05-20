package com.example.demo.Repository;

import com.example.demo.domain.Entity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.UUID;


public class EntityRepository {

    private HashMap<UUID, Entity> map;

    @Autowired
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
