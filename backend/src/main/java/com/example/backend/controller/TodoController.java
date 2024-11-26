package com.example.backend.controller;

import com.example.backend.model.Todo;
import com.example.backend.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.addTodo(
                todo.getTask(),
                todo.getDate(),
                todo.getUserId()));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodosByUserId(@RequestParam Long userId) {
        return ResponseEntity.ok(todoService.getTodosByUserId(userId));
    }

    @DeleteMapping("/{order}")
    public ResponseEntity<String> deleteTodoByOrder(@PathVariable Integer order, @RequestParam Long userId) {
        todoService.deleteTodoByOrder(order, userId);
        return ResponseEntity.ok("Todo successfully deleted.");
    }

    // Todo 수정

    @PutMapping("/{order}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable Integer order,
            @RequestParam Long userId,
            @RequestBody Todo todo) {
        Todo updatedTodo = todoService.updateTodoByOrderAndUserId(order, userId, todo);
        return ResponseEntity.ok(updatedTodo);
    }

}