package org.example;

import org.springframework.stereotype.Component;

@Component
public class Gpu {
    public Gpu() {
        System.out.println("Gpu 생성자");
    }
    public void exec(){
        System.out.println("GPU ON!");
    }
}
