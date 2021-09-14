package com.example.todolist.repository;

import com.example.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface TodolistRepository<integer> extends JpaRepository<Todo,integer>{

    @Query("select max(t.id) from Todo t")
    public Integer findMaxId();


}
