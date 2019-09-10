package acceptance;

import me.datalight.albert.BaseTest;
import me.datalight.albert.pages.MainBoardPage;
import me.datalight.albert.signin.SigninPage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class AddWidgetsToDashboardTest extends BaseTest {

    SigninPage signinPage = new SigninPage();
    MainBoardPage mainBoardPage = new MainBoardPage();


    @Test
    void testUserCanAddWidgets() {
        signinPage.googleSignin();
        mainBoardPage.newBoard();
        mainBoardPage.addLineChart();
//        mainBoardPage.renameWidget();
        mainBoardPage.modifyWidget();
//        mainBoardPage.deleteWidget(mainBoardPage.renameWidgetName);

//        mainBoardPage.addTable();
//        mainBoardPage.addHistogramCoin();
//        mainBoardPage.addTreemap();
//        mainBoardPage.addPieChart();
//        mainBoardPage.addRadar();
//        mainBoardPage.addHistogramDate();
//        mainBoardPage.deleteBoard();
    }
}
