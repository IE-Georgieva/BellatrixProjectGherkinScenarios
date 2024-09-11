package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OutOfStockProduct extends BaseProduct {

 public OutOfStockProduct(WebElement searchContext) {
        super(searchContext);
    }

    private WebElement readMoreButton = SearchContext.findElement(By.cssSelector(".product_type_simple"));

}
