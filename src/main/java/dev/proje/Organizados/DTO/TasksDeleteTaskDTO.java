package dev.proje.Organizados.DTO;

public class TasksDeleteTaskDTO {
    private Long id;
    private Long userId;

    public TasksDeleteTaskDTO() {
    }

    public TasksDeleteTaskDTO(Long id, Long userId) {
        this.setId(id);
        this.setUserId(userId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
