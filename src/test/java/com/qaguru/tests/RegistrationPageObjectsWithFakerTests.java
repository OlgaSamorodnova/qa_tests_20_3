package com.qaguru.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.qaguru.pages.RegistrationPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.qaguru.utils.RandomUtils.*;

public class RegistrationPageObjectsWithFakerTests  {
    RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
    static void beforeAll() {
        System.out.println("#### Settings");
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        // Configuration.holdBrowserOpen = true;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
    @Test
    void successTest() {
        String firstName = getFakerFirstName();
        String lastName = getFakerLastName();
        String userEmail = getFakerEmail();
        String currentAddress = getFakerAddress();
        String userNumber = getFakerPhone();
        String gender = getRandomGender();
        String day = getRandomDay();
        String month = getRandomMonth();
        String year = getRandomYear();
        String subject = getRandomSubject();
        String hobbie = getRandomHobbie();
        String state = getRandomState();
        String city = getRandomCity(state);


        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setEmail(userEmail)
                .setNumber(userNumber)
                .setBirthDay(day, month, year)
                .setSubject(subject)
                .setHobby(hobbie)
                .setPicture("img/sample.JPG")
                .setCurrentAddr(currentAddress)
                .setState(state)
                .setCity(city)
                .submitForm()
// Проверка результатов

                .verifyTitle("Thanks for submitting the form")
                .verifyResults("Student Name", firstName + " " + lastName)
                .verifyResults("Student Email", userEmail)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", userNumber)
                .verifyResults("Date of Birth", day + " " + month + "," + year)
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", hobbie)
                .verifyResults("Picture", "sample.JPG")
                .verifyResults("Address", currentAddress)
                .verifyResults("State and City", state + " " + city);


    }
}
