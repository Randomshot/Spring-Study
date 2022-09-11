package org.example;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 스프링 설정파일임을 의미
@ComponentScan(basePackages = {"org.example"})
public class ApplicationConfig {
}