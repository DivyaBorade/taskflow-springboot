package taskflow.controller;

import org.springframework.web.bind.annotation.*;
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

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Integer id) {

        taskRepository.deleteById(id);

        return "Task deleted successfully";
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Integer id,
                           @RequestBody Task updatedTask) {
        updatedTask = new Task(
                id,
                updatedTask.getTitle(),
                updatedTask.isCompleted()
        );

        return taskRepository.save(updatedTask);
    }
}
