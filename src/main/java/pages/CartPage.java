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

public class CartPage {
    private WebDriver driver;
    @FindBy(css = "#post-206 > content > div > div.woocommerce > div.cart-collaterals > div > div > a")
    private WebElement proceedToCheckout;

    public CartPage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void proceedToCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout));
        proceedToCheckout.click();
    }
}
