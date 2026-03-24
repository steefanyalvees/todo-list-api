package com.todo_list_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private boolean performed;
    private int priorities;

    public Todo(String name, String description, boolean performed, int priorities) {
        this.name = name;
        this.description = description;
        this.performed = performed;
        this.priorities = priorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPerformed() {
        return performed;
    }

    public void setPerformed(boolean performed) {
        this.performed = performed;
    }

    public int getPriorities() {
        return priorities;
    }

    public void setPriorities(int priorities) {
        this.priorities = priorities;
    }
}
