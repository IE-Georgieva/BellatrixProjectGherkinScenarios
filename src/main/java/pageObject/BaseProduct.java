package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BaseProduct extends PageObject {
    public BaseProduct(WebElement searchContext) {
        super(searchContext);
    }

    private WebElement pictureElement = SearchContext.findElement(By.cssSelector(".attachment-woocommerce_thumbnail.size-woocommerce_thumbnail"));
    private WebElement titleElement = SearchContext.findElement(By.cssSelector("h2.woocommerce-loop-product__title"));
    private WebElement priceElement = SearchContext.findElement(By.cssSelector(".price"));

    public String getTitle() {
        return titleElement.getText();
    }

}
