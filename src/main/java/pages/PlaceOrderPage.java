package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrderPage extends BasePage{

    protected final By orderModal = By.id("orderModal");
    protected final By name = By.id("name");
    protected final By country = By.id("country");
    protected final By city = By.id("city");
    protected final By creditCard = By.id("card");
    protected final By month = By.id("month");
    protected final By year = By.id("year");
    protected final By purchaseButton = By.xpath("//button[contains(text(), 'Purchase')]");
    protected final By[] elements = {name, country, city, creditCard, month, year};

    public PlaceOrderPage(WebDriver driver) {
        super(driver);
    }

    public void completePlaceOrder(String values[]) {
        visibilityOfElement(orderModal, 30);
        for (int i = 0; i < elements.length; i++) {
            driver.findElement(elements[i]).sendKeys(values[i]);
        }
    }

    public void clickOnPurchaseButton() {
        driver.findElement(purchaseButton).click();
    }

}
