package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    protected final By laptopsOption = By.xpath("//a[contains(text(), 'Laptops')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnLaptopsOption() {
        driver.findElement(laptopsOption).click();
    }

    public boolean categoriesAreDisplayed() {
        return driver.findElement(laptopsOption).isDisplayed();
    }
}
