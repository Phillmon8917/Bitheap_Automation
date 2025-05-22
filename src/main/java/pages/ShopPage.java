package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.time.Duration;

public class ShopPage {
    private WebDriver driver;

    @FindBy(css = "#main > ul > li.product.type-product.post-840.status-publish.instock.product_cat-tech-course.product_tag-chatgpt.product_tag-course.product_tag-mobile-app-development.product_tag-nodejs.product_tag-react-native.has-post-thumbnail.sale.downloadable.virtual.purchasable.product-type-simple > a.button.product_type_simple.add_to_cart_button.ajax_add_to_cart")
    private WebElement addToCartButton;

    @FindBy(css = "body > nav > div.wb4wp-wrapper > div.wb4wp-right > div > a > span")
    private WebElement numberOfProducts;

    @FindBy(css = "body > nav > div.wb4wp-wrapper > div.wb4wp-right > div > a > i")
    private WebElement cartButton;

    @FindBy(css = "#main > nav > ul > li:nth-child(3) > a")
    private WebElement thirdPage;

    public ShopPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void addElementToCart() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", addToCartButton);

        for (int i = 0; i < 1000; i++) {
            if (numberOfProducts.getText().contains(Constants.CART_QUANTITY)) {
                return;
            } else {
                System.out.println("  ");;
            }
        }
    }

    public void goToThirdPage(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", thirdPage);
    }

    public void proceedToChekout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));

        cartButton.click();
    }

    public String getNumberOfProducts(){
        return numberOfProducts.getText();
    }
}
