package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanApplicationConfig {
    @Bean
    public MainBoard mainBoard(Cpu cpu, Gpu gpu, Ram ram){
        MainBoard mB = new MainBoard();
        mB.setCpu(cpu);
        mB.setGpu(gpu);
        mB.setRam(ram);
        return  mB;
    }

    @Bean
    public Cpu cpu(){
        return new Cpu();
    }

    @Bean
    public Gpu gpu(){
        return new Gpu();
    }

    @Bean
    public Ram ram(){
        return new Ram();
    }
}
