package com.sparta.springauth;

import com.sparta.springauth.food.Food;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest {
    //  같은 타입의 Bean이 2개일 때 해결방법 1
    //    @Autowired
    //    Food pizza;
    //
    //    @Autowired
    //    Food chicken;
    //
    //    @Test
    //    @DisplayName("테스트")
    //
    //    void test1() {
    //        pizza.eat();
    //        chicken.eat();
    //    }

    //  같은 타입의 Bean이 2개일 때 해결방법 2
    //    @Autowired
    //    Food food;
    //
    //    @Test
    //    @DisplayName("테스트2")
    //    void test2() {
    //        food.eat();
    //    }

    //  같은 타입의 Bean이 2개일 때 해결방법 3
    @Autowired
    @Qualifier("pizza")
    Food food;

    @Test
    @DisplayName("테스트2")
    void test2() {
        food.eat();
    }
}