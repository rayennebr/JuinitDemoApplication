package com.edu.demo.patientservice.event;

import com.edu.demo.patientservice.payload.DataEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerEvent {

    private final KafkaTemplate<String, DataEvent> kafkaTemplate;

    public void sendMessage(DataEvent dataEvent)
    {
        log.info("send message from event : {}",dataEvent);
        org.springframework.messaging.Message<DataEvent> message= MessageBuilder.withPayload(dataEvent)
                .setHeader(KafkaHeaders.TOPIC,"firstTopic")
                .build();
        kafkaTemplate.send(message);
    }
}
