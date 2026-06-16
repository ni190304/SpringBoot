package com.example.learn_spring_framework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {
};

record Address(String firstLine, String city) {
};

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Nihaal";
    }

    @Bean
    public int age() {
        return 20;
    }

    @Bean
    public Person personMethodCall() {
        return new Person(name(), age(), new Address("345 Major St", "Springfield"));
    }

    @Bean
    public Person person2() {
        return new Person("Alice", 23, address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3) {
        return new Person(name, age, address3);
    }

    // No qualifying bean of type 'com.example.learn_spring_framework.Address'
    // available: expected single matching bean but found 2: address2,address3
    @Bean
    @Primary
    public Person person4Parameters(String name, int age, Address address) {
        return new Person(name, age, address);
    }

    @Bean
    public Person person5Qualifier(String name, int age, @Qualifier("address2Qualifier") Address address) {
        return new Person(name, age, address);
    }

    @Bean(name = "address2")
    @Qualifier("address2Qualifier")
    public Address address() {
        return new Address("123 Main St", "Springfield");
    }

    @Bean(name = "address3")
    @Primary
    public Address address3() {
        return new Address("Dadar", "Mumbai");
    }
}
