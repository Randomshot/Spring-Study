package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainBoard {
    @Autowired
    Ram ram;
    @Autowired
    Cpu cpu;
    @Autowired
    Gpu gpu;


    public MainBoard() {
        System.out.println("MainBoard 생성자");
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public void setGpu(Gpu gpu) {
        this.gpu = gpu;
    }

    public void run(){
        System.out.println("컴퓨터 전원을 킵니다.");
        ram.exec();
        cpu.exec();
        gpu.exec();
    }
}
