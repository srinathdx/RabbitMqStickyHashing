# RabbitMqStickyHashing
This repository demonstrates sticky routing with consistent hashing in RabbitMQ, ensuring that: - Messages with the same hash key are consistently routed to the same queue. - Consumers run only on specific nodes, despite sharing the same codebase. - Environment-based configurations dynamically adjust between local and clustered setups.

🔧 Features
✅ Consistent Hashing Exchange for sticky routing
✅ Dynamic Consumer Node Affinity using environment variables (NODE_ID)
✅ Spring Boot Auto-Configuration for queue and node bindings
✅ Supports Localhost & Clustered Deployments
✅ RabbitMQ Management UI & CLI Integration


📦 src/main/java/com/example/rabbitmq
 ┣ 📜 RabbitMQConfig.java   # Configures exchange, queues & hashing
 ┣ 📜 RabbitMQConsumer.java # Consumer listens based on NODE_ID
 ┣ 📜 RabbitMQPublisher.java # Publishes messages with hash key
 ┗ 📜 application.yml       # Environment-based configuration
