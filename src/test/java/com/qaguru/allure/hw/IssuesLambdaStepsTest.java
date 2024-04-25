package com.qaguru.allure.hw;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class IssuesLambdaStepsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE = "Issue_created_to_test_allure_reports";

    @Test
    @Feature("Issue")
    @Story("Проверить, что конкретная issue существует")
    @DisplayName("Проверить, что в репозитории есть  'Issue_created_to_test_allure_reports'")
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> open("https://github.com"));
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-button").click();
            $(" #query-builder-test").sendKeys("eroshenkoam/allure-example");
            $("#query-builder-test").submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> $(linkText(REPOSITORY)).click());
        step("Открываем таб Issues", () -> $("#issues-tab").click());
        step("Проверяем наличие Issue с названием " + ISSUE, () -> {
            $(byText(ISSUE)).should(Condition.exist);
        });
    }

}