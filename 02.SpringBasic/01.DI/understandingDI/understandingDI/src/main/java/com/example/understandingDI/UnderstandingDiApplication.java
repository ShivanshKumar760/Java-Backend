package com.example.understandingDI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UnderstandingDiApplication {

	public static void main(String[] args) {
//		SpringApplication.run(UnderstandingDiApplication.class, args);
//		System.out.println("Spring boot is up and running!");
//		//if we are creating the object by ourself
//		Student stu1=new Student();
//		stu1.code();

		//but we are saying spring manages object via ioc container so where is that container
		/*
		SpringApplication.run(UnderstandingDiApplication.class, args); here lets see what this .run function return
		ctrl + click-it returns a ConfigurableApplicationContext which is extended to ApplicationContext
		this ApplicationContext is IOC container
		 */
		ApplicationContext context=SpringApplication.run(UnderstandingDiApplication.class,args);
		Student stu2=context.getBean(Student.class);//Now this not DI this demo is to show that spring
		//has a ioc container name ApplicationContext which manages the bean
		stu2.code();

	}

}
