package com.practice.prototype;

public class Ford extends BasicCar {

	public Ford(String modelName) {
		super.setModelName(modelName);
	}

	@Override
	public Ford clone() throws CloneNotSupportedException {
		return (Ford)super.clone();
	}
}