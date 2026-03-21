package com.todo_list_api.repository;

import com.todo_list_api.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TodoRepository extends JpaRepository <Todo, Long> {
}
