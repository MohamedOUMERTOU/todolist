package com.dotolist.todo.service;



import com.dotolist.todo.dto.TodoRequestDTO;
import com.dotolist.todo.dto.TodoResponseDTO;

import java.util.List;

public interface TodoService {

    TodoResponseDTO createTodo(TodoRequestDTO todoRequestDTO);

    List<TodoResponseDTO> getAllTodos();

    TodoResponseDTO getTodoById(Long id);

    TodoResponseDTO updateTodo(Long id, TodoRequestDTO todoRequestDTO);

    void deleteTodo(Long id);
}

