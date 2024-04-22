package com.qaguru.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTests2 {
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = CHROME;
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void guthubTest() {
//        На главной странице GitHub выберите меню Solutions ->
//        Enterprize с помощью команды hover для Solutions.
//        Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."
        open("https://github.com/");
        $(byClassName("HeaderMenu--logged-out")).$(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        $(byText("Build like the best")).shouldBe(Condition.visible);
    }

    @Test
    void herokuappTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
//        Selenide.actions() не работает
//        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().build().perform();
//        команда $(element).dragAndDrop($(to-element)) работает
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));

    }
}