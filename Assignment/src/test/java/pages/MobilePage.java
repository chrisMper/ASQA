package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobilePage extends BaseUrl{
    public MobilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"block-availability\"]/div")
    public WebElement availability;

    public void selectAvailability(){
        availability.click();
    }
}
