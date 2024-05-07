package tn.care4elders.clinivia.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.care4elders.clinivia.entity.Task;
import tn.care4elders.clinivia.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
@CrossOrigin("*")

public class TaskController {

     TaskService taskService;

    @PostMapping("/add")
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @GetMapping("/getbyid/{id}")
    public Task getTaskById(@PathVariable("id") Long id) {
        return taskService.getTaskById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/getall")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PutMapping("/update")
    public Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }


    @GetMapping("/by-patient/{patientId}")
    public List<Task> findTasksByPatientId(@PathVariable("patientId") Long patientId) {
        return taskService.findTasksByPatientId(patientId);
    }




}
//////////////////test