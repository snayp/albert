package me.datalight.albert;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.ullink.slack.simpleslackapi.SlackSession;
import io.qameta.allure.selenide.AllureSelenide;
import me.datalight.albert.pages.BasePage;
import me.datalight.albert.utils.Slack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

public class BaseTest extends BasePage {

    protected static SlackSession session;
//    protected static String baseUrl = "https://******************";

    @BeforeAll
    public static void setup() throws IOException {
        SelenideLogger.addListener("allure", new AllureSelenide());
        session = Slack.connect();
        Configuration.timeout = 6000;
        Configuration.baseUrl = baseUrl;
    }

    @AfterEach
    public void teardown() {
        Selenide.close();
    }

}
