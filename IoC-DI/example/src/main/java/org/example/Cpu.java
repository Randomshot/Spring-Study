package org.example;

import org.springframework.stereotype.Component;

@Component
public class Cpu {
    public Cpu() {
        System.out.println("Cpu 생성자");
    }
    public void exec(){
        System.out.println("CPU ON!");
    }
}
