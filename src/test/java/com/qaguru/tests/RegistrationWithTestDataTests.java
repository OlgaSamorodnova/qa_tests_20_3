package com.qaguru.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.qaguru.utils.RandomUtils.*;

public class RegistrationWithTestDataTests {
    @BeforeAll
    static void beforeAll() {
        System.out.println("#### Settings");
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = CHROME;
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;
    }
    @Test
    void successTest() {
        String firstName = getRandomString(10),
                lastName = getRandomString(10),
                userEmail = getRandomEmail(),
                currentAddress = getRandomAddress(50),
                userNumber = getRandomPhone(),
                gender = getRandomGender();

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--003:not(react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("ec");
        $("#subjectsWrapper").$(byText("Economics")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/sample.JPG");
        $("#currentAddress").setValue(currentAddress);
        $("#stateCity-wrapper").$("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#stateCity-wrapper").$("#city").click();
        $("#city").$(byText("Karnal")).click();
        $("#submit").click();


        $(".table-responsive").shouldHave(text(firstName), text(lastName));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text(gender));
        $(".table-responsive").shouldHave(text(userNumber));
        $(".table-responsive").shouldHave(text("03 March,2000\n"));
        $(".table-responsive").shouldHave(text("Economics"));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("sample.JPG"));
        $(".table-responsive").shouldHave(text(currentAddress));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));

    }
}
