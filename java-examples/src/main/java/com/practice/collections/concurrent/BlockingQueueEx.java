package com.practice.collections.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockingQueueEx {
    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(4);
    private static final Logger LOGGER = LoggerFactory.getLogger(BlockingQueueEx.class);
    
    public static void main(String... args) {
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread producingThread = new Thread(producer);
        Thread consumingThread = new Thread(consumer);

        LOGGER.info(" ****Starting the Blocking Queue Example ****");
        producingThread.start();
        consumingThread.start();

        try {
            producingThread.join();
            consumingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info(" ****End of the Blocking Queue Example ****");
    }
    
    
}