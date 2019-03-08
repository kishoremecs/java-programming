package com.practice.interpreter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class InterpreterPatternEx {

    private static final Logger LOGGER = LoggerFactory.getLogger(InterpreterPatternEx.class);
    private Context context = null;
    private IExpression expression = null;

    public InterpreterPatternEx(Context ic) {
        this.context = ic;
    }

    public void interpret(String str) {
        for(int i =0; i < 2; i++) {
            LOGGER.info("Enter your choice (1 or 2)");
            Scanner in = new Scanner(System.in);
            String c = in.nextLine();
            if(c.equals("1")) {
                expression = new IntToWords(str);
            } else {
                expression = new StringToBinaryExp(str);
            }
            expression.interpret(context);
        }
    }
    public static void main(String... args) {
        LOGGER.info("**** Interpreter Pattern Demo **** ");
        LOGGER.info("Enter a Number: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Context ctx = new Context(input);
        InterpreterPatternEx client = new InterpreterPatternEx(ctx);
        client.interpret(input);
        LOGGER.info("**** Interpreter Pattern Demo End**** ");
    }


}
