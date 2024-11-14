package ru.rein.taskManagementSystem.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@Entity
@Table(name ="comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(name = "fk_comment_person"))
    private Person person;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false, foreignKey = @ForeignKey(name = "fk_comment_task"))
    private Task task;
}
