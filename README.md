# RabbitMqStickyHashing
This repository demonstrates sticky routing with consistent hashing in RabbitMQ, ensuring that: - Messages with the same hash key are consistently routed to the same queue. - Consumers run only on specific nodes, despite sharing the same codebase. - Environment-based configurations dynamically adjust between local and clustered setups.
