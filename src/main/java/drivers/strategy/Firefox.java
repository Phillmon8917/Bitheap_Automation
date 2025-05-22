package drivers.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy{
    public WebDriver setStrategy(){
        System.setProperty("webdriver.gecko.driver", "src/main/resources/gecko.exe");
        return new FirefoxDriver();
    }
}
