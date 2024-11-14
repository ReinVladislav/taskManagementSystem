package ru.rein.taskManagementSystem.Models.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskPriority {
    HIGH("Высокий"),
    MEDIUM("Средний"),
    LOW("Низкий");

    private final String displayName;

}
