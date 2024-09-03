package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OutOfStockProduct extends InStockProduct {

    private WebElement discountPrice = SearchContext.findElement(By.cssSelector("span.price:not(:has(>del)), span.price ins"));
    private WebElement saleIcon = SearchContext.findElement(By.cssSelector(".onsale"));

    public OutOfStockProduct(WebElement searchContext) {
        super(searchContext);
    }
}
