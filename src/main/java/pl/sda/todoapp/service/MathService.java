package pl.sda.todoapp.service;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
}
