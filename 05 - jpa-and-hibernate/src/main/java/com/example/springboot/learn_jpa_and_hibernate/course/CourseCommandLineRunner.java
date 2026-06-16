package com.example.springboot.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.springboot.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    // @Autowired
    // private CourseJdbcRepository repository;

    //     @Autowired
    // private CourseJpaRepository repository;   

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS JPA!", "Nihaal Nayak"));
        repository.save(new Course(2, "Learn Azure JPA!", "Naresh Nayak"));
        repository.save(new Course(3, "Learn GCP JPA!", "Rohan Nayak"));

        repository.deleteById(2l);

        System.out.println(repository.findById(1l));
        System.out.println(repository.findById(3l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        System.out.println(repository.findByAuthor("Nihaal Nayak"));
        System.out.println(repository.findByAuthor(""));

        System.out.println(repository.findByName("Learn AWS JPA!"));
        System.out.println(repository.findByName("Learn Azure JPA!"));
        System.out.println(repository.findByName("Learn GCP JPA!"));
    }

}
