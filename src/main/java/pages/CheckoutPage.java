package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;

    @FindBy(id = "billing_first_name")
    private WebElement firstname;

    @FindBy(id = "billing_last_name")
    private WebElement lastname;

    @FindBy(id = "billing_address_1")
    private WebElement address;

    @FindBy(id = "billing_postcode")
    private WebElement zipcode;

    @FindBy(id = "billing_city")
    private WebElement townname;

    @FindBy(id = "billing_email")
    private WebElement email;

    @FindBy(css = "#order_review > table > tfoot > tr.order-total > td > strong > span")
    private WebElement totalAmount;

    @FindBy(css = "#post-207 > header > h1")
    private WebElement orderStatus;

    @FindBy(id = "place_order")
    private WebElement placeorder;

    @FindBy(id = "select2-billing_country-container")
    private WebElement countryDropdown;

    @FindBy(className = "select2-search__field")
    private WebElement countryDropdownSearchBox;

    @FindBy(css = "#post-207 > header > h1")
    private WebElement pageTitle;

    public CheckoutPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void provideBillingDetails(){
        //Ie I can do this for others as well
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(firstname));
        firstname.clear();
        firstname.sendKeys("Phillmon");

        wait.until(ExpectedConditions.visibilityOf(lastname));
        lastname.clear();
        lastname.sendKeys("Motsinoni");

        wait.until(ExpectedConditions.visibilityOf(countryDropdown));
        countryDropdown.click();
        countryDropdownSearchBox.sendKeys("South Africa");
        wait.until(ExpectedConditions.visibilityOf(countryDropdown));
        countryDropdownSearchBox.sendKeys(Keys.ENTER);


        wait.until(ExpectedConditions.visibilityOf(address));
        address.clear();
        address.sendKeys("35 Georgia Crescent");

        wait.until(ExpectedConditions.visibilityOf(zipcode));
        zipcode.clear();
        zipcode.sendKeys("2188");

        wait.until(ExpectedConditions.visibilityOf(townname));
        townname.clear();
        townname.sendKeys("Randburg");

        wait.until(ExpectedConditions.visibilityOf(email));
        email.clear();
        email.sendKeys("Motsinoni.p955@gmail.com");

    }

    public String getTotalAmout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(totalAmount));
        return totalAmount.getText();
    }

    public void placeOrder(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(placeorder));
        placeorder.click();
    }

    public String getPageTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText();
    }
}
