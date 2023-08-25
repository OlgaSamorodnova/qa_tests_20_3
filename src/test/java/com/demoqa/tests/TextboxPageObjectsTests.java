package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextboxPageObjectsTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();


    @Test
    void successTest() {
        textBoxPage.openPage()
                .setUserName("Ivan Ivanov")
                .setUserEmail("test@test.com")
                .setCurrentAddress("Address1")
                .setPermanentAddress("Address2")
                .submitForm()
// Проверка результатов
                .checkOutputName("Ivan Ivanov")
                .checkOutputEmail("test@test.com")
                .checkOutputCurrentAddress("Address1")
                .checkOutputPermanentAddress("Address2");


    }
}
