package com.lambdaschool.oauth2.controllers;

import com.lambdaschool.oauth2.models.Todo;
import com.lambdaschool.oauth2.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    // http://localhost:2019/todos/todoid/{todoid}

    @Autowired
    private TodoService todoService;

    @PutMapping(value = "/todoid/{todoid}",
                produces = {"application/json"},
                consumes = {"application/json"})
    public ResponseEntity<?> updateTodo(@RequestBody Todo todo,
                                        @PathVariable long todoid)

    {
        todoService.updateTodo(todo, todoid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "todos",
                produces = {"application/json"})

    public ResponseEntity<?> getAllTodos(){
        return new ResponseEntity<>(todoService.findAllTodos(), HttpStatus.OK);
    }
}
