package com.example.backend.service;

import com.example.backend.model.Todo;
import com.example.backend.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // 할 일 추가 (userId마다 order 독립 관리)
    public Todo addTodo(String task, LocalDate date, Long userId) {
        Integer maxOrder = todoRepository.findMaxOrderByUserId(userId).orElse(0); // 없으면 0
        Todo todo = new Todo();
        todo.setTask(task);
        todo.setDate(date != null ? date : LocalDate.now());
        todo.setCompleted(false);
        todo.setOrder(maxOrder + 1); // userId별 order 값 설정
        todo.setUserId(userId); // userId 설정
        return todoRepository.save(todo);
    }

    // 특정 사용자(userId)의 할 일 전체 조회
    public List<Todo> getTodosByUserId(Long userId) {
        return todoRepository.findAllByUserIdOrderByOrderAsc(userId);
    }

    // 특정 할 일 삭제 (userId와 order로)
    public void deleteTodoByOrder(Integer taskOrder, Long userId) {
        Todo todoToDelete = todoRepository.findByOrderAndUserId(taskOrder, userId)
                .orElseThrow(() -> new RuntimeException("Todo with task_order " + taskOrder + " and userId " + userId + " not found"));

        int deletedOrder = todoToDelete.getOrder(); // 삭제될 항목의 task_order
        todoRepository.delete(todoToDelete); // 삭제 수행

        // 삭제된 order보다 큰 항목들의 order를 1씩 감소
        List<Todo> todosToUpdate = todoRepository.findByOrderGreaterThanAndUserId(deletedOrder, userId);
        for (Todo todo : todosToUpdate) {
            todo.setOrder(todo.getOrder() - 1);
            todoRepository.save(todo); // 변경된 order 저장
        }
    }

    //할 일 수정
    public Todo updateTodo(Long id, String task, LocalDate date, Boolean completed) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo with id " + id + " not found"));

        if (task != null && !task.isEmpty()) {
            todo.setTask(task);
        }
        if (date != null) {
            todo.setDate(date);
        }
        if (completed != null) {
            todo.setCompleted(completed);
        }

        return todoRepository.save(todo);
    }

    public Todo getTodoByIdAndUserId(Long id, Long userId) {
        return todoRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new RuntimeException("Todo with id " + id + " and userId " + userId + " not found"));
    }
    // 특정 order와 userId로 Todo 조회
    public Todo getTodoByOrderAndUserId(Integer order, Long userId) {
        return todoRepository.findByOrderAndUserId(order, userId)
                .orElseThrow(() -> new RuntimeException("Todo with order " + order + " and userId " + userId + " not found"));
    }

    // order와 userId로 Todo 업데이트

    public Todo updateTodoByOrderAndUserId(Integer order, Long userId, Todo updatedTodo) {
        // 기존 Todo 조회
        Todo existingTodo = todoRepository.findByOrderAndUserId(order, userId)
                .orElseThrow(() -> new RuntimeException("Todo with order " + order + " and userId " + userId + " not found"));

        // 필드 업데이트
        if (updatedTodo.getTask() != null) {
            existingTodo.setTask(updatedTodo.getTask());
        }
        if (updatedTodo.getDate() != null) {
            existingTodo.setDate(updatedTodo.getDate());
        }
        if (updatedTodo.getCompleted() != null) {
            existingTodo.setCompleted(updatedTodo.getCompleted());
        }

        return todoRepository.save(existingTodo);
    }
}