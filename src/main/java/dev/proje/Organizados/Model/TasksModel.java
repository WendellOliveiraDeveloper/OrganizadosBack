package dev.proje.Organizados.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.proje.Organizados.Enums.TiposTasks;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "tarefas")
public class TasksModel {
    private static final String mensagemErro = "Deve ser informado!";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = mensagemErro)
    private String nomeTarefa;

    @NotNull(message = mensagemErro)
    private String descricaoTarefa;

    @NotNull(message = mensagemErro)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date data;

    private Date dataTarefa;

    @NotNull(message = mensagemErro)
    private TiposTasks tiposTasks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    public TasksModel() {
    }

    public TasksModel(Long id, String nomeTarefa, String descricaoTarefa, Date dataTarefa, TiposTasks tiposTasks) {
        this.setId(id);
        this.setNomeTarefa(nomeTarefa);
        this.setDescricaoTarefa(descricaoTarefa);
        this.setDataTarefa(dataTarefa);
        this.setTiposTarefa(tiposTasks);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public TiposTasks getTiposTarefa() {
        return tiposTasks;
    }

    public void setTiposTarefa(TiposTasks tiposTasks) {
        this.tiposTasks = tiposTasks;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
