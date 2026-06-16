package com.example.learn_spring_framework.example.e1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass {
	
}

@Scope(value = "prototype")
@Component
class PrototypeClass {
	
}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class);

		System.out.println(context.getBean(NormalClass.class));
		System.out.println(context.getBean(NormalClass.class)); // same instance


		System.out.println(context.getBean(PrototypeClass.class));
		System.out.println(context.getBean(PrototypeClass.class));
		System.out.println(context.getBean(PrototypeClass.class)); // different instances
	}

}
