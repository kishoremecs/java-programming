package com.practice.spring;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;

public class Application {
	public static void main(String... args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		SampleBean username = (SampleBean)ctx.getBean("username");
		System.out.println(username.getName());
		SimpleJobLauncher launcher = (SimpleJobLauncher) ctx.getBean("jobLauncher");
		Job job = (Job)ctx.getBean("practiceJob");
		JobParametersBuilder parameters = new JobParametersBuilder ();
		parameters.addDate("timestamp", new Date());

		try {
			launcher.run(job, parameters.toJobParameters());
		} catch(Exception e) {
			
		}
	}
}