package io.github.pascalgrimaud.hipswriter.web.rest;

import io.github.pascalgrimaud.hipswriter.service.SampleKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/kafka")
public class KafkaResource {

    private final Logger log = LoggerFactory.getLogger(KafkaResource.class);

    private SampleKafkaProducer sampleKafkaProducer;

    public KafkaResource(SampleKafkaProducer sampleKafkaProducer) {
        this.sampleKafkaProducer = sampleKafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.sampleKafkaProducer.sendMessage(message);
    }
}
