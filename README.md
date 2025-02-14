This project simulates a Producer-Consumer scenario using a message queue in a Java Spring Boot application. The system consists of a MessageProducer that generates random messages and a MessageConsumer that consumes and processes these messages.

The MessageQueue holds the messages temporarily before they are consumed. We also implemented Error Logging to track the number of successful and failed message processing attempts. The system logs the status of each message consumption and provides a way to track how many messages were successfully processed and how many encountered errors.

Key Features:
Message Queue: A queue that temporarily stores messages for consumption.
Message Producer: Generates random messages and adds them to the queue.
Message Consumer: Consumes messages from the queue, processes them, and logs success or failure.
Error Logging Service: Tracks and logs successful and failed message processing attempts.
Unit Tests: Includes unit tests to verify both success and failure scenarios.

Project Structure:-
MessageQueueApplication
├── src
│   └── main
│       └── java
│           └── com
│               └── assignment
│                   └── MessageQueue
│                       ├── Controller
│                       │   └── MessageController.java
│                       ├── Consumer
│                       │   └── MessageConsumer.java
│                       ├── Message
│                       │   └── MessageQueue.java
│                       ├── Producer
│                       │   └── MessageProducer.java
│                       ├── Services
│                       │   └── ErrorLoggingService.java
│                       └── MessageQueueApplication.java
└── test
    └── java
        └── com
            └── assignment
                └── MessageQueue
                    └── MessageQueueApplicationTests.java


Breakdown of the Structure:
Controller:
MessageController.java: Exposes two HTTP endpoints (/produce and /consume) for the producer and consumer functionality.

Consumer:
MessageConsumer.java: Consumes messages from the queue and processes them. Handles errors during the processing.

Message:
MessageQueue.java: Implements a thread-safe message queue using LinkedList and synchronized methods for message addition and removal.

Producer:
MessageProducer.java: Produces random messages (UUIDs) and adds them to the message queue.

Services:
ErrorLoggingService.java: Logs the number of successfully processed messages and failed processing attempts.

Main Application:
MessageQueueApplication.java: The main entry point of the Spring Boot application that wires up the dependencies using Spring's @Bean annotations and runs the application.

Test:
MessageQueueApplicationTests.java: Contains unit tests using Mockito and JUnit to verify the correct behavior of the system in success and failure scenarios.


Key Dependencies
Spring Boot: Provides the framework for building the application and exposing the RESTful endpoints.
JUnit 5: Used for writing and running unit tests.
Mockito: Used for mocking dependencies in unit tests (e.g., ErrorLoggingService).
SLF4J: Provides logging functionality throughout the application.

Future Enhancements
Advanced Error Handling: Implement retry logic and more granular error handling.
Persistence: Integrate a persistent message store (e.g., a database or file system) for messages.
Queue Monitoring: Implement a feature to monitor the health of the message queue and consumer status.
Scalability: Make the message queue and consumer services scalable using Spring Cloud or other message queue systems like Kafka or RabbitMQ.


Testing the Endpoints with Postman :-
Once the application is running, you can test the API endpoints using Postman.

Open Postman on your system.
You need to test two main endpoints:

Produce a message:
Method: GET
URL: http://localhost:8080/produce
Action: This will trigger the MessageProducer to produce a random message and add it to the queue.

Consume a message:
Method: GET
URL: http://localhost:8080/consume
Action: This will trigger the MessageConsumer to consume the message from the queue and process it.

Example request in Postman:
URL: http://localhost:8080/produce
Method: GET
Press Send to generate a message. You should see the response "Message Produced" in Postman.
Then, for consuming the message:

URL: http://localhost:8080/consume
Method: GET
Press Send to consume the message. You will see the result in the response, which may either be a success message or an error message depending on the message processing.
Response Example:
Message Produced: "Message Produced"
Message Consumed: "Message Consumed"
Logs in the console will show the processed message or any errors that occurred during processing.

Running Unit Tests (Optional)
Using Maven: 
mvn test

Summary of Commands
Build the project with Maven:
mvn clean install

Run the application with Maven:
mvn spring-boot:run

Test the endpoints with Postman:
GET http://localhost:8080/produce
GET http://localhost:8080/consume

Run the tests with Maven:
mvn test

MessageQueueApplication locally on your system using the terminal and test the endpoints with Postman.
