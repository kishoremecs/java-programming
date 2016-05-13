package com.practice.prototype;

import java.util.Random;

public abstract class BasicCar implements Cloneable {

	private String modelName;
	private int price;

	public BasicCar () {

	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelName() {
		return this.modelName;
	}

	public void setPrice ( int price) {
		if(price <= 0 ){
			Random r = new Random ();
			int p = r.nextInt(100000);
			this.price = p;

		} else {
		this.price = price;			
		}

	}

	public static int fetchBasePrice () {
		Random r = new Random ();
		int p = r.nextInt(100000);
		return p;
	} 

	public int getPrice() {
		return this.price;
	}

	public BasicCar clone() throws CloneNotSupportedException {
		return (BasicCar) super.clone();
	}

}