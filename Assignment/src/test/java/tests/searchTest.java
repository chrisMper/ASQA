package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MotorolaPage;
import pages.BaseUrl;
import pages.HomePage;
import pages.MobilePage;
import pages.SearchPage;
import utilities.ExcelUtilities;
import utilities.PriceFilterDataProvider;
import utilities.TestNGUtilities;

public class searchTest extends TestNGUtilities {

    @Test
    public void searchMobilePhones() throws InterruptedException {
        BaseUrl url = PageFactory.initElements(browserFactory.getDriver(), BaseUrl.class);
        HomePage home = url.loadUrl("https://singhagiri.lk/");
        Thread.sleep(1000);
        home.moveToElement();
        Thread.sleep(1000);
        MobilePage mobile = home.clickOnMobile();
        Thread.sleep(1000);
        MotorolaPage motorola = home.clickOnMotorola();
        Thread.sleep(1000);
        url.scrollPage(0, 400);
        mobile.selectAvailability();
        Thread.sleep(1000);
        url.scrollPage(0, 400);
        Thread.sleep(1000);
    }

    @Test(dataProvider = "priceRanges", dataProviderClass = PriceFilterDataProvider.class)
    public void searchMotorola(String item) throws InterruptedException {
        BaseUrl url = PageFactory.initElements(browserFactory.getDriver(), BaseUrl.class);
        HomePage home = url.loadUrl("https://singhagiri.lk/");
        Thread.sleep(1000);
        home.searchItem(item);
        Thread.sleep(2000);
    }
    @Test
    public void searchItems() throws InterruptedException {
        BaseUrl url = PageFactory.initElements(browserFactory.getDriver(), BaseUrl.class);
        HomePage home = url.loadUrl("https://singhagiri.lk/");
        Thread.sleep(1000);
        SearchPage search = home.clickOnSearch();
        Thread.sleep(1000);
        search.searchItem("SAMSUNG MOBILE(GALAXY A06 6+128GB, BLACK");
        Thread.sleep(1000);
        url.scrollPage(0, 200);
        search.addCart();
        Thread.sleep(2000);
        search.okCart();
        Thread.sleep(2000);
        search.cart();
        Thread.sleep(2000);
        url.scrollPage(0, 100);
        search.placeOrder();
        Thread.sleep(2000);
        search.continueGuest();
        Thread.sleep(2000);
    }
}
