package pageObject;

import org.openqa.selenium.WebElement;

public abstract class PageObject {

    protected WebElement SearchContext;

    public PageObject(WebElement searchContext) {
        SearchContext = searchContext;
    }
}
