package com.example.demo.service;

import com.example.demo.domain.Summary;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class MetricService {


    private ConcurrentMap<String, Summary> timeMap = new ConcurrentHashMap<String, Summary>();
    //private static SimpleDateFormat dateFormat;

    public void increaseCount(String request) {
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        //String time = dateFormat.format(new Date());
        Summary summary;
        if (!timeMap.containsKey(time)){
            summary = new Summary();
        }
        else {
            summary = timeMap.get(time);
            //System.out.println("esiste un summary");
            //System.out.println(summary);
        }

        if (request.equals("TOTAL")) {
            summary.setTotalCount();
        }
        else if (request.equals("STARTED"))
            summary.setStartedCount();

        else
            summary.setStoppedCount();

        timeMap.put(time, summary);
    }

    public Summary getSummary() {
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        Summary ret;
        if (!timeMap.containsKey(time)) {
            ret = new Summary();
        }
        else
            ret = timeMap.get(time);
        return ret;
    }



}
