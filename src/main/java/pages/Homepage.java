package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObject.InStockProduct;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.AssertJUnit.*;


public class Homepage extends CommonPage {
    private WebElement sortDropdown = webDriver.findElement(By.name("orderby"));
    private List<WebElement> productsElements = webDriver.findElements(By.cssSelector(".product.type-product"));
    private List<InStockProduct> productElement;
    private List<WebElement> priceElements = webDriver.findElements(By.cssSelector("span.price:not(:has(>del)), span.price ins"));

    public Homepage(WebDriver driver) {
        super(driver);
    }

    public List<InStockProduct> getAllProducts() {
        if (productElement == null) {
            setAllProducts();
        }
        return productElement;
    }

    public void setAllProducts() {
        List<InStockProduct> resultProducts = new ArrayList<>();
        for (WebElement productElement : productsElements) {
            InStockProduct tempProduct = new InStockProduct(productElement);
            resultProducts.add(tempProduct);
        }
        productElement = resultProducts;
    }

    public InStockProduct getProductByName(String productName) {
        InStockProduct resultProduct = null;
        List<InStockProduct> allProducts = getAllProducts();
        for (InStockProduct product : allProducts) {
            if (product.getTitle().equals(productName)) {
                resultProduct = product;
                break;
            }
        }
        return resultProduct;
    }

    public void selectDropdownOptions(String optionName) {
        Select sortBy = new Select(sortDropdown);
        assertFalse(sortBy.isMultiple());
        List<WebElement> allMakeOptions = sortBy.getOptions();
        assertEquals(allMakeOptions.size(), 6);
        List<String> actualOptions = new ArrayList<>();
        for (WebElement option : allMakeOptions) {
            actualOptions.add(option.getText());
        }
        sortBy.selectByVisibleText(optionName);
    }

    public void verifyThatRocketsAreSuccessfullySorted() {
        List<WebElement> priceElements = webDriver.findElements(By.cssSelector("span.price:not(:has(>del)), span.price ins"));
        List<Double> prices = new ArrayList<>();
        List<Double> originalPrices = new ArrayList<>();
        List<Double> expectedPrices = originalPrices;
        for (WebElement element : priceElements) {
            String text = element.getText().replaceAll("[^\\d.]", "");
            Double price = Double.parseDouble(text);
            prices.add(price);
            originalPrices.add(price);
        }

        for (int i = 0; i < originalPrices.size() - 1; i++) {
            var tempOriginalPrice= prices.get(i);
            var tempExpectedPrice =expectedPrices.get(i);
            assertTrue(tempOriginalPrice.equals(tempExpectedPrice));
        }

    }

}

