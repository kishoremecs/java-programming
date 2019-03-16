package com.practice.ds.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the main class to run the Stack Example.
 */
public class StackMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(StackMain.class);
    public static void main(String... args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(100);
        stack.push(1000);
        stack.push(412);
        stack.push(5000);
        stack.push(125);
        LOGGER.info("The Size of the stack is {}", stack.size());
        LOGGER.info("The top element of the stack is {}", stack.pop());
        LOGGER.info("The top element of the stack is {}", stack.pop());
        LOGGER.info("The top element of the stack is {}", stack.pop());
        LOGGER.info("The top element of the stack is {}", stack.pop());
        LOGGER.info("The top element of the stack is {}", stack.pop());
        LOGGER.info("The top element of the stack is {}", stack.pop());
        LOGGER.info("The top element of the stack is {}", stack.pop());
        LOGGER.info("The top element of the stack is {}", stack.pop());
        LOGGER.info("The Size of the stack is {}", stack.size());

    }


}
