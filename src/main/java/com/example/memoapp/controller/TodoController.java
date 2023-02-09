package com.example.memoapp.controller;

import com.example.memoapp.dto.ResponseDTO;
import com.example.memoapp.service.TodoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("todo")
public class TodoController {

    private final TodoService service;

    public TodoController(final TodoService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public ResponseEntity<Object> testTodo() {
        String str = service.testService();
        List<String> list = new ArrayList<>();
        list.add(str);

        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.ok().body(response);
    }
}
