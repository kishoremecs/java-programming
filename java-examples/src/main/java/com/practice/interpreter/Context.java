package com.practice.interpreter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;

class Context {

    private static final Logger LOGGER = LoggerFactory.getLogger(Context.class);

    public String input;
    public Context(String input) {
        this.input = input;
    }

    public void getBinaryForm(String input) {
        int i = Integer.parseInt(input);
        String binaryString = Integer.toBinaryString(i);
        LOGGER.info("Binary equivalent of {}  is {} ", i, binaryString);
    }

    public void printInWords(String input) {
        this.input = input;
        LOGGER.info("Printing the input in words");
        char c[] = input.toCharArray();
        for(int i =0; i < c.length; i++) {
            switch(c[i]) {

                case '1':
                    LOGGER.info("One "); break;
                case '2':
                    LOGGER.info("Two "); break;
                case '3':
                    LOGGER.info("Three "); break;
                case '4':
                    LOGGER.info("Four "); break;
                case '5':
                    LOGGER.info("Five "); break;
                case '6':
                    LOGGER.info("Six "); break;
                case '7':
                    LOGGER.info("Seven "); break;
                case '8':
                    LOGGER.info("Eight "); break;
                case '9':
                    LOGGER.info("Nine "); break;
                case '0':
                    LOGGER.info("Zero "); break;
                default:
                    LOGGER.info("* "); break;


            } //switch
        }// for

    }//printInWords

}
