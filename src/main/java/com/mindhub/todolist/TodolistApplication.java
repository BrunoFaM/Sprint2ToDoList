package com.mindhub.todolist;

import com.mindhub.todolist.models.Task;
import com.mindhub.todolist.models.TaskStatus;
import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.repositories.TaskRepository;
import com.mindhub.todolist.repositories.UserEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(UserEntityRepository userEntityRepository, TaskRepository taskRepository){
		return args -> {

			UserEntity user1 = new UserEntity("el 10", "dwadawd", "ewdawd");
			UserEntity user2 = new UserEntity("Niki", "435190", "bruno56@gmail.com");
			Task t1 = new Task("Clean", "clean the setup", TaskStatus.COMPLETED);
			Task t2 = new Task("Cook", "I need to eat to program better", TaskStatus.PENDING);
			Task t3 = new Task("Programing", "To be better", TaskStatus.IN_PROGRESS);

			userEntityRepository.save(user1);
			userEntityRepository.save(user2);
			user1.addTask(t1);
			user2.addTask(t2);
			user2.addTask(t3);


			System.out.println(user1);
			System.out.println(user2);

			taskRepository.save(t1);
			taskRepository.save(t2);
			taskRepository.save(t3);
			System.out.println(user1);
			System.out.println(user2);
			System.out.println(t1);
			System.out.println(t2);
			System.out.println(t3);

		};
	}

}
