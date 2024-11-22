package net.javaguides.ems.service.impl;

import net.javaguides.ems.dto.TaskDto;
import net.javaguides.ems.entity.Task;
import net.javaguides.ems.exeption.ResourceNotFoundException;
import net.javaguides.ems.mapper.TaskMapper;
import net.javaguides.ems.repository.TaskRepository;
import net.javaguides.ems.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;


    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskDto createTask(TaskDto taskDto) {

        Task task = TaskMapper.mpToTask(taskDto);
        Task savedTask = taskRepository.save(task);
        return TaskMapper.mapToTaskDto(savedTask);
    }

    @Override
    public TaskDto getTaskById(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() ->
        new ResourceNotFoundException("Empl is no" + taskId));
        return TaskMapper.mapToTaskDto(task);
    }

    @Override
    public List<TaskDto> getAllTasks() {
       List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map((task) -> TaskMapper.mapToTaskDto(task)).collect(Collectors.toList());
    }

    @Override
    public TaskDto updateTask(Long taskId, TaskDto updateTask) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new ResourceNotFoundException("" + taskId)
        );
        task.setName(updateTask.getName());
        task.setDescription(updateTask.getDescription());
        task.setEmail(updateTask.getEmail());
        Task updateTaskObj = taskRepository.save(task);

        return TaskMapper.mapToTaskDto(updateTaskObj);
    }

    @Override
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new ResourceNotFoundException("" + taskId)
        );

        taskRepository.deleteById(taskId);
    }
}
