package com.practice.memento;

public class MementoPatternEx {

	public static void main(String... args) {
		System.out.println("***Memento Pattern Demo***\n");
		Originator o = new Originator();
		o.setState("First State");

		CareTaker c = new CareTaker();
		c.SaveMemento(o.OriginatorMemento(),"origin", 1);

		o.setState("Second State");
		c.SaveMemento(o.OriginatorMemento(),"origin", 2);

		o.setState("Third State");
		o.Revert(c.RetrieveMemento("origin", 1));

	}
}