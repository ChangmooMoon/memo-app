package com.example.memoapp.service;

import com.example.memoapp.model.TodoEntity;
import com.example.memoapp.persistence.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(final TodoRepository repository) {
        this.todoRepository = repository;
    }

    public String testService() {
        TodoEntity entity = TodoEntity.builder()
            .title("My first todo item")
            .build(); // 생성

        todoRepository.save(entity); // 저장
        TodoEntity savedEntity = todoRepository.findById(entity.getId()).get(); // 검색
        return savedEntity.getTitle();
    }
}
