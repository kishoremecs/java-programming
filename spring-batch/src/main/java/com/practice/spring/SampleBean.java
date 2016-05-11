package com.practice.spring;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SampleBean {

	@PersistenceContext
	private EntityManager entityManager;


	private String name;

	public SampleBean(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
