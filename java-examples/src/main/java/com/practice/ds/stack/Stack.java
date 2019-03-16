package com.practice.ds.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stack<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(Stack.class);
    private StackItem<T> top;

    public Stack () {

    }

    public void push(T item) {
        StackItem<T> sItem = new StackItem<>(item);
        if(top == null) {
            top = sItem;
        } else {
            sItem.setPreviousItem(top);
            top = sItem;
        }
        LOGGER.info("The Size of the stack after insertion is {}", this.size());
    }

    public T pop() {
        if(top == null) {
            return null;
        }

        StackItem<T> poppedItem = top;
        top = top.getPreviousItem() != null?top.getPreviousItem(): null;

        return poppedItem.getItem();
    }

    public boolean isEmpty() {
        return ((top == null)|| (top.getItem() == null))?true:false;
    }

    public int size () {
        int size = 0;
        StackItem<T> tempItem = top;
        while(tempItem != null) {
            if(tempItem.getItem() != null) {
                size++;
            }
            tempItem = tempItem.getPreviousItem();
        }

        return size;

    }

}
