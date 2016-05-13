package com.practice.prototype;

public class PrototypeEx {
	public static void main(String... args) throws CloneNotSupportedException {
		System.out.println("    **** Prototype Pattern Example ****");
		BasicCar nano_base = new Nano("Green Nano");
		nano_base.setPrice(150000);

		BasicCar ford_basic = new Ford("Yellow Ford");
		ford_basic.setPrice(400000);

		BasicCar nanoCopy;
		nanoCopy = nano_base.clone();
		nanoCopy.setPrice(nano_base.getPrice()+BasicCar.fetchBasePrice());
		System.out.println("The price of the nanoCopy is " + nanoCopy.getPrice());

		BasicCar fordCopy;
		fordCopy = ford_basic.clone();
		fordCopy.setPrice(ford_basic.getPrice()+BasicCar.fetchBasePrice());
		System.out.println("The price of the fordCopy is " + fordCopy.getPrice());
	}
}