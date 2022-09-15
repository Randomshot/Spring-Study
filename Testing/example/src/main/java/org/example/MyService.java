package org.example;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    private  final  Calculator calculator;

    public MyService(Calculator calculator) {
        this.calculator = calculator;
    }

    public int execute(int value1, int value2){
        return calculator.plus(value1,value2) * 2;
    }
}
