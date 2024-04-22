package com.qaguru.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DuckDuckGoWebTest {

    @BeforeEach
    void setUP() {
        open("https://duckduckgo.com/");
    }
    @ValueSource(strings =  {
            "selenide", "JUnit 5"
    })
    @ParameterizedTest(name = "Не пустой список карточек в поисковом запросе {0}")
    @Tag("BLOCKER")
    void searchResultsShouldNotBeEmpty(String SearchQuery) {
        $("#searchbox_input").setValue(SearchQuery).pressEnter();
        $$("[data-testid='mainline'] li[data-layout='organic']")
                .shouldBe(sizeGreaterThan(0));
    }

    @CsvFileSource(resources = "/test_data/searchResultsShouldContainExpectedUrl.csv")
    @ParameterizedTest(name = "Должна быть ссылка {1} в результатах поискового запроса {0}")
    @Tag("BLOCKER")
    void searchResultsShouldContainExpectedUrl(String searchQuery, String expectedLink) {
        $("#searchbox_input").setValue(searchQuery).pressEnter();
        $("[data-testid='mainline'] li[data-layout='organic']")
                .shouldHave(text(expectedLink));
    }

    @Test
    @Tag("BLOCKER")
    @DisplayName("Не пустой список фото в поисковом запросе 'selenide'")
    void searchPhotoResultsShouldNotBeEmpty() {
        $("#searchbox_input").setValue("selenide").pressEnter();
        $("[data-zci-link='images']").click();
        $$("img.tile--img__img")
                .shouldBe(sizeGreaterThan(0));
    }



}
