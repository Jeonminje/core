package hello.core.sigleton;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : 사용자 만원 주문
        int userAprice = statefulService1.order("userA", 10000);
        //ThreadB : 사용자 이만원 주문
        int userBprice = statefulService2.order("userA", 20000);
        //ThreadA : A가 주문금액 조회.
        /*int price = statefulService1.getPrice();*/
        System.out.println("price = " + userAprice);

        /*assertThat(statefulService1.getPrice()).isEqualTo(20000);*/
    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }

    }

}