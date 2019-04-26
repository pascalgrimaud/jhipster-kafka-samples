package io.github.pascalgrimaud.hipsreader.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SampleKafkaConsumer {

    private final Logger logger = LoggerFactory.getLogger(SampleKafkaConsumer.class);

    @KafkaListener(topics = "topic_writer", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message in topic_writer -> %s", message));
    }
}
