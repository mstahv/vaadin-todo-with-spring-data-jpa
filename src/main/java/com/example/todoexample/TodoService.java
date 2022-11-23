package com.example.todoexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoEntityRepository repository;

    public TodoEntity createTodo(String note) {
        TodoEntity todo = new TodoEntity();
        todo.setNote(note);
        return repository.save(todo);
    };

    public void deleteTodo(TodoEntity todo) {
        repository.delete(todo);
    }

    public void updateTodo(TodoEntity todo) {
        repository.save(todo);
    }

    public List<TodoEntity> findAll() {
        return repository.findAll();
    }
}
