package acceptance;

import com.codeborne.selenide.Condition;
import me.datalight.albert.BaseTest;
import me.datalight.albert.pages.MainBoardPage;
import me.datalight.albert.profile.ProfilePage;
import me.datalight.albert.signin.SigninPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsersTest extends BaseTest {

    ProfilePage profile = new ProfilePage();
    SigninPage signinPage = new SigninPage();
    MainBoardPage mainBoardPage = new MainBoardPage();

    @BeforeEach
    void openB() {
        open();
    }

    @Test
    void testUserGoogleCreateBoardWithWidgets() {
        signinPage.googleSignin1();
        mainBoardPage.exploreTheLab.click();
        mainBoardPage.newBoard();
        mainBoardPage.addLineChart();
        mainBoardPage.addTable();
        mainBoardPage.addHistogramCoin();
        mainBoardPage.addTreemap();
        mainBoardPage.addPieChart();
        mainBoardPage.addRadar();
        mainBoardPage.addHistogramDate();
        mainBoardPage.renameBoard();
        mainBoardPage.deleteBoard();
    }

    @Test
    void testUserGoogleCantCreateBoardAndWidgets() {
        signinPage.googleSignin();
        mainBoardPage.exploreTheLab.click();
        mainBoardPage.newBoard.click();
        mainBoardPage.pro.shouldBe(Condition.visible);
        mainBoardPage.overlayClose.click();
        addWidget.click();
        done.click();
        mainBoardPage.pro.shouldBe(Condition.visible);
    }

    @Test
    void testUserGoogleDeleteAccount() {
        signinPage.googleSignin2();
        profile.getProfile(profileGoogleDS);
        profile.deleteAccount(profileGoogleDS);
    }

    @Test
    void testUserFbLogout() {
        signinPage.fbSignin();
        profile.getProfile(profileFb);
        profile.logOut(profileFb);
    }

    @Test
    void testUserFbDeleteAccount() {
        signinPage.fbSignin();
        profile.getProfile(profileFb);
        profile.deleteAccount(profileFb);
    }
}
