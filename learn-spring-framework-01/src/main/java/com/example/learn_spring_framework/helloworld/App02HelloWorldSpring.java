package com.example.learn_spring_framework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1: Launch a Spring Context -

		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

		// 2:Configure the things that we want Spring to manage -
		// HelloWorldConfiguration - @Configuration
		// name - @Bean

		System.out.println(context.getBean("name"));

		System.out.println(context.getBean("age"));

		System.out.println(context.getBean("personMethodCall"));

		System.out.println(context.getBean("person2"));

		System.out.println(context.getBean("person3Parameters"));

		System.out.println(context.getBean("address2"));

		System.out.println(context.getBean(Person.class));

		System.out.println(context.getBean(Address.class));

		System.out.println(context.getBean("person5Qualifier"));

		// Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

	}

}
