package com.example.learn_spring_framework.example.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {
	
}

@Component
@Lazy
class ClassB {
	private ClassA classA;

	public ClassB(ClassA classA) {
		System.out.println("ClassB is initialized");
		this.classA = classA;
	}

	public void doSomething() {
		System.out.println("Doing something in ClassB");
	}
}



@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class);

		// Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

		System.out.println("Context is initialized");

		// context.getBean(ClassB.class).doSomething();
	}

}
