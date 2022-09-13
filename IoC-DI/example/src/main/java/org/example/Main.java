package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
//         new AnnotationConfigApplicationContext() 를 통해 컨테이너를 생성한다. JavaConfig 클래스를 인자로 넘긴다.
//         println 을 통해, 컨테이너가 생성되면서, 각 클래스들도 생성되는 것을 알 수 있다.
//         ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanApplicationConfig.class);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanApplicationConfig.class);
//         getBean() 을 통해 컨테이너에서 인스턴스를 반환한다. 반환할 클래스의 형태를 인자로 넘긴다.
//         만약, id 만 넘길경우 오브젝트 타입으로 리턴하므로, 형변환을 해야한다.

//        ApplicationContext 에는 각 클래스에 대한 인스턴스가 있음을 알 수 있다.
//        Cpu cpu = applicationContext.getBean(Cpu.class);
//        cpu.exec();
//
//        Ram ram = applicationContext.getBean(Ram.class);
//        ram.exec();

        MainBoard mainBoard = applicationContext.getBean(MainBoard.class);
        mainBoard.run();

    }
}
