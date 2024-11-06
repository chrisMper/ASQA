package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class HomePage extends BaseUrl{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(driver);

    @FindBy(xpath = "//*[@id=\"block-mainnavigation\"]/div/nav/div/ul/li[1]/a")
    public WebElement category;

    @FindBy(xpath = "//*[@id=\"block-mainnavigation\"]/div/nav/div/ul/li[1]/div/div/div/div/ul/li[4]/a")
    public WebElement mobilePhones;

    @FindBy(xpath = "//*[@id=\"block-brands\"]/div/ul/li[3]")
    public WebElement motorola;

    @FindBy(xpath = "//*[@id=\"edit-search\"]")
    public WebElement search;

    public void moveToElement(){
        actions.moveToElement(category).perform();
    }

    public MobilePage clickOnMobile(){
        mobilePhones.click();
        return PageFactory.initElements(driver, MobilePage.class);
    }

    public MotorolaPage clickOnMotorola(){
        motorola.click();
        return PageFactory.initElements(driver, MotorolaPage.class);
    }

    public SearchPage clickOnSearch(){
        search.click();
        return PageFactory.initElements(driver, SearchPage.class);
    }

    @FindBy(xpath = "//*[@id=\"edit-search\"]")
    public WebElement searchBox;

    public void searchItem(String item) {
        searchBox.sendKeys(item);
        searchBox.submit();

        String productTitlesXPath = "//*[@id=\"popularity\"]/div/div/div/div[3]/h6[2]/a";

        // Wait until the search results are loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Find all product title elements
        List<WebElement> productElements = driver.findElements(By.xpath(productTitlesXPath));

        // Check if at least one product title contains the search term
        boolean termFound = false;
        for (WebElement productElement : productElements) {
            String titleText = productElement.getText();
            System.out.println("Product Title: " + titleText);
            if (titleText.toLowerCase().contains(item.toLowerCase())) {
                termFound = true;
                break;
            }
        }
    }
}
