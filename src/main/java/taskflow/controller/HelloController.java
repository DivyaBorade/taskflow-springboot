package taskflow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import taskflow.model.AppInfo;
import taskflow.model.Task;
import taskflow.repository.TaskRepository;

import java.util.List;

@RestController
public class HelloController {

    private final TaskRepository taskRepository;

    public HelloController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

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

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

}
