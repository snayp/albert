package me.datalight.albert.signin;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import me.datalight.albert.pages.BasePage;
import me.datalight.albert.pages.MainPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SigninPage extends BasePage {

    private SelenideElement googleEmail = $(byId("identifierId"));
    private SelenideElement googlePass = $(byName("password"));
    private SelenideElement googleLogin = $(byId("authgoogle"));
//    private SelenideElement googleLogin = $(byText("Sign in with Google"));
    private SelenideElement fbEmail = $(byId("email"));
    private SelenideElement fbPass = $(byId("pass"));
    private SelenideElement fbLogin = $(byId("authfb"));
//    private SelenideElement fbLogin = $(byText("Sign in with Facebook"));
    private SelenideElement exploreTheLab = $(byText("explore the lab"));
    Set<String> handles = getWebDriver().getWindowHandles();
    List<String> tabs = new ArrayList<String>(handles);

    public void googleSignin() {
//        Selenide.open("https://******************");
        MainPage.signin.click();
//        exploreTheLab.click();
        googleLogin.click();

//        switchTo().window(tabs.get(1));
        switchTo().window(1);
        googleEmail.val("**********").pressEnter();
        googlePass.val("*****").pressEnter();
        switchTo().window(0);
        cookies.click();
        profileGoogle.shouldBe(Condition.visible);
//        mainBoard.shouldBe(Condition.visible);
//        addWidget.shouldBe(Condition.visible);
//        newBoard.shouldBe(Condition.visible);
//        checkUrl("/dashboard");
    }

    public void googleSignin1() {
//        Selenide.open("https://*********");
        MainPage.signin.click();
//        exploreTheLab.click();
        googleLogin.click();
//        switchTo().window(tabs.get(1));
        switchTo().window(1);
        googleEmail.val("******").pressEnter();
        googlePass.val("*******").pressEnter();
        switchTo().window(0);
        cookies.click();
        profileGoogle.shouldBe(Condition.visible);
//        mainBoard.shouldBe(Condition.visible);
//        addWidget.shouldBe(Condition.visible);
//        newBoard.shouldBe(Condition.visible);
//        checkUrl("/dashboard");
    }

    public void googleSignin2() {
//        Selenide.open("******");
        MainPage.signin.click();
//        exploreTheLab.click();
        googleLogin.click();
//        switchTo().window(tabs.get(1));
        switchTo().window(1);
        googleEmail.val("******").pressEnter();
        googlePass.val("******").pressEnter();
        switchTo().window(0);
        cookies.click();
        profileGoogleDS.shouldBe(Condition.visible);
//        mainBoard.shouldBe(Condition.visible);
//        addWidget.shouldBe(Condition.visible);
//        newBoard.shouldBe(Condition.visible);
//        checkUrl("/dashboard");
    }

    public void fbSignin() {
//        Selenide.open("https://bugdone.datalight.me");
        MainPage.signin.click();
//        exploreTheLab.click();
        fbLogin.click();
        switchTo().window(1);
        fbEmail.val("******");
        fbPass.val("******").pressEnter();
        switchTo().window(0);
        cookies.click();
        profileFb.shouldBe(Condition.visible);
//        mainBoard.shouldBe(Condition.visible);
//        addWidget.shouldBe(Condition.visible);
//        newBoard.shouldBe(Condition.visible);
//        checkUrl("/dashboard");
    }
}
