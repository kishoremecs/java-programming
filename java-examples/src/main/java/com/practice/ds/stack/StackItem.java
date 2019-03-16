package com.practice.ds.stack;

/**
 * Stack Item which holds the value in the stack.
 */
public class StackItem<T> {

    private T item;
    private StackItem previousItem;

    public StackItem() {

    }

    public StackItem(T item) {
        this.item = item;
    }

    /** Getters and Setters */
    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public StackItem getPreviousItem() {
        return previousItem;
    }

    public void setPreviousItem(StackItem previousItem) {
        this.previousItem = previousItem;
    }

    /** Getters and Setters End */

}
