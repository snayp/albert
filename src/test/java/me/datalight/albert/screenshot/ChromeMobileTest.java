package me.datalight.albert.screenshot;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import me.datalight.albert.BaseTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Disabled
public class ChromeMobileTest extends BaseTest {

    private SelenideElement googleEmail = $(byId("identifierId"));
    private SelenideElement googlePass = $(byName("password"));
    private SelenideElement googleLogin = $(byText("GOOGLE"));
    private SelenideElement exploreTheLab = $(byText("explore the lab"));
    private static WebDriver driver;

    @BeforeAll
    public static void setupChrome() {
        Configuration.browser = "chrome";
        System.setProperty("selenide.browser", "chrome");
        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "Nexus 5");


        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        driver = new ChromeDriver(chromeOptions);
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterAll
    public static void close() {
        driver.close();
    }

    @Test
    public void chrome() {
        Selenide.open("https://***********");
        sleep(5000);
        screenshot("main_page_chrome");
        Selenide.open("https://*********");
        sleep(5000);
        screenshot("bitcoin_page_chrome");

        Selenide.open("https://***************/auth/signin");
        sleep(5000);
        screenshot("auth_signin_chrome");
        googleLogin.click();
        googleEmail.val("**************").pressEnter();
        googlePass.val("*********").pressEnter();
        sleep(10000);
        screenshot("dashboard_chrome");
    }
}
