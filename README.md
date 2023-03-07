# kafka-producer
Api use to send msg to Kafka
POST kafka-demo/producer/{topic}/send-message
Body: {
    "key":<key_value>,
    "value": <msg body>
}
