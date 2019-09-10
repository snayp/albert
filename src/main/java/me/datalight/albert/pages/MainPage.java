package me.datalight.albert.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.cssSelector;

public class MainPage extends BasePage {

    public ElementsCollection headerPanelIndexesTitles = $$(cssSelector(".index-panel-view__title"));
    public ElementsCollection headerPanelIndexesLinks = $$(cssSelector(".index-panel-view__metric a"));
    public SelenideElement coinsLink = $(byText("Coins"));
    public SelenideElement platform = $(".footer__column");
    public SelenideElement company = $(".footer__column",1);
    public SelenideElement contact_us = $(".footer__column",2);
    public ElementsCollection footerPlatformLinks = platform.$$(".footer__column-data");
    public ElementsCollection footerCompanyLinks = company.$$(".footer__column-data");
    public ElementsCollection footerContactUsLinks = contact_us.$$(".footer__column-data");
    public SelenideElement bitcoin = $(byText("Bitcoin"));
    public SelenideElement market = $(byText("Market"));
    public static SelenideElement signin = $(byText("Sign in"));
}
