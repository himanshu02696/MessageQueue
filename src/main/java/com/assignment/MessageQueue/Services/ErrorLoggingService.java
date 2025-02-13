package com.assignment.MessageQueue.Services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorLoggingService {

    private static final Logger logger = LoggerFactory.getLogger(ErrorLoggingService.class);
    private int successfulMessages = 0;
    private int errorMessages = 0;

    public void logSuccess() {
        successfulMessages++;
        logger.info("Total successful messages: " + successfulMessages);
    }

    public void logError(String message) {
        errorMessages++;
        logger.error(message);
        logger.info("Total error messages: " + errorMessages);
    }
}