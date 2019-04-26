package io.github.pascalgrimaud.hipswriter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SampleKafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(SampleKafkaProducer.class);
    private static final String TOPIC = "topic_writer";

    private KafkaTemplate<String, String> kafkaTemplate;

    public SampleKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        logger.info(String.format("#### -> Producing message to topic_writer -> %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }
}
