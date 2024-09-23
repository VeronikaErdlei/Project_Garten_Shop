package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ExampleController {

    @GetMapping("/example")
    public String exampleMethod() {
        log.info("Вызван метод exampleMethod");
        return "OK!";
    }
}