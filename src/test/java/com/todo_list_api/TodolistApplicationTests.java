package com.todo_list_api;

import com.todo_list_api.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class TodolistApplicationTests {
    @Autowired
    WebTestClient webTestClient;

    @Test
    void testCreateTodoSuccess() {
        var todo = new Todo("todo 1", "desc todo 1", false, 1);

        webTestClient
                .post()
                .uri("/todos")
                .bodyValue(todo)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].name").isEqualTo(todo.getName())
                .jsonPath("$[0].description").isEqualTo(todo.getDescription())
                .jsonPath("$[0].performed").isEqualTo(todo.isPerformed())
                .jsonPath("$[0].priorities").isEqualTo(todo.getPriorities());
    }

    @Test
    public void testCreateTodoFailure() {
        webTestClient
                .post()
                .uri("/todos")
                .bodyValue(
                        new Todo("", "", false, 0))
                .exchange()
                .expectStatus().isBadRequest();
    }
}
