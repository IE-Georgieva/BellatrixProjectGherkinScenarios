package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Cart extends CommonPage {
    private WebElement proceedToCheckout = webDriver.findElement(By.cssSelector(".checkout-button.button.alt.wc-forward"));
    private WebElement deleteButton = webDriver.findElement(By.cssSelector(".remove"));

    public Cart(WebDriver driver) {
        super(driver);
    }

    public void clickOnProceedToCheckoutButton() {
        proceedToCheckout.click();
    }

    public void verifyThatElementIsAddedSuccessfully() {
        Assert.assertTrue(proceedToCheckout.isDisplayed(), "Product is not added to cart!");
    }

    public void clickOnDeleteButton() {
        deleteButton.click();
    }

    public void successfullyDeletedItem() {
        WebElement returnToShop = webDriver.findElement(By.cssSelector(".cart-empty.woocommerce-info"));
        Assert.assertTrue(returnToShop.isDisplayed(), "Product is not deleted from cart!");
    }
}
