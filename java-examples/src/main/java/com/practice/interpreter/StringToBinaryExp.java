package com.practice.interpreter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringToBinaryExp implements IExpression {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringToBinaryExp.class);
    private String str;
    public StringToBinaryExp(String s) {
        this.str = s;
    }

    @Override
    public void interpret(Context ic) {
        ic.getBinaryForm(str);
    }
}
