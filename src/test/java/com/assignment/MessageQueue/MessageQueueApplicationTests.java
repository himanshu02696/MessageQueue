package com.assignment.MessageQueue;

import com.assignment.MessageQueue.Consumer.MessageConsumer;
import com.assignment.MessageQueue.Message.MessageQueue;
import com.assignment.MessageQueue.Producer.MessageProducer;
import com.assignment.MessageQueue.Services.ErrorLoggingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

@SpringBootTest
class MessageQueueApplicationTests {

	private MessageQueue messageQueue;
	private MessageProducer messageProducer;
	private MessageConsumer messageConsumer;
	private ErrorLoggingService errorLoggingService;

	private static final Logger logger = Logger.getLogger(MessageQueueApplicationTests.class.getName());

	@BeforeEach
	public void setup() {
		logger.info("Starting a new test...");
		messageQueue = new MessageQueue();
		errorLoggingService = mock(ErrorLoggingService.class);
		messageProducer = new MessageProducer(messageQueue);
		messageConsumer = new MessageConsumer(messageQueue, errorLoggingService);
	}

	@Test
	public void testProduceAndConsumeMessageSuccess() {
		logger.info("Executing testProduceAndConsumeMessageSuccess...");
		messageProducer.produceMessage();
		messageConsumer.consumeMessage();

		verify(errorLoggingService, times(1)).logSuccess();
	}

	@Test
	public void testConsumeMessageFailure() {
		logger.info("Executing testConsumeMessageFailure...");
		messageConsumer.consumeMessage();
		verify(errorLoggingService, times(1)).logError(anyString());
	}
}
