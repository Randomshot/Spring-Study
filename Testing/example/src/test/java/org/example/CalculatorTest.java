package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

// @ExtendedWith : JUnit 5에서 확장기능을 위해 제공하는 어노테이션, Junit 4 에서의 RunWith 과 같은 역할을 한다.
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class CalculatorTest {

    @Autowired
    Calculator cal;

    @Test
    public void plus() throws Exception{
        int value1 = 10;
        int value2 = 20;

        int result = cal.plus(value1,value2);
        assertEquals(result,30);
    }
    @Test
    public void divideExceptionTest(){
        final int value1 = 10;
        final int value2 = 0;
        assertThrows(
                ArithmeticException.class,
                () -> cal.divide(value1,value2)
        );
    }
}
