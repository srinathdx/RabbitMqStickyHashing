package com.sr.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publish")
public class PublisherController {

    private final RabbitTemplate rabbitTemplate;

   /* @Value("${app.node-id}")
    private String nodeId;*/

    public PublisherController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/{college}/{date}")
    public String publishMessage(@PathVariable String college, @PathVariable String date, @RequestBody String messageBody) {
        String nodeName = System.getenv("node-id"); // Get the node name
        int hashKey = Math.abs((college + "-" + date).hashCode()) % 100; // Generate a sticky routing key

        MessageProperties properties = new MessageProperties();
        properties.setContentType("text/plain");
        properties.setHeader("hash-key", hashKey); // Debugging
        Message message = new Message(messageBody.getBytes(), properties);

        rabbitTemplate.convertAndSend("collegeExchange", String.valueOf(hashKey), message);

        System.out.println("Published by: " + (nodeName != null ? nodeName : "Unknown Node") +
                " | Message: " + message.getBody().toString());
        return "Message published with sticky routing key: " + hashKey;
    }

}