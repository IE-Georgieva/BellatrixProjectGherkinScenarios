package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonPage extends BasePage {
    private WebElement header = webDriver.findElement(By.cssSelector("div.storefront-primary-navigation"));

    public CommonPage(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return new Header(header);

    }

    protected WebDriverWait webDriverWait;

    public void performWait() {
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }
}
