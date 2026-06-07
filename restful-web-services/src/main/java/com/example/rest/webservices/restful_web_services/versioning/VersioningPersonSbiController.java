package com.example.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonSbiController {

    // @GetMapping(value = "/{version}/personsbi", version = "1.0.0", produces = "application/json")
    // public PersonV1 getFirstVersionOfPerson() {
    //     return new PersonV1("Bob Charlie");
    // }

    // @GetMapping(value = "/{version}/personsbi", version = "2.0.0", produces = "application/json")
    // public PersonV2 getSecondVersionOfPerson() {
    //     return new PersonV2(new Name("Bob", "Charlie"));
    // }

    @GetMapping(path = "/personsbi", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonHeader() {
        return new PersonV1("Bob Charlie");
    }

    
    @GetMapping(path = "/personsbi", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonHeader() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
