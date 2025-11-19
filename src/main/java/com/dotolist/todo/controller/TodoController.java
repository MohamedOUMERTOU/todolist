package com.dotolist.todo.controller;


import com.dotolist.todo.dto.TodoRequestDTO;
import com.dotolist.todo.dto.TodoResponseDTO;
import com.dotolist.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<TodoResponseDTO> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public TodoResponseDTO getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }

    @PostMapping
    public ResponseEntity<TodoResponseDTO> createTodo(@Valid @RequestBody TodoRequestDTO dto) {
        return ResponseEntity.ok(todoService.createTodo(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDTO> updateTodo(@PathVariable Long id, @Valid @RequestBody TodoRequestDTO dto) {
        return ResponseEntity.ok(todoService.updateTodo(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}
