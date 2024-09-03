package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InStockProduct extends PageObject {
    public InStockProduct(WebElement searchContext) {
        super(searchContext);
    }

    private WebElement titleElement = SearchContext.findElement(By.cssSelector("h2.woocommerce-loop-product__title"));
    private WebElement priceElement = SearchContext.findElement(By.cssSelector(".price"));
    private WebElement buttonElement = SearchContext.findElement(By.cssSelector(".product_type_simple"));
    private WebElement pictureElement = SearchContext.findElement(By.cssSelector(".attachment-woocommerce_thumbnail.size-woocommerce_thumbnail"));

    public String getTitle() {
        return titleElement.getText();
    }

    public void clickOnButton() {
        buttonElement.click();

    }

    public void clickOnViewCartButton() {
        WebElement viewCartButton = SearchContext.findElement(By.cssSelector(".added_to_cart.wc-forward"));
        viewCartButton.click();
    }
}
