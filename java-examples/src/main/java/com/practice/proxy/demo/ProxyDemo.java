package com.practice.proxy.demo;

import com.practice.original.ConcreteSubject;
import com.practice.original.Subject;
import com.practice.proxy.Proxy;

public class ProxyDemo {

	public static void main(String... args) {
		System.out.println("***** Proxy Pattern Demo ****\n");
		Proxy proxy = new Proxy ();
		proxy.display ();
	}
}
