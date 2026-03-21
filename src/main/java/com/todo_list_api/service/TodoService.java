package com.todo_list_api.service;

import com.todo_list_api.entity.Todo;
import com.todo_list_api.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
  public  TodoRepository todoRepository;

  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public List<Todo> create(Todo todo) {
    todoRepository.save(todo);
    return list();
  }

  public List<Todo> list(){
  Sort sort = Sort.by("priorities").descending().and(
            Sort.by("name").ascending());
  return todoRepository.findAll(sort);

  }
  public List<Todo> update(Todo todo){
    todoRepository.save(todo);
    return list();
  }
  public List<Todo> delete(Long id){
  todoRepository.deleteById(id);
  return list();
  }
}

