package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/task")
public class TaskController {

    private final DbService service;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskController(DbService service, TaskMapper taskMapper) {
        this.service = service;
        this.taskMapper = taskMapper;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks() {
        List<Task> tasks = service.getAllTasks();
        return taskMapper.mapToTaskDtoList(tasks);
    }

    @GetMapping(value = "getTask")
    public TaskDto getTask (@RequestParam Long taskId) throws TaskNotFoundException {
        return taskMapper.mapToTaskDto(
                service.getTaskById(taskId).orElseThrow(TaskNotFoundException::new)
        );
    }

    @DeleteMapping(value = "deleteTask")
    public void deleteTask (@RequestParam Long taskId) {
         service.deleteTaskById(taskId);

    }

    @PutMapping(value = "updateTask")
    public TaskDto updateTask (@RequestBody TaskDto taskDto) {
        Task task = taskMapper.mapToTask(taskDto);
        Task saveTask = service.saveTask(task);
        return taskMapper.mapToTaskDto(saveTask);
    }

    @RequestMapping(method = RequestMethod.POST,
            value = "createTask", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTask (@RequestBody TaskDto taskDto) {
        Task task = taskMapper.mapToTask(taskDto);
        service.saveTask(task);
    }

}

