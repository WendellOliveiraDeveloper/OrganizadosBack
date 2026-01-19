package dev.proje.Organizados.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.proje.Organizados.Enums.TiposTasks;

import java.util.Date;

public class TasksResponseDTO {
    private Long taskId;

    private String nomeTarefa;

    private String descricaoTarefa;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataTarefa;

    private TiposTasks tiposTasks;

    private Long userId;
    private String nomeUser;

    public TasksResponseDTO() {
    }

    public TasksResponseDTO(
            Long taskId,
            String nomeTarefa,
            String descricaoTarefa,
            Date dataTarefa,
            TiposTasks tiposTasks,
            Long userId,
            String nomeUser
    ) {
        this.setTaskId(taskId);
        this.setNomeTarefa(nomeTarefa);
        this.setDescricaoTarefa(descricaoTarefa);
        this.setDataTarefa(dataTarefa);
        this.setTiposTasks(tiposTasks);
        this.setUserId(userId);
        this.setNomeUser(nomeUser);
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }

    public void setDescricaoTarefa(String descricaoTarefa) {
        this.descricaoTarefa = descricaoTarefa;
    }

    public Date getDataTarefa() {
        return dataTarefa;
    }

    public void setDataTarefa(Date dataTarefa) {
        this.dataTarefa = dataTarefa;
    }

    public TiposTasks getTiposTasks() {
        return tiposTasks;
    }

    public void setTiposTasks(TiposTasks tiposTasks) {
        this.tiposTasks = tiposTasks;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }
}
