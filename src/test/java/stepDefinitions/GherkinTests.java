package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class GherkinTests {
    protected WebDriver driver;
    protected Homepage homepage;
    protected Cart cart;
    protected ReadMorePage readMorePage;
    protected CheckOutPage checkOutPage;
    protected OrderReceivedPage orderReceivedPage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("Bellatrix homepage is loaded successfully")
    public void bellatrix_homepage_is_loaded_successfully() {
        driver.get("https://demos.bellatrix.solutions/");
        homepage = new Homepage(driver);
    }

    @When("The user clicks on {string} product`s button")
    public void theUserClicksOnProductSButton(String productName) throws InterruptedException {
        homepage.getProductByName(productName).clickOnButton();
    }

    @When("The user selects Sort by price:high to low from sorting menu")
    public void theUserSelectsSortByPriceHighToLowFromSortingMenu() {
        homepage.selectDropdownOptions("Sort by price: high to low");
    }

    @And("The user clicks on {string} from navigation menu")
    public void theUserClicksOnFromNavigationMenu(String navigationMenu) throws InterruptedException {
        Thread.sleep(2000);
        homepage.getHeader().getMenuByName(navigationMenu).clickOnMenu();
        cart = new Cart(driver);
    }

    @And("The user clicks on Checkout button")
    public void theUserClicksOnCheckoutButton() {
        cart = new Cart(driver);
        cart.clickOnProceedToCheckoutButton();
    }

    @And("The user populates <field> with <value>")
    public void theUserPopulatesFieldWithValue(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);

        String firstName = data.get("firstName");
        String lastName = data.get("lastName");
        String address = data.get("address");
        String town = data.get("town");
        String zip = data.get("zip");
        String phoneNumber = data.get("phoneNumber");
        String emailAddress = data.get("emailAddress");
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.fillCheckoutPage(firstName, lastName, address, town, zip, phoneNumber, emailAddress);

    }

    @And("The user clicks on Place order button")
    public void theUserClicksOnPlaceOrderButton() throws InterruptedException {
        Thread.sleep(10000);
        checkOutPage.clickOnPlaceOrderButton();
    }

    @And("The user clicks on X button")
    public void theUserClicksOnXButton() {
        cart = new Cart(driver);
        cart.clickOnDeleteButton();
    }

    @And("The user clicks on View cart button")
    public void theUserClicksOnViewCartButton() throws InterruptedException {
        Thread.sleep(2000);
        homepage.getProductByName("Falcon 9").clickOnViewCartButton();
    }

    @Then("Cart menu should be loaded successfully")
    public void cartMenuShouldBeLoadedSuccessfully() {
        cart = new Cart(driver);
        cart.verifyThatElementIsAddedSuccessfully();
    }

    @Then("The Product is added successfully to cart")
    public void theProductIsAddedSuccessfullyToCart() {
        cart.verifyThatElementIsAddedSuccessfully();
    }

    @Then("Button is working as expected")
    public void buttonIsWorkingAsExpected() {
        readMorePage = new ReadMorePage(driver);
        readMorePage.verifyThatButtonIsClickedSuccessfully("Proton-M", "Read more button is not working correctly!");
    }

    @Then("Order is received successfully")
    public void orderIsReceivedSuccessfully() {
        orderReceivedPage = new OrderReceivedPage(driver);
        orderReceivedPage.verifyThatOrderIsReceivedSuccessfully("Thank you. Your order has been received.", "Order is not received.");
    }

    @Then("The product should be successfully deleted")
    public void theProductShouldBeSuccessfullyDeleted() throws InterruptedException {
        Thread.sleep(2000);
        cart.successfullyDeletedItem();
    }

    @Then("Products should be sorted correctly")
    public void productsShouldBeSortedCorrectly() {
        homepage.verifyThatRocketsAreSuccessfullySorted();
    }

    @When("The user clicks on <rocketName> product`s button")
    public void theUserClicksOnRocketNameProductSButton(String nameOfRocket) {
        homepage.getProductByName(nameOfRocket).clickOnButton();
    }
}
