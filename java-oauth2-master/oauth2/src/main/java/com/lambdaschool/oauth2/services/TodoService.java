package com.lambdaschool.oauth2.services;

import com.lambdaschool.oauth2.models.Todo;

import java.util.List;

public interface TodoService {
    Todo updateTodo(Todo todo, long todoid);

    List<Todo> findAllTodos();
}
