package com.practice.collections.concurrent;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


class Producer implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
    private volatile BlockingQueue<String> bQueue;
    private int turns = 13;
    private int turnCount = 0;
    private String[] input;
    private String[] signs = {
        "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo",
        "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces","Stop"
    };

    public Producer(BlockingQueue bQueue) {
        this.bQueue = bQueue;
        this.input = signs;
    }

    public Producer(int turns,BlockingQueue bQueue) {
        this.bQueue = bQueue;
        this.turns = turns;
        this.input = signs;
    }

    public Producer(int turns,BlockingQueue bQueue, String... items) {
        this.bQueue = bQueue;
        this.turns = turns;
        this.input = items;
    }

    public void run() {
        LOGGER.info("Inserting the data to the Blocking Queue Started");
        while(turnCount < turns) {

            try {
                bQueue.put(input[turnCount]);
                LOGGER.info("Inserting the item {} to the  queue", input[turnCount]);
            } catch(Exception e) {
                LOGGER.error("Exception occurred while inserting the item to the Queue {}", e.getMessage());
                break;
            }

            turnCount++;

        }
        LOGGER.info("Inserting the data to the Blocking Queue Completed");
        
    }
}