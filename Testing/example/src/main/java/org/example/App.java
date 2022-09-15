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
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Calculator cal = ac.getBean(Calculator.class);
        System.out.println(cal.plus(1,2));
    }
}
