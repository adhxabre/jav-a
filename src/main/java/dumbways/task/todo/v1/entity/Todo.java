package dumbways.task.todo.v1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_todo")
public class Todo {

    @Column(unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name ="is_done", updatable = true)
    private boolean isDone;

    public Todo() {
    }

    public Todo(Long id, String title, String content, boolean isDone) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isDone = isDone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

}
