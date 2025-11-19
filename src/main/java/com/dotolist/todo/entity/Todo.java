package com.dotolist.todo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate dueDate;
    private Status status;

    public enum Status {
        TODO,
        IN_PROGRESS,
        DONE
    }
}
