package taskflow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import taskflow.model.AppInfo;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello Divya, Spring Boot is working!";
    }

    @GetMapping("/about")
    public String about() {
        return "This is my first Spring Boot project";
    }

    @GetMapping("/info")
    public AppInfo getInfo() {
        return new AppInfo(
                "TaskFlow",
                "1.0",
                "Divya"
        );
    }
}
