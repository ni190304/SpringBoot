package com.example.spring_security.resources;

import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.RolesAllowed;

import java.util.List;
import org.slf4j.*;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TodoResource {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final List<Todo> TODO_LIST = List.of(new Todo("nayak19", "Learn System Des"), new Todo("nayak19", "Get AWS Certified"));;

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos() {
        return TODO_LIST;
    }

    @GetMapping("/users/{username}/todos")
    @PreAuthorize("hasRole('USER') and #username == authentication.name")
    @PostAuthorize("returnObject.username == 'nayak19'")
    @RolesAllowed({"ADMIN", "USER"})
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    public Todo retrieveTodosForUser(@PathVariable String username) {
        return TODO_LIST.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodosForUser(@PathVariable String username, @RequestBody Todo todo) {
        logger.info("Create {} for {}" , todo, username);
    }
}

record Todo(String username, String desc) {
}
