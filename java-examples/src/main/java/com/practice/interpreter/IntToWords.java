package com.practice.interpreter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntToWords implements IExpression {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringToBinaryExp.class);
    private String str;

    public IntToWords(String str) {
        this.str = str;
    }

    @Override
    public void interpret(Context ic) {
        ic.printInWords(str);
    }
}
