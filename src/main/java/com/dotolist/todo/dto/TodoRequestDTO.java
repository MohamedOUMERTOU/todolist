package com.dotolist.todo.dto;


import com.dotolist.todo.entity.Todo.Status;
import lombok.Data;


import java.time.LocalDate;
@Data
public class TodoRequestDTO {

    private String title;
    private String description;
    private Status status;
    private LocalDate dueDate;

}
