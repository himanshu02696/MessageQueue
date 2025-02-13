package com.assignment.MessageQueue.Producer;
import com.assignment.MessageQueue.Message.MessageQueue;

import java.util.UUID;

public class MessageProducer {

    private final MessageQueue messageQueue;

    public MessageProducer(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    public void produceMessage() {
        String message = UUID.randomUUID().toString();
        System.out.println("Produced Message: " + message);
        messageQueue.addMessage(message);
    }
}