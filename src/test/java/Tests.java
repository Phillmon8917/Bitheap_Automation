import drivers.DriverSingleton;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.Constants;
import utils.FrameworkProperties;
import static org.junit.jupiter.api.Assertions.assertEquals;

//This is an example of junit
class Tests {
    static FrameworkProperties frameworkProperties;
    static WebDriver driver;
    static HomePage homePage;
    static SignInPage signInPage;
    static CartPage cartPage;
    static CheckoutPage checkoutPage;
    static ShopPage shopPage;

    @BeforeAll
    public static void initializeObjects(){
        frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty(Constants.BROWSER));
        driver = DriverSingleton.getDriver();
        homePage = new HomePage();
        signInPage =  new SignInPage();
        checkoutPage = new CheckoutPage();
        shopPage = new ShopPage();
        cartPage = new CartPage();
    }

    @Test
    public void testingAuthentication(){
        driver.get(Constants.URL);
        homePage.clickRejectCookiesButton();
        homePage.clickSignInButton();
        signInPage.signIn(frameworkProperties.getProperty(Constants.EMAIL),
                frameworkProperties.getProperty(Constants.PASSWORD));
        assertEquals(frameworkProperties.getProperty(Constants.USERNAME).trim(), homePage.getUsername().trim());
    }

    @Test
    public void testingIncorrectAuthenticationErrorMessage(){
        driver.get(Constants.URL);
        homePage.clickRejectCookiesButton();
        homePage.clickSignInButton();
        signInPage.signInWithIncorrectPassword(frameworkProperties.getProperty(Constants.EMAIL),
                frameworkProperties.getProperty(Constants.PASSWORD));
        assertEquals(frameworkProperties.getProperty(Constants.ERROR_MESSAGE).trim(),
                signInPage.getErrorMessage().trim());
    }

    @Test
    public void addElementsToCart(){
        driver.get(Constants.URL);
        homePage.clickRejectCookiesButton();
        homePage.clickShopButton();
        shopPage.goToThirdPage();
        shopPage.addElementToCart();
        assertEquals(Constants.CART_QUANTITY, shopPage.getNumberOfProducts());
    }

    @Test
    public void testingFullBuyingProcess(){
        driver.get(Constants.URL);
        homePage.clickRejectCookiesButton();
        homePage.clickShopButton();
        shopPage.goToThirdPage();
        shopPage.addElementToCart();
        shopPage.proceedToChekout();
        cartPage.proceedToCheckout();
        checkoutPage.provideBillingDetails();
        //checkoutPage.providePersonalDetails. => This method was removed because it contained personal stuff
        assertEquals(frameworkProperties.getProperty(Constants.CHECKOUT_PAGE_TITLE),
                checkoutPage.getPageTitle());
    }

    @AfterAll
    public static void closeObjects(){
        driver.quit();
    }


}
