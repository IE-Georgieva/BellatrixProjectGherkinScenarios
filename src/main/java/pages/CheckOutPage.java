package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage extends CommonPage {

    private WebElement firstName = webDriver.findElement(By.cssSelector("#billing_first_name"));
    private WebElement lastName = webDriver.findElement(By.cssSelector("#billing_last_name"));
    private WebElement streetAddress = webDriver.findElement(By.cssSelector("input[id=billing_address_1]"));
    private WebElement city = webDriver.findElement(By.cssSelector("input[id=billing_city]"));
    private WebElement postcode = webDriver.findElement(By.cssSelector("input[id=billing_postcode]"));
    private WebElement phone = webDriver.findElement(By.cssSelector("input[id=billing_phone]"));
    private WebElement email = webDriver.findElement(By.cssSelector("input[id=billing_email]"));

    public CheckOutPage(WebDriver driver) {
        super(driver);
        loadingIndicator();
    }

    public void fillCheckoutPage(String first, String last, String address, String town, String zip, String phoneNumber, String emailAddress) {
        WebDriverWait webDriverWait;
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(first);
        lastName.sendKeys(last);
        streetAddress.sendKeys(address);
        city.sendKeys(town);
        postcode.sendKeys(zip);
        phone.sendKeys(phoneNumber);
        email.sendKeys(emailAddress);
    }

    public void clickOnPlaceOrderButton() {
        Actions actions = new Actions(webDriver);
        WebElement element = webDriver.findElement(By.cssSelector("div.form-row"));
        actions.moveToElement(element).moveByOffset(0, -25).click().perform();
    }

    public void loadingIndicator() {
        performWait();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.blockOverlay")));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.blockOverlay")));
    }
}
