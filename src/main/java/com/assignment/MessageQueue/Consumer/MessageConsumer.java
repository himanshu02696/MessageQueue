package com.assignment.MessageQueue.Consumer;

import com.assignment.MessageQueue.Message.MessageQueue;
import com.assignment.MessageQueue.Services.ErrorLoggingService;

public class MessageConsumer {

    private final MessageQueue messageQueue;
    private final ErrorLoggingService errorLoggingService;

    public MessageConsumer(MessageQueue messageQueue, ErrorLoggingService errorLoggingService) {
        this.messageQueue = messageQueue;
        this.errorLoggingService = errorLoggingService;
    }

    public void consumeMessage() {
        String message = messageQueue.consumeMessage();
        if (message == null) {
            errorLoggingService.logError("Failed to consume message: Queue is empty.");
            return;
        }

        try {
            processMessage(message);
            errorLoggingService.logSuccess();
        } catch (Exception e) {
            errorLoggingService.logError("Error processing message: " + message);
        }
    }

    private void processMessage(String message) throws Exception {
        if (Math.random() > 0.8) { // Simulate random errors
            throw new Exception("Random processing error.");
        }
        System.out.println("Processed Message: " + message);
    }
}