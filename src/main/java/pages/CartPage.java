package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.conf.BasePage;

public class CartPage extends BasePage {

    protected final By productName = By.xpath("//tr/td[contains(text(), 'MacBook air')]");
    protected final By totalPrice = By.id("totalp");
    protected final By placeOrderButton = By.className("btn-success");

    public CartPage(WebDriver driver){
        super(driver);
    }

    public String getProductName() {
        presenceOfElementLocated(productName, 30);
        return driver.findElement(productName).getText();
    }

    public String getTotalPrice() {
        return driver.findElement(totalPrice).getText();
    }

    public void clickOnPlaceOrderButton() {
        driver.findElement(placeOrderButton).click();
    }
}
