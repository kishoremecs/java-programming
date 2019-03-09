package com.practice.collections.concurrent;

import java.util.concurrent.BlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Consumer implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
    private BlockingQueue<String> bQueue;
    private String value = "Not Started";
    public Consumer(BlockingQueue<String> bQueue) {
        this.bQueue = bQueue;
    }

    public void run() {
        if(bQueue != null) {
            LOGGER.info("**** Consuming the items from Queue ****");
            while(!this.value.equals("Stop")) {
                try {
                    value = bQueue.take();
                    if(!this.value.equals("Stop"))
                    LOGGER.info("Received the value {} from Queue", value);
                } catch(Exception e) {
                    LOGGER.error("Exception Occurred while fetching the data from Queue {}", e.getMessage());
                }
            }
            LOGGER.info("**** End of Consuming the items from Queue****");
        }

    }
    
}