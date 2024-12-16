# Kafka Project with Zookeeper, Brokers, Schema Registry, and Control Center

1. Project Overview 
This project demonstrates a simple Kafka setup with the following components :
   Zookeeper: Coordinates and manages Kafka brokers.
   Kafka Brokers: Handles message distribution and ensures fault tolerance.
   Schema Registry: Manages Avro schemas for serialized message data.
   Kafka Control Center: Monitors Kafka topics, messages, and metrics.
   Spring Boot Application: Implements Kafka producer and consumer functionality using Avro serialization/deserialization.

2. Prerequisites 
Ensure the following tools are installed on your system :
   Docker: To run Kafka components in containers.
   Java 11 or higher: For the Spring Boot application.
   Postman or curl: To send HTTP requests for testing.
   Docker Desktop(Optional): To verify the status of containers

3. Starting Kafka Components with Docker Compose 
      Start all the the components of kafka using below command :
         docker compose up -d
      Stop all the the components of kafka using below command :
         docker compose down

4. Configuring and Running the Spring Application
   Configure application.yml
    Update the application.yml file with Kafka and Schema Registry details
      Run the Spring Application
         Build and run the application:
            mvn spring-boot:run

5. Sending and Consuming Messages
    Use Postman or curl to send a message to the producer endpoint:
     Application runs on port 8181 as mentioned in yaml file,  send POST request to producer
        URL : http://localhost:8181/employees
        Method : POST
        RequestBody:
          {
            "id" : "5676559",
            "firstName" : "Cath",
            "lastName" : "Marina",
            "dob" : "16/11/1989",
            "email" : "cath@gmail.com"
        }
   
     Consumer Logs
          The consumer automatically consumes the message and logs it to the console:
            Received message: Employee{id=1, name='Alice', department='Engineering'}

6. Monitoring Kafka with Control Center
    Kafka Control Center provides a web-based UI to monitor your Kafka cluster.
    Open your browser and go to http://localhost:9021.
    Key features:
      -> View and manage topics.
      -> Monitor message throughput and latency.
      -> Inspect consumer group performance.
      -> Topic Details:
                Use the Control Center to create new topics or inspect messages in existing topics.

7. Example Avro Schema
   The project uses Avro for serialization/deserailization. Below is the Avro schema for an employee record:
   {
      "namespace": "com.example.spring_kafka_avroschema.dto",
      "type": "record",
      "name": "Employee",
      "fields": [
          {
            "name": "id",
            "type": "string"
          },
        {
           "name": "firstName",
          "type": "string"
        },
        {
          "name": "lastName",
          "type": "string"
        },
        {
          "name": "dob",
          "type": "string",
          "default": ""
        },
        {
          "name": "email",
          "type": "string",
          "default": ""
        }
      ]
   }


   
   
    
