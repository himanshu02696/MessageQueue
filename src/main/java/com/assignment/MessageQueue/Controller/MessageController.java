package com.assignment.MessageQueue.Controller;

import com.assignment.MessageQueue.Consumer.MessageConsumer;
import com.assignment.MessageQueue.Producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private MessageProducer messageProducer;

    @Autowired
    private MessageConsumer messageConsumer;

    @GetMapping("/produce")
    public String produceMessage() {
        messageProducer.produceMessage();
        return "Message Produced";
    }

    @GetMapping("/consume")
    public String consumeMessage() {
        messageConsumer.consumeMessage();
        return "Message Consumed";
    }
}