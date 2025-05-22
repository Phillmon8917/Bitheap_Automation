package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    @FindBy(css = "#menu-item-2330 > a")
    private WebElement signInButton;

    @FindBy(id = "menu-item-1310")
    private WebElement shoppingButton;

    @FindBy(css = "#menu-item-2333 > a")
    private WebElement username;

    @FindBy(css = "body > div.cky-consent-container.cky-box-bottom-left")
    private WebElement cookiesPopup;

    @FindBy(css = "body > div.cky-consent-container.cky-box-bottom-left > div > div > div > div.cky-notice-btn-wrapper > button.cky-btn.cky-btn-reject")
    private WebElement rejectCookiesButton;

    public HomePage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickSignInButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

    public void clickShopButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(shoppingButton));
        shoppingButton.click();
    }

    public void clickRejectCookiesButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(cookiesPopup));
        wait.until(ExpectedConditions.visibilityOf(rejectCookiesButton));
        rejectCookiesButton.click();
    }

    public String getUsername(){
        return username.getText();
    }
}
