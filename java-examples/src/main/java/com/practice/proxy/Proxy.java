package com.practice.proxy;

import com.practice.original.*;

public class Proxy extends Subject {

	ConcreteSubject cs;

	@Override
	public void display () {
		System.out.println("Calling the proxy method");
		if(cs ==  null) {
			cs = new ConcreteSubject ();
		}

		cs.display();
	}

}