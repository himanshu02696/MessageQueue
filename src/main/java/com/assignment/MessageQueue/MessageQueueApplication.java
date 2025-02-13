package com.assignment.MessageQueue;
import com.assignment.MessageQueue.Consumer.MessageConsumer;
import com.assignment.MessageQueue.Message.MessageQueue;
import com.assignment.MessageQueue.Producer.MessageProducer;
import com.assignment.MessageQueue.Services.ErrorLoggingService;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MessageQueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageQueueApplication.class, args);
	}

	@Bean
	public MessageProducer messageProducer(MessageQueue messageQueue) {
		return new MessageProducer(messageQueue);
	}

	@Bean
	public MessageConsumer messageConsumer(MessageQueue messageQueue, ErrorLoggingService errorLoggingService) {
		return new MessageConsumer(messageQueue, errorLoggingService);
	}

	@Bean
	public ErrorLoggingService errorLoggingService() {
		return new ErrorLoggingService();
	}

	@Bean
	public MessageQueue messageQueue() {
		return new MessageQueue();
	}
}
