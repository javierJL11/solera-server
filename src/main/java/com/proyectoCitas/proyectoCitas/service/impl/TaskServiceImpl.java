package com.proyectoCitas.proyectoCitas.service.impl;

import com.proyectoCitas.proyectoCitas.entity.Task;
import com.proyectoCitas.proyectoCitas.entity.Task;
import com.proyectoCitas.proyectoCitas.exception.ResourceNotFoundException;
import com.proyectoCitas.proyectoCitas.repository.RoomRepository;
import com.proyectoCitas.proyectoCitas.repository.TaskRepository;
import com.proyectoCitas.proyectoCitas.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Override
    public Task createTask(Task task) {
        Task saveTask;
        try {
            saveTask = taskRepository.save(task);
        }catch(Exception ResourceNotFoundException){
            throw new ResourceNotFoundException("error al agregar tarea");
        }
        return saveTask;
    }

    @Override
    public List<Task> getAllTasks() {
        List<Task> listTasks;
        try {
            listTasks = taskRepository.findAll();
        } catch (Exception ResourceNotFoundException) {
            throw new ResourceNotFoundException("Error al obtener lista de tareas");
        }
        return listTasks;    }

    @Override
    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId) .orElseThrow(() ->
                new ResourceNotFoundException(("La tarea no exixte para el id : " + taskId)));    }

    @Override
    public Task updateTask(Long taskId, Task updatedTask) {
        Task getTask = getTaskById(taskId);
        if(getTask !=null){
            getTask.setId(updatedTask.getId());
            getTask.setType(updatedTask.getType());
            getTask.setModifiedDate(updatedTask.getModifiedDate());
            getTask.setPatient(updatedTask.getPatient());
            getTask.setEmployee(updatedTask.getEmployee());
            getTask.setPriority(updatedTask.getPriority());
            getTask.setStatus(updatedTask.getStatus());
            getTask.setNote(updatedTask.getNote());
            getTask.setNoteTitle(updatedTask.getNoteTitle());

        }
        Task saveTask;
        try {
            saveTask = taskRepository.save(getTask);
        } catch (Exception ResourceNotFoundException) {
            throw new ResourceNotFoundException("Error al modificar la tarea");
        }
        return saveTask;
    }

    @Override
    public void deleteTask(Long taskId) {
        try {
            taskRepository.deleteById(taskId);
        } catch (Exception ResourceNotFoundException) {
            throw new ResourceNotFoundException("Error al eliminar la tarea");
        }
    }

    @Override
    public List<Task> getTasksByWeek(String firstDate, String lastDate) {
        List<Task> listTasks;
        try {
            listTasks = taskRepository.getTasksByWeek(firstDate, lastDate);
        } catch (Exception ResourceNotFoundException) {
            throw new ResourceNotFoundException("Error al obtener lista de tareas");
        }
        return listTasks;
    }
}
