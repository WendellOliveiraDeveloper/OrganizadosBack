package dev.proje.Organizados.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.proje.Organizados.Enums.TiposTasks;

import java.util.Date;

public class TasksUpdateDTO {
    private Long taskId;

    private String nomeTarefa;

    private String descricaoTarefa;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataTarefa;

    private TiposTasks tiposTasks;

    public TasksUpdateDTO() {
    }

    public TasksUpdateDTO(
            Long taskId,
            String nomeTarefa,
            String descricaoTarefa,
            Date dataTarefa,
            TiposTasks tiposTasks
    ) {
        this.setTaskId(taskId);
        this.setNomeTarefa(nomeTarefa);
        this.setDescricaoTarefa(descricaoTarefa);
        this.setDataTarefa(dataTarefa);
        this.setTiposTasks(tiposTasks);
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
}
