package ru.rein.taskManagementSystem.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.rein.taskManagementSystem.Models.Enums.TaskPriority;
import ru.rein.taskManagementSystem.Models.Enums.TaskStatus;

import java.util.ArrayList;

@Entity
@Table(name = "task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "header", nullable = false)
    private String header;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.PENDING;

    @Column(name = "priority", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskPriority priority = TaskPriority.MEDIUM;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Comment> comments;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "author_id", nullable = false, foreignKey = @ForeignKey(name = "fk_task_author"))
    private Person author;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "implementer_id", nullable = false, foreignKey = @ForeignKey(name = "fk_task_implementer"))
    private Person implementer;
}
