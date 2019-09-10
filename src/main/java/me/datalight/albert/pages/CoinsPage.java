package me.datalight.albert.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.cssSelector;

public class CoinsPage extends BasePage {

    public ElementsCollection coinsRankCells = $$(cssSelector(".table__static-columns .table-widget-view__cell_header"));
    public ElementsCollection coinsRanks = $$(cssSelector(".table-widget-view__cell_rank-test-mark"));
    public SelenideElement next100 = $(byText("NEXT 100"));
    public SelenideElement top100 = $(byText("TOP 100"));
}
