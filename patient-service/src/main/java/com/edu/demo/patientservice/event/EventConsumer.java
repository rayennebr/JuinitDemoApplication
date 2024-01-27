package com.edu.demo.patientservice.event;

import com.edu.demo.patientservice.payload.DataEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventConsumer {
/*
    @KafkaListener(topics = "firstTopic",groupId = "myGroup")
    public void consumeMsg(String msg){
        log.info("event from consume msg :{}",msg);

    }*/

    @KafkaListener(topics = "firstTopic",groupId = "myGroup")
    public void consumeJsonMsg(DataEvent dataEvent){
        log.info("event from consume msg :{}",dataEvent);

    }
}
