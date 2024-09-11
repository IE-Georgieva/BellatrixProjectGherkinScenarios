package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public BasePage(WebDriver driver) {
        this.webDriver = driver;
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }
}
