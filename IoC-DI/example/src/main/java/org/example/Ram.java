package org.example;

import org.springframework.stereotype.Component;

@Component
public class Ram {
    public Ram() {
        System.out.println("Ram 생성자");
    }
    public void exec(){
        System.out.println("RAM ON!");
    }
}
