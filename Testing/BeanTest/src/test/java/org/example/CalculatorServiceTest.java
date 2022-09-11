package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 스프링에서는 JUnit 을 확장하도록 사용
// JUnit이 테스트 코드를 실행할 때 스프링 빈 컨테이너가 내부적으로 생성되도록 한다.
@RunWith(SpringJUnit4ClassRunner.class)
// 내부적으로 생성된 스프링 빈 컨테이너가 사용할 설정파일을 지정할 때 사용
@ContextConfiguration(classes = {ApplicationConfig.class})
public class CalculatorServiceTest {
    @Autowired
    CalculatorService calculatorService;

    @Test
    public void plus() throws Exception{
        // given
        int value1 = 10;
        int value2 = 5;

        // when
        int result = calculatorService.plus(value1, value2);

        // then
        Assert.assertEquals(result, 15); // 결과와 15가 같을 경우에만 성공
    }

    @Test
    public void divide() throws Exception{
        // given
        int value1 = 10;
        int value2 = 5;

        // when
        int result = calculatorService.divide(value1, value2);

        // then
        Assert.assertEquals(result, 2); // 결과와 15가 같을 경우에만 성공
    }

    @Test
    public void divideExceptionTest() throws Exception{
        // given
        int value1 = 10;
        int value2 = 0;

        try {
            calculatorService.divide(value1, value2);
        }catch (ArithmeticException ae){
            Assert.assertTrue(true); // 이부분이 실행되었다면 성공
            return; // 메소드를 더이상 실행하지 않는다.
        }

        Assert.assertTrue(false); // 이부분이 실행되면 무조건 실패다.
    }
}