package com.example.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public Person1 getPerson() {
        return new Person1("Vahe");
    }

    @GetMapping("/v2/person")
    public Person2 getPerson2() {
        return new Person2("Vahe", "Aghajanyan");
    }
}
