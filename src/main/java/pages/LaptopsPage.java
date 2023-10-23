package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaptopsPage extends BasePage{

    protected final By item = By.xpath("//a[contains(text(), 'MacBook air')]");

    public LaptopsPage(WebDriver driver){
        super(driver);
    }

    public void selectItem() {
        presenceOfElementLocated(item, 30);
        driver.findElement(item).click();
    }
}
