package com.example.memoapp.service;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    public static final String TEST_MSG = "Test Service";

    public String testService() {
        return TEST_MSG;
    }
}
