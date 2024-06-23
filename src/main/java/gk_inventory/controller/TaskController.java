package gk_inventory.controller;

import gk_inventory.model.Task;
import gk_inventory.repository.TaskRepository;
import gk_inventory.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping("/add")
    public Task addTask(@RequestBody Task task){
        task.setTaskId("gk123");
        return taskService.addTask(task);
    }

    @GetMapping("/all")
    public List<Task> getAll(){
        return taskService.getAll();
    }
}
