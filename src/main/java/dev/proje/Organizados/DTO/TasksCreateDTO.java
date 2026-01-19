package dev.proje.Organizados.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import dev.proje.Organizados.Enums.TiposTasks;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.util.Date;

public class TasksCreateDTO {
    @NotBlank
    private String nomeTarefa;

    @NotBlank
    private String descricaoTarefa;

    @NotBlank(message = "data da tarefa deve ser obrigatória")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataTarefa;

    private TiposTasks tiposTasks;

    private Long userID;

    public TasksCreateDTO() {
    }

    public TasksCreateDTO(String nomeTarefa, String descricaoTarefa, Date dataTarefa, TiposTasks tiposTasks, Long userID) {
        this.setNomeTarefa(nomeTarefa);
        this.setDescricaoTarefa(descricaoTarefa);
        this.setDataTarefa(dataTarefa);
        this.setTiposTasks(tiposTasks);
        this.setUserID(userID);
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

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}
