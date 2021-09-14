package com.example.todolist.controller;

import com.example.todolist.entity.Todo;
import com.example.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodolistController {
    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/api/todolist", method = RequestMethod.POST)
    public String createTodolist(@RequestBody Todo todo){
        return todoService.createTodolist(todo);
    }

    @RequestMapping(value = "/api/todolist", method = RequestMethod.GET)
    public List<Todo> readTodolist(){
        return todoService.readTodolist();
    }

    @RequestMapping(value = "/api/todolist", method = RequestMethod.PUT)
    public String updateTodolist(@RequestBody Todo todo){
        return todoService.updateTodolist(todo);
    }

    @RequestMapping(value = "/api/todolist", method = RequestMethod.DELETE)
    public String deleteTodolist(@RequestBody Todo todo){
        return todoService.deleteTodolist(todo);
    }
}
