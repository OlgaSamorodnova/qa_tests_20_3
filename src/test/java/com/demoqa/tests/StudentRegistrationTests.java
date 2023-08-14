package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationTests {
    @BeforeAll
    static void beforeAll() {
        System.out.println("#### Settings");
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.headless=true;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = CHROME;
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen=true;
    }
    @Test
    void successTest() {
        System.out.println("#### Fill in the form");
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("test@test.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $("#dateOfBirth-wrapper").$(".react-datepicker__month-select").click();
        $("#dateOfBirth-wrapper").$(byText("March")).click();
        $("#dateOfBirth-wrapper").$(".react-datepicker__year-select").click();
        $("#dateOfBirth-wrapper").$(byText("2000")).click();
        $(".react-datepicker__day--003").click();
        $("#subjectsInput").setValue("ec");
        $(byText("Economics")).click();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("/Users/springgale/Documents/GitHub/qa_tests_20_3/src/test/java/com/data/sample.JPG"));
        $("#currentAddress").setValue("Address 1");
        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();


        System.out.println("#### Check the form submission");
        $(".table-responsive").shouldHave(text("Ivan Ivanov"));
        $(".table-responsive").shouldHave(text("test@test.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("03 March,2000\n"));
        $(".table-responsive").shouldHave(text("Economics"));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("sample.JPG"));
        $(".table-responsive").shouldHave(text("Address 1"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));

    }
}
