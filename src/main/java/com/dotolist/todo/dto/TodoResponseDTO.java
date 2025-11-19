package com.dotolist.todo.dto;



import com.dotolist.todo.entity.Todo.Status;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
 @Data
public class TodoResponseDTO {

    private Long id;
    private String title;
    private String description;
    private Status status;
    private LocalDate dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters & Setters
}
