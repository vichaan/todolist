package com.example.todolist.service;

import com.example.todolist.entity.Todo;
import com.example.todolist.repository.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodolistRepository todolistRepository;

    @Transactional
    public String createTodolist(Todo todo){
        todo.setId(null == todolistRepository.findMaxId()? 0 : todolistRepository.findMaxId() + 1);
        todolistRepository.save(todo);
        return "created successfully.";}

    public List<Todo> readTodolist(){

        return todolistRepository.findAll();
    }

    @Transactional
    public String updateTodolist(Todo todo){
        Todo todoToBeUpdate = (Todo) todolistRepository.findById(todo.getId()).get();
        todoToBeUpdate.setTitle(todo.getTitle());
        todoToBeUpdate.setCompleted(todo.getCompleted());
        todolistRepository.save(todoToBeUpdate);
        return "record updated.";
    }

    @Transactional
    public String deleteTodolist(Todo todo) {
        Todo todoDelete = (Todo) todolistRepository.findById(todo.getId()).get();
        todolistRepository.delete(todoDelete);
        return "Deleted successfully.";

    }
}
