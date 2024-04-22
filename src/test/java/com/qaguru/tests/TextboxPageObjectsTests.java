package com.qaguru.tests;

import com.qaguru.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextboxPageObjectsTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();


    @Test
    void successTest() {
        textBoxPage.openPage()
                .removeBanners()
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
