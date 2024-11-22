package net.javaguides.ems.mapper;

import net.javaguides.ems.dto.TaskDto;
import net.javaguides.ems.entity.Task;

public class TaskMapper {

    public static TaskDto mapToTaskDto(Task task){
        return new TaskDto(
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.getEmail()
        );
    }


    public static Task mpToTask(TaskDto taskDto){
        return new Task(
                taskDto.getId(),
                taskDto.getName(),
                taskDto.getDescription(),
                taskDto.getEmail()
        );
    }
}
