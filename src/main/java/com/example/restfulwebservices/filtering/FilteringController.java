package com.example.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/v1/some-beans")
    public List<SomeBean> getBeans() {
        return new ArrayList<>(Arrays.asList(
                new SomeBean("Field1", "Field2", "Field3"),
                new SomeBean("Field1", "Field2", "Field3"),
                new SomeBean("Field1", "Field2", "Field3")
        ));
    }
}
