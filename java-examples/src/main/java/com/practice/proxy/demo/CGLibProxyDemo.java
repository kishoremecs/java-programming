package com.practice.proxy.demo;

import com.practice.original.Subject;
import com.practice.original.ConcreteSubject;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

public class CGLibProxyDemo {
	
	public static void main(String... args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Subject.class);
		enhancer.setCallback(new FixedValue() {
			@Override
			public Object loadObject () throws Exception {
				System.out.println("printing in a cglib proxy");
				return null;
			}
		});
		Subject proxy = (Subject)enhancer.create();
		proxy.display();
	}
}