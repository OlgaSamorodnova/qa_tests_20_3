package com.qaguru.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class PolkaswapWebTest {
    @BeforeEach
    void setUP() {
        open("https://polkaswap.io/#/explore/tokens");
    }

    @ValueSource(strings =  {
            "xor", "val", "pswap"
    })
    @ParameterizedTest(name = "При переключении ползунка 'Show only synthetic tokens' в результатах не отображается токен {0}")
    void noSyntheticsInSearchResults(String notSyntheticTokens) {
        $(".el-switch__core").click();
        $(".el-table__body .el-table__row")
                .shouldNotHave(text(notSyntheticTokens));
        $(".el-switch__core").click();
    }

    @CsvFileSource(resources = "/test_data/SearchResultsShouldContainExpectedTokenName.csv")
    @ParameterizedTest(name = "При поиске по слову {0} выдает результат с текстом {1}")
    void searchResultsShouldContainExpectedTokenName(String searchQuery, String expectedToken) {
        $(".el-input__inner").setValue(searchQuery);
        $(".el-table__body .el-table__row").shouldHave(text(expectedToken));
    }
    @CsvSource({"English,Tokens",
            "Armenian,Նշաններ",
            "Dutch,Tokens",
            "French,Jetons"
    }
    )
    @ParameterizedTest(name = "При установленном языке {0} текст заголовка - {1} ")
    void checkTranslationOfHeader(String language, String expectedText) {
        $(".el-dropdown-selfdefine").click();
        $(byClassName("header-menu__item")).sibling(1).click();
        $(byClassName("select-language-list")).$(byText(language)).click();
        $(".s-icon-x-16").click();
        $(".explore-container-dropdown__selected").shouldHave(text(expectedText));
    }
}
