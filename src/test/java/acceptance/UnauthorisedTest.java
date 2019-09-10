package acceptance;

import me.datalight.albert.BaseTest;
import me.datalight.albert.pages.CoinPage;
import me.datalight.albert.pages.CoinsPage;
import me.datalight.albert.pages.MainPage;
import me.datalight.albert.pages.MarketPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class UnauthorisedTest extends BaseTest {

    MainPage mainPage = new MainPage();
    CoinsPage coinsPage = new CoinsPage();
    CoinPage coinPage = new CoinPage();
    MarketPage marketPage = new MarketPage();
    int[] list100 = IntStream.range(1, 101).toArray();
    int[] list200 = IntStream.range(101, 201).toArray();
    int[] list300 = IntStream.range(201, 301).toArray();

    @BeforeEach
    void openB() {
        open();
    }

    @Test
    void testHeaderPlatformIndexes() {
        mainPage.headerPanelIndexesTitles.shouldHave(texts("TotalCap USD", "VOLUME 24h", "BUY MARKET 24H", "TELEGRAM HYPE 24H", "BTCX", "CVIX 30D", "Sharpe Ratio 30D"));
        mainPage.headerPanelIndexesLinks.forEach(l->{
            l.shouldHave(attribute("href", baseUrl + "/market"));
        });
    }

    @Test
    void testCoinsPage() {
        mainPage.coinsLink.click();
        cookies.click();
        coinsPage.coinsRankCells.shouldHave(texts("RANK", "NAME", "RATING", "MARKET CAP $", "PRICE $", "PRICE +/- $", "VOLUME 24H $", "VOL +/- 24H", "BUY MARKET 24H", "HYPE +/-", "TOTAL MOOD", "PRICE GRAPH 7D"));

        coinsPage.coinsRanks.shouldHaveSize(100);
        assertThat("На первой странице коинов не 100 первых коинов", String.valueOf(coinsPage.coinsRanks.texts()), equalTo(Arrays.toString(list100)));
        coinsPage.next100.click();
        coinsPage.coinsRanks.shouldHaveSize(100);
        assertThat("На второй странице коинов не следующие 100 коинов", String.valueOf(coinsPage.coinsRanks.texts()), equalTo(Arrays.toString(list200)));
        coinsPage.next100.click();
        coinsPage.coinsRanks.shouldHaveSize(100);
        assertThat("На третьей странице коинов не следующие 100 коинов", String.valueOf(coinsPage.coinsRanks.texts()), equalTo(Arrays.toString(list300)));
        coinsPage.top100.click();
        coinsPage.coinsRanks.shouldHaveSize(100);
        assertThat("На первой странице коинов не 100 первых коинов", String.valueOf(coinsPage.coinsRanks.texts()), equalTo(Arrays.toString(list100)));
    }

    @Test
    void testCheckFooterLinks() {
        mainPage.footerPlatformLinks.shouldHave(texts("Data Lab","API","Pricing","FAQ"));
        mainPage.footerCompanyLinks.shouldHave(texts("Blog","Privacy","Terms","Terms of the contest"));
        mainPage.footerContactUsLinks.shouldHave(texts("info@datalight.me","Telegram chat"));
    }

    @Test
    void testBitcoinPage() {
        mainPage.bitcoin.click();
        checkUrl("/coins/bitcoin");
        coinPage.rank.shouldBe(visible);
        coinPage.atl.shouldBe(visible);
        coinPage.ath.shouldBe(visible);
        coinPage.atlPrice.shouldBe(visible);
        coinPage.athPrice.shouldBe(visible);
        coinPage.charts.shouldBe(visible);
        coinPage.exchange_pie.shouldBe(visible);
        coinPage.currency_pie.shouldBe(visible);
        coinPage.about.shouldBe(visible);
        coinPage.similar_projects.shouldBe(visible);
        coinPage.website.shouldHave(attribute("href", "https://bitcoin.org/"));
    }

    @Test
    void testMarketPage() {
        mainPage.market.click();
        checkUrl("/market");
        marketPage.totalMarketCap.shouldBe(visible);
        marketPage.topGainers.shouldBe(visible);
        marketPage.topLosers.shouldBe(visible);
        marketPage.showMore.shouldBe(visible);
        marketPage.dominance.shouldBe(visible);
        marketPage.getDeeper.shouldBe(visible);
    }
}
