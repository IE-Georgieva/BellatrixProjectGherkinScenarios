package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InStockProduct extends BaseProduct {

    private WebElement discountPrice = SearchContext.findElement(By.cssSelector("span.price:not(:has(>del)), span.price ins"));
    private WebElement addToCartButton = SearchContext.findElement(By.cssSelector(".product_type_simple"));

    public InStockProduct(WebElement searchContext) {
        super(searchContext);
    }

    public void clickOnButton() {
        addToCartButton.click();

    }

    public void clickOnViewCartButton() {
        WebElement viewCartButton = SearchContext.findElement(By.cssSelector(".added_to_cart.wc-forward"));
        viewCartButton.click();
    }
}
