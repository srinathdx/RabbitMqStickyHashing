package com.sr.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class QueueNameProvider {

    private final String queueName;

    public QueueNameProvider() {
        String nodeId = System.getenv("node-id"); // Get the node name
        if ("node1".equalsIgnoreCase(nodeId)) {
            this.queueName = "collegeQueue1";
        } else if ("node2".equalsIgnoreCase(nodeId)) {
            this.queueName = "collegeQueue2";
        } else {
            throw new IllegalArgumentException("Unsupported node-id: " + nodeId);
        }
    }

    public String getQueueName() {
        return queueName;
    }
}
