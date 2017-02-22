package org.zjye.math;

import org.springframework.stereotype.Service;

@Service
public class Calculator {

    public int multiply(int x, int y) {
        return x * y;
    }

    public int plus(int x, int y) {
        return x + y;
    }
}
