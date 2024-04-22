package com.qaguru.tests;

import com.qaguru.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.qaguru.utils.RandomUtils.*;

public class RegistrationPageObjectsWithFakerTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

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
