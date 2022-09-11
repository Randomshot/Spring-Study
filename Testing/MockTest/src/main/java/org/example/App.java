package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        // ApplicationContext가 관리하는 CalculatorService.class타입의 객체를 요청합니다.
        CalculatorService calculatorService = applicationContext.getBean(CalculatorService.class);

        // ApplicationContext로 부터 받은 객체를 이용하여 덧셈을 구합니다.
        System.out.println(calculatorService.plus(10, 50));
    }
}
