package com.example.demo.BootStrap;

import com.example.demo.Repository.EntityRepository;
import com.example.demo.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    public static EntityServiceImpl prova = new EntityServiceImpl();
    @Override
    public void run(String... args) throws Exception {

       /* System.out.println("Loading entities data");


        Entity e1 = new Entity(UUID.fromString("a16427c8-d4b9-42e5-9fbc-b1709bc1b6ed"),"stazione1", LocalDateTime.now(), Entity.StatusEnum.FINISHED);
        Entity e2 = new Entity(UUID.randomUUID(),"stazione2", LocalDateTime.now(), Entity.StatusEnum.FINISHED);
        Entity e3 = new Entity(UUID.randomUUID(),"stazione3", LocalDateTime.now(), Entity.StatusEnum.IN_PROGRESS);


        prova.addEntity(e1);
        prova.addEntity(e2);
        prova.addEntity(e3);
        System.out.println(prova.findAllEntities());
        System.out.println("Repository populated with: "+ prova.sizeOfRepository()+ " stations");
*/
    }
}
