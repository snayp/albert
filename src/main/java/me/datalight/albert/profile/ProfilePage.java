package me.datalight.albert.profile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import me.datalight.albert.pages.BasePage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class ProfilePage extends BasePage {

    private SelenideElement logOut = $(byText("sign out"));
    private SelenideElement deleteAccount = $(byText("Delete account"));
    private SelenideElement deleteAccountButton = $(byXpath("/html/body/div[11]/div/div/div/div[3]/div[2]/button"));
    private SelenideElement accountSettings = $(byText("settings"));

    public ProfilePage getProfile(SelenideElement profile){
        profile.doubleClick();
        profile.hover();
        logOut.shouldBe(Condition.visible);
        accountSettings.shouldBe(Condition.visible);
        return this;
    }

    public void logOut(SelenideElement profile) {
        profile.hover();
        logOut.click();
        sleep(1200);
        checkUrl("/dashboard");
    }

    public void deleteAccount(SelenideElement profile) {
        profile.hover();
        accountSettings.click();
        deleteAccount.click();
        $(byText("Delete account"), 1).click();
        sleep(1200);
        checkUrl("/dashboard");
    }
}
