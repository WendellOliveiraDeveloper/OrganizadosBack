package dev.proje.Organizados.Controller;

import dev.proje.Organizados.DTO.TasksCreateDTO;
import dev.proje.Organizados.DTO.TasksDeleteTaskDTO;
import dev.proje.Organizados.DTO.TasksResponseDTO;
import dev.proje.Organizados.DTO.TasksUpdateDTO;
import dev.proje.Organizados.Services.TasksServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TasksController {
    @Autowired
    private TasksServices services;

    @GetMapping("all_tasks/{userId}")
    public List<TasksResponseDTO> showAllTasksByUserId(@PathVariable Long userId) {
        return services.findAllTasksByUser(userId);
    }

    @GetMapping("get_tasks_count_by_user/{userId}")
    public ResponseEntity<Long> getTasksCountByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(services.getAllTasksCount(userId));
    }

    @GetMapping("get_task_by_name/{nomeTarefa}/{userId}")
    public ResponseEntity<TasksResponseDTO> getTaskByName(
            @PathVariable String nomeTarefa,
            @PathVariable Long userId
    ) {
        TasksResponseDTO response = services.findTaskByName(nomeTarefa, userId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("add_task")
    public ResponseEntity<TasksResponseDTO> createTask(@Valid @RequestBody TasksCreateDTO request) {
        TasksResponseDTO response = services.createTask(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("update_user/{userId}")
    public ResponseEntity<TasksResponseDTO> updateTask(
            @PathVariable Long userId,
            @Valid @RequestBody TasksUpdateDTO dto
    ) {
        TasksResponseDTO response = services.updateTask(userId, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete_task/{taskId}/{userId}")
    public void updateTask(@PathVariable Long taskId,
                           @PathVariable Long userId) {
        services.removeTaskById(taskId, userId);
    }
}
