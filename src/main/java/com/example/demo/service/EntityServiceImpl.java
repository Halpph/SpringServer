package com.example.demo.service;

import com.example.demo.EntityRepository;
import com.example.demo.domain.Entity;
import org.springframework.stereotype.Service;


import java.util.Map;
import java.util.Set;
import java.util.UUID;
@Service
public class EntityServiceImpl implements EntityService {

    public static EntityRepository a = new EntityRepository();

    public Entity addEntity(Entity e) {
        if (a.getEntityRepository().containsKey(e.getId()))
            return null;
        else {
            a.getEntityRepository().put(e.getId(), e);
            return e;
        }
    }



    public Entity editStatus(UUID id){
        //if (a.getEntityRepository().containsKey(id)) return null;

        Entity ent =  a.getEntityRepository().get(id);
        if ( ent.getStatus() == Entity.StatusEnum.IN_PROGRESS) {
            ent.setStatus(Entity.StatusEnum.FINISHED);
            System.out.println("changed status of session: " + id.toString() + " to "+ ent.getStatus().toString() );
        }
        return ent;
    }



    @Override
    public Entity findEntity(UUID id) {

        if(a.getEntityRepository().containsKey(id)){
            return a.getEntityRepository().get(id);
        }
        else return null;
    }

    @Override
    public Set<Map.Entry<UUID, Entity>> findAllEntities() {
        return a.getEntityRepository().entrySet();
    }

    public int sizeOfRepository(){
        return a.getEntityRepository().size();
    }


    public void ao(UUID id){
        System.out.println(a.getEntityRepository().containsKey(UUID.fromString("a16427c8-d4b9-42e5-9fbc-b1709bc1b6ed")));
    }

}



