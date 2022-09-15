package org.example;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

import org.mockito.junit.jupiter.MockitoExtension;

// @ExtendedWith : JUnit 5에서 확장기능을 위해 제공하는 어노테이션, Junit 4 에서의 RunWith 과 같은 역할을 한다.
@ExtendWith(MockitoExtension.class)
public class MockCalculatorTest {
    @InjectMocks
    MyService myService;

    // @Mock : cal
    @Mock
    Calculator calculator;

    @Test
    public void execute() throws Exception{
        int value1 = 10;
        int value2 = 20;
        // given 을 통해 가짜 객체인 calculator 가 동작하는 방식을 규정한다.
        // caculator.plus(10,20) 가 30 이 나올 것임을 명시한다.
        given(calculator.plus(10,20)).willReturn(30);
        // given 에서 caculator.plus(10,20) 은 30 이 나올 것임을 명시하였기에 result 는 60 이 될 것이다.
        int result = myService.execute(value1,value2);
        Mockito.verify(calculator).plus(anyInt(),anyInt());
        Assertions.assertEquals(30,result);
    }

}
