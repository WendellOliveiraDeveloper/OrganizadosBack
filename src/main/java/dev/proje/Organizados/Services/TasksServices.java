package dev.proje.Organizados.Services;

import dev.proje.Organizados.DTO.TasksCreateDTO;
import dev.proje.Organizados.DTO.TasksResponseDTO;
import dev.proje.Organizados.DTO.TasksUpdateDTO;
import dev.proje.Organizados.Mapper.TasksMapper;
import dev.proje.Organizados.Model.TasksModel;
import dev.proje.Organizados.Model.UserModel;
import dev.proje.Organizados.Repository.TasksRepository;
import dev.proje.Organizados.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TasksServices {
    @Autowired
    private TasksRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TasksMapper mapper;

    public List<TasksResponseDTO> findAllTask() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<TasksResponseDTO> findAllTasksByUser(Long userId) {
        return repository.findAllTaskByUserId(userId)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<TasksResponseDTO> listarTarefasAtrasadasPorUsuario(Long userId) {
        return repository.buscarTarefasAtrasadasPorUsuario(userId)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public Long getAllTasksCount(Long userId) {
        return repository.countByUserId(userId);
    }

    public Long getAllLateTaskCount(Long userId) {
        return repository.contarTarefasAtrasadasPorUsuario(userId);
    }

    public TasksResponseDTO findTaskByName(String nomeTarefa, Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        TasksModel task = repository.findByNomeTarefa(nomeTarefa)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        return mapper.toDTO(task);
    }


    public TasksResponseDTO createTask(TasksCreateDTO dto) {
        UserModel user = userRepository.findById(dto.getUserID())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        TasksModel task = mapper.toEntity(dto);
        task.setUser(user);

        TasksModel saved = repository.save(task);
        return mapper.toDTO(saved);
    }

    public TasksResponseDTO updateTask(Long userId, TasksUpdateDTO dto) {

        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        TasksModel task = repository.findById(dto.getTaskId())
                .orElseThrow(() -> new RuntimeException("Task não encontrada"));

        if (!task.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Task não pertence ao usuário");
        }

        mapper.updateEntityFromDTO(task, dto);

        TasksModel taskUpdated = repository.save(task);

        return mapper.toDTO(taskUpdated);
    }


    public void removeTaskById(Long taskId, Long userId) {
        TasksModel task = repository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        if (!task.getUser().getId().equals(userId)) {
            throw new RuntimeException("Usuário não tem permissão para remover essa tarefa");
        }

        repository.delete(task);
    }

    public void removeAllTask() {
        repository.deleteAll();
    }
}
