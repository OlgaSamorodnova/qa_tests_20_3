package com.example;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

public class DemoJUitTest {
    Calculator calc;
    @BeforeAll
    static void beforeAll() {
        System.out.println("#### @BeforeAll");
        Configuration.browser="chrome";
    }
    @AfterAll
    static void AfterAll() {
        System.out.println("#### @AfterAll");
    }
    @BeforeEach
    void beforeEach(){
        System.out.println("#### @BeforeEach");
        calc = new Calculator();
    }
    @AfterEach
    void AfterEach(){
        System.out.println("#### @AfterEach");
    }
    @Test
    void FirstTest(){
        System.out.println("    #### @Test firstTest");
        int result=calc.summ(2,2);
        Assertions.assertTrue(result ==4);
    }

    @Test
    void SecondTest(){
        System.out.println("    #### @Test secondTest");
        int result=calc.mult(2,2);
        Assertions.assertTrue(result ==4);
    }

}
