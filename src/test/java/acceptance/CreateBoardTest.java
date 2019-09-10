package acceptance;

import me.datalight.albert.BaseTest;
import me.datalight.albert.pages.MainBoardPage;
import me.datalight.albert.signin.SigninPage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class CreateBoardTest extends BaseTest {

    SigninPage signinPage = new SigninPage();
    MainBoardPage mainBoardPage = new MainBoardPage();

    @Test
    void testUserCanCreateBoard() {
        signinPage.googleSignin();
        mainBoardPage.newBoard();
        mainBoardPage.renameBoard();
        mainBoardPage.deleteBoard();
    }
}
