package com.practice.memento;

public class MementoPatternEx {

	public static void main(String... args) {
		System.out.println("***Memento Pattern Demo***\n");
		Originator o = new Originator();
		o.setState("First State");

		CareTaker c = new CareTaker();
		c.SaveMemento(o.OriginatorMemento());

		o.setState("Second State");

		o.Revert(c.RetrieveMemento());

	}
}