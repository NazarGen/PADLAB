package net.javaguides.ems.service;

import net.javaguides.ems.dto.TaskDto;

import java.util.List;

public interface TaskService {
    TaskDto createTask(TaskDto taskDto);

    TaskDto getTaskById(Long taskId);


    List<TaskDto> getAllTasks();

    TaskDto updateTask(Long taskId, TaskDto updateTask);

    void deleteTask(Long taskId);
}
