package com.proyectoCitas.proyectoCitas.service;

import com.proyectoCitas.proyectoCitas.entity.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks ();
    Task getTaskById (Long taskId);
    Task updateTask (Long taskId, Task updatedTask);
    void deleteTask (Long taskId);
    List<Task> getTasksByWeek(String firstDate, String lastDate);
}
