package com.kmerpro237;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController // This is a Spring stereotype annotation
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greetings")
    public GreetResponse greet() {
        return new GreetResponse("Hello " + new Person("Sosthene", 45).name, List.of("Ndole", "Koki"), new Person("Sosthene", 24));
    }

    record Person(String name, int age) {}
    record GreetResponse(String greetingMessage, List<String>favMeals, Person person) {}
}
