package me.datalight.albert.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MarketPage extends BasePage {
    public SelenideElement totalMarketCap = $(byText("Total Market Capitalization"));
    public SelenideElement topGainers = $(byText("Top Gainers"));
    public SelenideElement topLosers = $(byText("Top Losers"));
    public SelenideElement showMore = $(byLinkText("SHOW MORE DATA"));
    public SelenideElement dominance = $(byText("Percentage of Total Market Dominance"));
    public SelenideElement getDeeper = $(byText("Get deeper insights into"));
}
