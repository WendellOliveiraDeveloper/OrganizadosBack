package dev.proje.Organizados.Repository;

import dev.proje.Organizados.Model.TasksModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TasksRepository extends JpaRepository<TasksModel, Long> {

    Optional<TasksModel> findByDataTarefa(Date dataTarefa);

    Optional<TasksModel> findByNomeTarefa(String nomeTarefa);

    List<TasksModel> findAllTaskByUserId(Long userId);

    Long countByUserId(Long userId);
}
