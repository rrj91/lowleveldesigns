# lowleveldesigns
Contains low level designed code

## TicTacToe
Low level design of tictactoe
## Book my show
Low level design of book my show
## Parking lot
Low level design of parking lot
## Split wise
Low level design of splitwise

## Kafka consumer

Consumer command line commands 
### For creating topic
```
bin/kafka-topics.sh --create --topic <topic_id> --bootstrap-server <server_ip_port>
```
### eg.
```
bin/kafka-topics.sh --create --topic quickstart-events-user --bootstrap-server localhost:9092
```
### For Listing on a topic
```
bin/kafka-console-consumer.sh --topic <topic_id> --from-beginning --bootstrap-server <server_ip_port>
```
### eg.
```
bin/kafka-console-consumer.sh --topic quickstart-events-user --from-beginning --bootstrap-server localhost:9092
```

## Kafka Producer ##

Producer command line commands
```
bin/kafka-console-producer.sh --topic <topic_id> --bootstrap-server <server_ip_port>
```
### eg.
```
bin/kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092
```

