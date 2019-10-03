package com.pepsico.task1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class Task1Application {

	@Bean
	public CommandLineRunner commandLineRunner() {
		return new TimestampCommandLineRunner();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Task1Application.class, args);
	}
	public static class TimestampCommandLineRunner implements CommandLineRunner {

		@Override
		public void run(String... strings) throws Exception {
			DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:ss");
			System.out.println(dateFormat.format(new Date()));
			//throw new IllegalStateException("No Task For You!");
		}
		@BeforeTask
		public void beforeTask(TaskExecution taskExecution) {
		  System. out.println("Before TASK");
		}

		@AfterTask
		public void afterTask(TaskExecution taskExecution) {
		  System. out.println("After TASK");
		}
	}
}
