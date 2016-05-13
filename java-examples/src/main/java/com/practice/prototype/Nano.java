package com.practice.prototype;

public class Nano extends BasicCar {

	public Nano (String modelName) {
		super.setModelName(modelName);
	}

	@Override
	public Nano clone() throws CloneNotSupportedException {
		return (Nano) super.clone();
	}
}