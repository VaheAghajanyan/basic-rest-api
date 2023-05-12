package com.example.restfulwebservices.controller;

import com.example.restfulwebservices.model.HelloWorldBean;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private final MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/hello-world")
    public String helloworld() {
        return "Hello World!";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping("/hello-world/{name}")
    public String HelloWorldPathVariable(@PathVariable String name) {
        return String.format("Hello World, %s", name);
    }

    @GetMapping("/hello-world-internalization")
    public String helloWorldInternalization() {
        Locale locale = LocaleContextHolder.getLocale();
        return this.messageSource.getMessage("good.morning.message", null, "Default message", locale);
    }
}
