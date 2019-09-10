package me.datalight.albert.profile;

import me.datalight.albert.BaseTest;
import me.datalight.albert.signin.SigninPage;
import org.junit.jupiter.api.Test;

public class ProfileTest extends BaseTest {

    ProfilePage profile = new ProfilePage();
    SigninPage signinPage = new SigninPage();

    @Test
    void testLogoutGoogle() {
        signinPage.googleSignin();
        profile.getProfile(profileGoogle);
        profile.logOut(profileGoogle);
    }

    @Test
    void testDeleteGoogle() {
        signinPage.googleSignin();
        profile.getProfile(profileGoogle);
        profile.deleteAccount(profileGoogle);
    }

    @Test
    void testLogoutFb() {
        signinPage.fbSignin();
        profile.getProfile(profileFb);
        profile.logOut(profileFb);
    }

    @Test
    void testDeleteFb() {
        signinPage.fbSignin();
        profile.getProfile(profileFb);
        profile.deleteAccount(profileFb);
    }
}
