package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObject.HeaderElement;
import pageObject.PageObject;

import java.util.ArrayList;
import java.util.List;

public class Header extends PageObject {
    private List<WebElement> navigationMenuButtons = SearchContext.findElements(By.cssSelector("ul.nav-menu li"));
    private List<HeaderElement> headerElements;

    public Header(WebElement SearchContext) {
        super(SearchContext);
    }

    public List<HeaderElement> getAllMenus() {
        if (headerElements == null) {
            setMenus();
        }
        return headerElements;

    }

    public void setMenus() {
        List<HeaderElement> resultMenus = new ArrayList<>();
        for (WebElement menuElement : navigationMenuButtons) {
            HeaderElement tempMenu = new HeaderElement(menuElement);
            resultMenus.add(tempMenu);
        }

        headerElements = resultMenus;
    }

    public HeaderElement getMenuByName(String menuName) {
        HeaderElement resultMenu = null;
        List<HeaderElement> allMenus = getAllMenus();
        for (HeaderElement menu : allMenus) {
            if (menu.getMenuTitle().equals(menuName)) {
                resultMenu = menu;
                break;
            }
        }
        return resultMenu;
    }
}

