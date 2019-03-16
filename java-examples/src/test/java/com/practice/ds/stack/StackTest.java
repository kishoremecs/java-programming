package com.practice.ds.stack;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.MockitoAnnotations;

@RunWith(value = JUnit4.class)
public class StackTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void intStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(100);
        assertTrue(stack.size() == 2);
        assertTrue(stack.pop() instanceof  Integer);
        Integer value = stack.pop();
        assertEquals(new Integer(10), value);
        assertTrue(stack.size() == 0);
    }
    @Test
    public void stringStack() {
        Stack<String> stack = new Stack<>();
        stack.push("Kishore");
        stack.push("Sowjanya");
        assertTrue(stack.size() == 2);
        String value = stack.pop();
        assertEquals("Sowjanya", value);
        assertTrue(stack.size() == 1);
        stack.pop();
        assertTrue(stack.isEmpty());
        value = stack.pop();
        assertNull(value);
    }

}