package me.datalight.albert.screenshot;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.ullink.slack.simpleslackapi.SlackAttachment;
import com.ullink.slack.simpleslackapi.SlackPreparedMessage;
import com.ullink.slack.simpleslackapi.SlackUser;
import me.datalight.albert.BaseTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FirefoxTest extends BaseTest {

    private SelenideElement googleEmail = $(byId("identifierId"));
    private SelenideElement googlePass = $(byName("password"));
    private SelenideElement googleLogin = $(byText("GOOGLE"));
    private SelenideElement exploreTheLab = $(byText("explore the lab"));

    @BeforeAll
    public static void setupChrome() {
        Configuration.browser = "firefox";
        System.setProperty("selenide.browser", "firefox");
    }

    @Test
    public void firefox() {
        Selenide.open("https://**************");
        sleep(5000);
        screenshot("main_page_ff");
        Selenide.open("https://****************/coins/bitcoin");
        sleep(5000);
        screenshot("bitcoin_page_ff");

        Selenide.open("https://**************************/auth/signin");
        sleep(5000);
        screenshot("auth_signin_ff");
        googleLogin.click();
        googleEmail.val("*********").pressEnter();
        googlePass.val("******************").pressEnter();
        sleep(10000);
        screenshot("dashboard_ff");
    }
}
