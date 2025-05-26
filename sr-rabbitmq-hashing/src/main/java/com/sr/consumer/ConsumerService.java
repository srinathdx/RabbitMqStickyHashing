package com.sr.consumer;

import com.sr.configuration.QueueNameProvider;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {


    private final QueueNameProvider queueNameProvider;


    public ConsumerService(QueueNameProvider queueNameProvider) {
        this.queueNameProvider = queueNameProvider;
    }

    @RabbitListener(queues = "#{@queueNameProvider.queueName}")
    public void listen(String message) {
        String nodeId = System.getenv("node-id"); // Get the node name
        System.out.println("[Consumer] Received from " + queueNameProvider.getQueueName() + ": " + message+"node- "+nodeId);
    }
   /* @RabbitListener(queues = "collegeQueue1")
    public void consumeMessage1(String message) {
        String nodeName = System.getenv("node-id"); // Get the node name
        System.out.println("Consumer 1 received: " + message);
        System.out.println("Processed by: " + (nodeName != null ? nodeName : "Unknown Node") +
                " | Message: " + message);
    }

    @RabbitListener(queues = "collegeQueue2")
    public void consumeMessage2(String message) {
        String nodeName = System.getenv("NODE_NAME"); // Get the node name
        System.out.println("Consumer 2 received: " + message);
        System.out.println("Processed by: " + (nodeName != null ? nodeName : "Unknown Node") +
                " | Message: " + message);
    }*/

}