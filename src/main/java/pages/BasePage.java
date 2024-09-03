package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver webDriver;

    public BasePage(WebDriver driver) {
        this.webDriver = driver;
    }
}
