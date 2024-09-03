package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ReadMorePage extends CommonPage {
    private WebElement productTitle = webDriver.findElement(By.cssSelector(".product_title.entry-title"));

    public ReadMorePage(WebDriver driver) {
        super(driver);
    }

    public void verifyThatButtonIsClickedSuccessfully(String expectedText, String messageOnFailure) {
        String actualText = productTitle.getText();
        Assert.assertTrue(actualText.contains(expectedText), messageOnFailure);
    }
}
