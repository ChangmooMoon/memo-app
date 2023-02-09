package com.example.memoapp.controller;

import com.example.memoapp.dto.ResponseDTO;
import com.example.memoapp.dto.TestRequestBodyDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("/{id}")
    public String testController(@PathVariable(required = false) int id) {
        return "hello world!" + id;
    }

    @GetMapping("/testRequestBody")
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
        return "hello world!" + testRequestBodyDTO.getId() + " Message: " + testRequestBodyDTO.getMessage();
    }

    @GetMapping("/testResponseBody")
    public ResponseDTO<String> testControllerResponseBody() {
        List<String> list = new ArrayList<>();
        list.add("hello world! im responseDTO");
        list.add("me also responseDTO");
        return ResponseDTO.<String>builder()
            .data(list)
            .build();
    }

    @GetMapping("/testResponseEntity")
    public ResponseEntity<Object> testControllerResponseEntity() {
        List<String> list = new ArrayList<>();
        list.add("Hello world!. i'm responseEntity. and you got 400!");
        ResponseDTO<String> response
            = ResponseDTO.<String>builder()
            .data(list)
            .build();
        return ResponseEntity.badRequest().body(response);
    }
}
