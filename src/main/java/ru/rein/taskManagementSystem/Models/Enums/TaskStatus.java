package ru.rein.taskManagementSystem.Models.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskStatus {
    PENDING("В ожидании"),
    IN_PROGRESS("В процессе"),
    COMPLETED("Завершено");

    private final String displayName;

}
