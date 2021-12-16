package com.example.vaccination.controller;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
@SpringBootApplication
@RequestMapping(path="/user")
public class UserController {
    @GetMapping(value = "/api/hello")
    public String hello() {
        return "Hello, the time at the server is now " + new Date() + "\n";
    }
}