# kafka-producer
Api use to send msg to Kafka

First update the kafka server IP in the KafkaProducerConfig.java

POST kafka-demo/producer/{topic}/send-message

Body: {
    "key":<key_value>,
    "value": <msg body>
}
