package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successTest() {
        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setGender("Male")
                .setEmail("test@test.com")
                .setNumber("1234567890")
                .setBirthDay("03", "March", "2000")
                .setSubjectLetters("ec")
                .setSubject("Economics")
                .setHobby("Reading")
                .setPicture("img/sample.JPG")
                .setCurrentAddr("Address 1")
                .setState("Haryana")
                .setCity("Karnal")
                .submitForm()
// Проверка результатов

                .verifyTitle()
                .verifyResults("Student Name", "Ivan Ivanov")
                .verifyResults("Student Email", "test@test.com")
                .verifyResults("Gender", "Male")
                .verifyResults("Mobile", "1234567890")
                .verifyResults("Date of Birth", "03 March,2000")
                .verifyResults("Subjects", "Economics")
                .verifyResults("Hobbies", "Reading")
                .verifyResults("Picture", "sample.JPG")
                .verifyResults("Address", "Address 1")
                .verifyResults("State and City", "Haryana Karnal");


    }
}
