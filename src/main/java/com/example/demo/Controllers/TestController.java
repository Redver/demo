package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    //http://localhost:8080/swagger-ui/index.html
    @GetMapping("/testFinal")
    public String test() {
        return "This is just a test";
    }
}