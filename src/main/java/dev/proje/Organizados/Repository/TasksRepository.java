package dev.proje.Organizados.Repository;

import dev.proje.Organizados.Model.TasksModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("""
                SELECT t
                FROM TasksModel t
                WHERE t.tiposTasks = 3
                  AND t.user.id = :userId
            """)
    List<TasksModel> buscarTarefasAtrasadasPorUsuario(@Param("userId") Long userId);

    @Query("""
                SELECT COUNT(t)
                FROM TasksModel t
                WHERE t.tiposTasks = 3
                  AND t.user.id = :userId
            """)
    Long contarTarefasAtrasadasPorUsuario(@Param("userId") Long userId);
}
