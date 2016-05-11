package com.practice.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;

public class Application {
	public static void main(String... args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		SampleBean username = (SampleBean)ctx.getBean("username");
		System.out.println(username.getName());
		SimpleJobLauncher launcher = (SimpleJobLauncher) ctx.getBean("jobLauncher");
	}
}