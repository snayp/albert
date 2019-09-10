package me.datalight.albert.signin;

import me.datalight.albert.BaseTest;
import org.junit.jupiter.api.Test;

public class SigninTest extends BaseTest {

    SigninPage signinPage = new SigninPage();

    @Test
    void testGoogleSignin() {
        signinPage.googleSignin();
    }

    @Test
    void testFbSignin() {
        signinPage.fbSignin();
    }
}
