package me.datalight.albert.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class BasePage {

    public Logger log = LoggerFactory.getLogger(getClass());

    public static final String baseUrl = "******";

    public SelenideElement newBoard = $(byXpath("//*[@id=\"root\"]/div[1]/div/div/main/div/div/div[1]/div[1]/div/div/div/div[1]/div/div[1]/div/div/div"));
    public SelenideElement profileGoogle = $(byText("Auto"));
    public SelenideElement profileGoogleDS = $(byText("Dmitry S."));
    public SelenideElement profileFb = $(byText("Agile O."));
    public SelenideElement logo = $(byXpath("/html/body/div[1]/div/header/div/a/img"));
    protected SelenideElement mainBoard = $(byText("DataLight"));
    public SelenideElement addWidget = $(byXpath("//*[@id=\"root\"]/div[1]/div/div/main/div/div/div[2]/div/a"));
    public SelenideElement cookies = $(byText("Ok, I Agree"));
    public SelenideElement done = $(byText("Done"));


    public static void open(){
        Selenide.open(baseUrl);
    }

    public String getUrl() {
        return url();
    }

    public void checkUrl(String url) {
        assertThat("Текущий урл НЕ правильный " + getUrl(), getUrl(), containsString(url));
    }
}
