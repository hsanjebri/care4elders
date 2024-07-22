package tn.care4elders.clinivia.service;

import tn.care4elders.clinivia.entity.Task;

import java.util.List;

public interface TaskService {

    Task saveTask(Task task);
    Task getTaskById(Long id);
    void deleteTask(Long id);
    List<Task> getAllTasks();
    Task updateTask(Task task);
    public List<Task> findTasksByPatientId(Long patientId) ;



}
