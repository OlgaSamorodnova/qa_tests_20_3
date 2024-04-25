package com.qaguru.allure.hw;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.qaguru.allure.hw.steps.Steps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class IssueAnnotatedStepsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE = "Issue_created_to_test_allure_reports";

    @Test
    @Feature("Issue")
    @Story("Проверить, что конкретная issue существует")
    @DisplayName("Проверить, что в репозитории есть  'Issue_created_to_test_allure_reports'")
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Steps steps = new Steps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithName(ISSUE);

    }

}