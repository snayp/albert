package me.datalight.albert.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CoinPage extends BasePage {

    public SelenideElement rank = $(byText("rank 1"));
    public SelenideElement atl = $(byText("ATL"));
    public SelenideElement ath = $(byText("ATH"));
    public SelenideElement atlPrice = $(byText("$68.4"));
    public SelenideElement athPrice = $(byText("$19 497.4"));
    public SelenideElement website = $(byText("website"));
    public SelenideElement charts = $(byText("Charts"));
    public SelenideElement exchange_pie = $(byText("Exchange % Pie"));
    public SelenideElement currency_pie = $(byText("Currency type % Pie"));
    public SelenideElement about = $(byText("about Bitcoin (BTC)"));
    public SelenideElement similar_projects = $(byText("Similar projects"));
}
