package com.example.demo.controllers;

import com.example.demo.BootStrap.BootStrapData;
import com.example.demo.domain.Entity;
import com.example.demo.domain.EntityResponse;
import com.example.demo.domain.Summary;
import com.example.demo.service.EntityService;
import com.example.demo.service.EntityServiceImpl;
import com.example.demo.service.MetricService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static com.example.demo.controllers.EntityController.BASE_URL;

@RestController
@RequestMapping(BASE_URL)
public class EntityController {

    private final EntityService entityService;
    private final MetricService metricService = new MetricService();

    public static final String BASE_URL = "/chargingSessions";
    EntityServiceImpl t = BootStrapData.prova;

    public EntityController(EntityService entityService) {
        this.entityService = entityService;
    }

    @GetMapping
    private Set<Entity> getAllChargingSession(){
        Set<Entity> set = new HashSet<Entity>();
        for (Map.Entry<UUID, Entity> a : t.findAllEntities()) {
            set.add(a.getValue());
        }
        return set;
    }

    @PutMapping(value= "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    private Entity finishSession(@PathVariable String id){
        UUID uuid = UUID.fromString(id);
        System.out.println(id);
        System.out.println(uuid);
        Entity ret = t.editStatus(uuid);
        metricService.increaseCount("FINISH");
        metricService.increaseCount("TOTAL");
        return  ret;
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public EntityResponse createEntity(@RequestBody Map<String,Object> requestDetails) {
        Entity returnValue = new Entity(requestDetails.get("stationId").toString(), LocalDateTime.parse(requestDetails.get("timestamp").toString()));
        t.addEntity(returnValue);
        metricService.increaseCount("STARTED");
        metricService.increaseCount("TOTAL");
        //System.out.println("Added: "+ t.findEntity(returnValue.getId())+ "to Sessions");
        return new EntityResponse(returnValue);
    }


    @RequestMapping(value = "/summary", method = RequestMethod.GET)
    @ResponseBody
    public Summary getStatusMetric() {
        return metricService.getSummary();
    }

}
