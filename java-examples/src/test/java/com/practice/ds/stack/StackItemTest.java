package com.practice.ds.stack;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(value = JUnit4.class)
public class StackItemTest {


    @Test
    public void stackItem(){
        StackItem<String> item = new StackItem<String>();
        item.setItem("Kishore");
        String receivedItem = item.getItem();
        assertEquals("Kishore", receivedItem);
    }

}
