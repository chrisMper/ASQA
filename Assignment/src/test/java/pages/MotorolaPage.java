package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;


public class MotorolaPage extends BaseUrl{

    public MotorolaPage(WebDriver driver) {
        super(driver);
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
