package me.datalight.albert.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MainBoardPage extends BasePage {

    private final String BOARD_NAME = "Auto test";
    private final String BOARD_RENAME = "Auto rest";
    private final String WIDGET_RENAME = "Auto chart";
    private final String WIDGET_ROWS_TEXT = "ETH sending addresses cnt. 24h";

    private SelenideElement newBoardInput = $(byValue("New board"));
    public SelenideElement exploreTheLab = $(byId("getStarted"));
    private SelenideElement widgetInput = $(byXpath("//*[@id=\"root\"]/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div[1]/div/input"));
    private SelenideElement renameBoardInput = $(byValue(BOARD_NAME));
    private SelenideElement newBoardName = $(byValue(BOARD_NAME));
    private SelenideElement renameWidgetNameInput = $(byValue(WIDGET_RENAME));
    private SelenideElement renameWidgetName = $(byText(WIDGET_RENAME));
    private SelenideElement reBoardName = $(byValue(BOARD_RENAME));
    private SelenideElement board = $(byText(BOARD_NAME));
    private SelenideElement widgetRowsText = $(byXpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[1]/div/div[2]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div/div/div[1]/div/span[1]"));
    private SelenideElement buyMarketText = $(byText(WIDGET_ROWS_TEXT));
    private SelenideElement reboard = $(byText(BOARD_RENAME));
    private SelenideElement deleteButton = $(byText("Delete"));
    private SelenideElement lineChart = $(byText("Line Chart"));
    private SelenideElement simpleTable = $(byText("Table"));
    private SelenideElement simpleTableImg = $(byXpath("//*[@id=\"root\"]/div/div/div/div[1]/div[1]/div/div[1]/div[1]/div/div/div/div[2]/div"));
    private SelenideElement histogramCoin = $(byText("Histogram (Coin)"));
    private SelenideElement histogramCoinImg = $(byXpath("//*[@id=\"root\"]/div/div/div/div[1]/div[1]/div/div[1]/div[1]/div/div/div/div[3]/div"));
    private SelenideElement histogramDate = $(byText("Histogram (Date)"));
    private SelenideElement histogramDateImg = $(byXpath("//*[@id=\"root\"]/div/div/div/div[1]/div[1]/div/div[1]/div[1]/div/div/div/div[7]/div"));
    private SelenideElement treemap = $(byText("Treemap"));
    private SelenideElement treemapImg = $(byXpath("//*[@id=\"root\"]/div/div/div/div[1]/div[1]/div/div[1]/div[1]/div/div/div/div[4]/div"));
    private SelenideElement piechart = $(byText("Pie Chart"));
    private SelenideElement piechartImg = $(byXpath("//*[@id=\"root\"]/div/div/div/div[1]/div[1]/div/div[1]/div[1]/div/div/div/div[5]/div"));
    private SelenideElement radar = $(byText("Radar"));
    private SelenideElement radarImg = $(byXpath("//*[@id=\"root\"]/div/div/div/div[1]/div[1]/div/div[1]/div[1]/div/div/div/div[6]/div"));
    private SelenideElement widgetMenu = $(byClassName("widget-wrapper__menu"));
    private SelenideElement widgetMenuRemove = $(byText("Remove from board"));
    private SelenideElement widgetMenuCustromize = $(byText("Customize"));
    private SelenideElement customizeRows = $(byXpath("//*[@id=\"root\"]/div[1]/div/div/div[1]/div[2]/div/div[2]/div[1]/div/div[1]/div[2]"));
    private SelenideElement dropdownRows = $(byClassName("react-select__value-container"));
    private SelenideElement labRows = $(byText("rows"));
    public SelenideElement pro = $(byText("PRO"));
    public SelenideElement overlayClose = $(".plan-offer-overlay__close");
//    protected SelenideElement labRows = $(byXpath("//*[@id=\"root\"]/div/div/div/div[1]/div[2]/div/div[2]/div[1]/div/div[2]/div"));

    public void newBoard() {
        newBoard.click();
        newBoardInput.shouldBe(Condition.visible).val(BOARD_NAME);
        newBoardName.pressEnter();
    }

    public void deleteBoard() {
        reboard.hover();
        Selenide.actions().moveToElement(reboard, 52, 1 ).click().build().perform();
        deleteButton.click();
        reboard.shouldNotBe(Condition.visible);
    }

    public void renameBoard() {
        board.doubleClick();
        renameBoardInput.val(BOARD_RENAME);
        reBoardName.pressEnter();
        reboard.shouldBe(Condition.visible);
    }

    public void deleteWidget(SelenideElement element) {
        widgetMenu.click();
        widgetMenuRemove.click();
        element.shouldNotBe(Condition.visible);
    }

    public void renameWidget() {
        widgetMenu.click();
        widgetMenuCustromize.click();
        widgetInput.doubleClick();
        widgetInput.val(WIDGET_RENAME);
        renameWidgetNameInput.pressEnter();
        done.click();
        renameWidgetName.shouldBe(Condition.visible);
    }

    public void modifyWidget() {
        widgetMenu.click();
        widgetMenuCustromize.click();
//        Actions builder = new Actions(getWebDriver());
//        Action dragAndDrop = builder.clickAndHold(widgetRowsText)
//                .moveToElement(labRows)
//                .moveByOffset(0,-10)
//                .release(labRows)
//                .build();
//
//        dragAndDrop.perform();
//        customizeRows.click();
//        widgetRowsText.dragAndDropTo(labRows);
//        Selenide.actions().moveToElement(labRows, 1, -40 ).build().perform();
//        labRows.click();
        widgetRowsText.dragAndDropTo(labRows);
        Selenide.actions().moveToElement(labRows, 2, 1 ).build().perform();
        widgetRowsText.click();
        sleep(45000);
//        dropdownRows.click();
//        dropdownRows.sendKeys("Buy");
//        dropdownRows.pressEnter();
//        widgetRowsText.click();
//        doneRows.click();
        done.click();
        buyMarketText.shouldBe(Condition.visible);
    }

    public void addLineChart() {
        addWidget.click();
        done.click();
        lineChart.shouldBe(Condition.visible);
    }

    public void addTable() {
        addWidget.click();
        simpleTableImg.click();
        done.click();
        simpleTable.shouldBe(Condition.visible);
    }

    public void addHistogramCoin() {
        addWidget.click();
        histogramCoinImg.click();
        done.click();
        histogramCoin.shouldBe(Condition.visible);
    }

    public void addHistogramDate() {
        addWidget.click();
        histogramDateImg.click();
        done.click();
        histogramDate.shouldBe(Condition.visible);
    }

    public void addTreemap() {
        addWidget.click();
        treemapImg.click();
        done.click();
        treemap.shouldBe(Condition.visible);
    }

    public void addPieChart() {
        addWidget.click();
        piechartImg.click();
        done.click();
        piechart.shouldBe(Condition.visible);
    }

    public void addRadar() {
        addWidget.click();
        radarImg.click();
        done.click();
        radar.shouldBe(Condition.visible);
    }
}
