package exercise.controller;

import java.util.List;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.mapper.TaskMapper;
import exercise.repository.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.TaskRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    // BEGIN
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<TaskDTO> index() {
        var result = taskRepository.findAll();
        return result.stream().map(t -> taskMapper.map(t)).toList();
    }
    @GetMapping("/{id}")
    public TaskDTO show(@PathVariable long id) {
        var maybeTask = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        return taskMapper.map(maybeTask);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO create(@RequestBody TaskCreateDTO newTask) {
        var task = taskMapper.map(newTask);
        taskRepository.save(task);
        return taskMapper.map(task);
    }
    @PutMapping("/{id}")
    public TaskDTO update(@PathVariable long id,@Valid @RequestBody TaskUpdateDTO taskUpdateDTO) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        var user = userRepository.findById(taskUpdateDTO.getAssigneeId())
                        .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));

        taskMapper.update(taskUpdateDTO, task);
        task.setAssignee(user);
        taskRepository.save(task);
        return taskMapper.map(task);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        taskRepository.delete(task);
    }
    // END
}
