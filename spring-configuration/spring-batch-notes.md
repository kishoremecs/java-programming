# Spring Batch Component Description and Notes.
Defining a Job :

The below configuration shows the basic configuration of a job.
The Spring batch's job is a combination of steps.
each step can have either a tasklet or a reader/writer or reader/processor/writer components wrapped in a tasklet.

	<batch:job id="practiceJob">
		<batch:step id="firstStep">
			
		</batch:step>
	</batch:job>

The syntax for creating a tasklet is:


// Define the tasklet 
package com.practice.batch.tasklet;

public class MyTasklet implements Tasklet {

	public RepeatStatus execute(StepContribution paramStepContribution, ChunkContext paramChunkContext)
			throws Exception {
			System.out.println("Executing a tasklet");
		return RepeatStatus.FINISHED;
	}
}

#Spring configuration for the above tasklet.

<bean id="myTasklet" class="com.practice.batch.tasklet.MyTasklet" scope="singleton" />

 	<batch:job id="practiceJob">
		<batch:step id="firstStep">
			<batch:tasklet ref="myTasklet" />
		</batch:step>
	</batch:job>
