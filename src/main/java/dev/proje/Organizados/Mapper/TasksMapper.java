package dev.proje.Organizados.Mapper;

import dev.proje.Organizados.DTO.TasksCreateDTO;
import dev.proje.Organizados.DTO.TasksResponseDTO;
import dev.proje.Organizados.DTO.TasksUpdateDTO;
import dev.proje.Organizados.Model.TasksModel;
import org.springframework.stereotype.Component;

@Component
public class TasksMapper {

    public TasksModel toEntity(TasksCreateDTO dto) {
        if (dto == null) return null;

        TasksModel tasks = new TasksModel();

        tasks.setNomeTarefa(dto.getNomeTarefa());
        tasks.setDescricaoTarefa(dto.getDescricaoTarefa());
        tasks.setDataTarefa(dto.getDataTarefa());
        tasks.setTiposTarefa(dto.getTiposTasks());

        return tasks;
    }

    public TasksResponseDTO toDTO(TasksModel tasks) {
        if (tasks == null) return null;

        return new TasksResponseDTO(
                tasks.getId(),
                tasks.getNomeTarefa(),
                tasks.getDescricaoTarefa(),
                tasks.getDataTarefa(),
                tasks.getTiposTarefa(),
                tasks.getUser().getId(),
                tasks.getUser().getNome()
        );
    }

    public void updateEntityFromDTO(TasksModel tasks, TasksUpdateDTO dto) {
        if (tasks == null || dto == null) return;

        if (dto.getTaskId() != null) {
            tasks.setId(dto.getTaskId());
        }

        if (dto.getNomeTarefa() != null && !dto.getNomeTarefa().trim().isEmpty()) {
            tasks.setNomeTarefa(dto.getNomeTarefa());
        }

        if (dto.getDescricaoTarefa() != null && !dto.getDescricaoTarefa().trim().isEmpty()) {
            tasks.setDescricaoTarefa(dto.getDescricaoTarefa());
        }

        if (dto.getDataTarefa() != null) {
            tasks.setDataTarefa(dto.getDataTarefa());
        }

        if (dto.getTiposTasks() != null) {
            tasks.setTiposTarefa(dto.getTiposTasks());
        }
    }
}
