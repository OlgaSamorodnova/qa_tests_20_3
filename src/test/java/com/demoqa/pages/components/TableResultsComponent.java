package com.demoqa.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResultsComponent {
    SelenideElement
            table = $(".table-responsive"),
            tabletitle = $(".modal-header");

    public void verifyTitle() {
        tabletitle.shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResults(String key, String value) {
        table.$(byText(key)).sibling(0).shouldHave(text(value));
    }
}
