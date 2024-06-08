package com.proyectoCitas.proyectoCitas.controller;

import com.proyectoCitas.proyectoCitas.entity.Task;
import com.proyectoCitas.proyectoCitas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;
    
    @RequestMapping(path="/api/task", method = RequestMethod.POST)
    public ResponseEntity<Task> createTask (@RequestBody Task task){
        Task saveTask =  taskService.createTask(task);
        return new ResponseEntity<>(saveTask, HttpStatus.CREATED);
    }

    @RequestMapping (path="/api/task/{id}", method = RequestMethod.GET)
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long taskId){
        Task task =  taskService.getTaskById(taskId);
        return ResponseEntity.ok(task);
    }

    @RequestMapping (path="/api/task", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks =  taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @RequestMapping (path="/api/task/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Task> updateTask( @PathVariable("id") Long taskId,@RequestBody Task updatedTask){
        Task task= taskService.updateTask(taskId,updatedTask);
        return ResponseEntity.ok(task);
    }

    @RequestMapping (path="/api/task/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTask (@PathVariable("id") Long taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Consultorio eliminado exitosamente!");

    }

    @RequestMapping (path="/api/task/weeks/{firstdate}/{lastdate}", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getAllTasks(@PathVariable("firstdate") String firstdate,@PathVariable("lastdate") String lastdate){
        List<Task> tasks =  taskService.getTasksByWeek(firstdate, lastdate);
        return ResponseEntity.ok(tasks);
    }
    
}
