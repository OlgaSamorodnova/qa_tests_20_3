package com.qaguru.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextboxTests {
    @BeforeAll
    static void beforeAll() {
        System.out.println("#### Set Browser size");
        Configuration.browserSize="1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successTest() {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("Ivan Ivanov");
        $("#userEmail").setValue("test@test.com");
        $("#currentAddress").setValue("Address1");
        $("#permanentAddress").setValue("Address2");
        $("#submit").click();

        $("#output #name").shouldHave(text("Ivan Ivanov"));
        $("#output #email").shouldHave(text("test@test.com"));
        $("#output #currentAddress").shouldHave(text("Address1"));
        $("#output #permanentAddress").shouldHave(text("Address2"));


    }
}
