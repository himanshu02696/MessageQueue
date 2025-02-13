package com.assignment.MessageQueue.Message;
import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {

    private final Queue<String> queue = new LinkedList<>();

    public void addMessage(String message) {
        synchronized (queue) {
            queue.add(message);
        }
    }

    public String consumeMessage() {
        synchronized (queue) {
            return queue.poll();
        }
    }
}