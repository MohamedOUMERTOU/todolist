package com.dotolist.todo.service;


import com.dotolist.todo.dto.TodoRequestDTO;
import com.dotolist.todo.dto.TodoResponseDTO;
import com.dotolist.todo.entity.Todo;
import com.dotolist.todo.exception.TodoNotFoundException;
import com.dotolist.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public TodoResponseDTO createTodo(TodoRequestDTO dto) {

        Todo todo = Todo.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .dueDate(dto.getDueDate())
                .build();

        // Sauvegarde en base
        Todo saved = todoRepository.save(todo);

        return mapToDTO(saved);
    }

    @Override
    public List<TodoResponseDTO> getAllTodos() {
        return todoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TodoResponseDTO getTodoById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found with id: " + id));
        return mapToDTO(todo);
    }

    @Override
    public TodoResponseDTO updateTodo(Long id, TodoRequestDTO dto) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found with id: " + id));

        todo.setTitle(dto.getTitle());
        todo.setDescription(dto.getDescription());
        todo.setStatus(dto.getStatus());
        todo.setDueDate(dto.getDueDate());

        Todo updated = todoRepository.save(todo);
        return mapToDTO(updated);
    }

    @Override
    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found with id: " + id));
        todoRepository.delete(todo);
    }

    private TodoResponseDTO mapToDTO(Todo todo) {
        TodoResponseDTO dto = new TodoResponseDTO();
        dto.setId(todo.getId());
        dto.setTitle(todo.getTitle());
        dto.setDescription(todo.getDescription());
        dto.setStatus(todo.getStatus());
        dto.setDueDate(todo.getDueDate());
        return dto;
    }
}
