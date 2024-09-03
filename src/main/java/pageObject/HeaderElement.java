package pageObject;

import org.openqa.selenium.WebElement;

public class HeaderElement extends PageObject {
    public HeaderElement(WebElement searchContext) {
        super(searchContext);
    }

    public String getMenuTitle() {
        return SearchContext.getText();

    }

    public void clickOnMenu() {
        SearchContext.click();
    }
}
