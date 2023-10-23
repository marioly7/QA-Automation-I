package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.conf.BasePage;

public class ProductPage extends BasePage {

    protected final By addToCartButton = By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a");
    protected final By productName = By.className("name");
    protected final By productPrice = By.className("price-container");
    protected final By navBarCartOption = By.id("cartur");

    public ProductPage(WebDriver driver){
        super(driver);
    }

    public void clickOnAddToCartButton(){
        visibilityOfElement(addToCartButton, 30);
        driver.findElement(addToCartButton).click();
    }

    public String getProductName(){
        presenceOfElementLocated(productName, 30);
        return driver.findElement(productName).getText();
    }

    public String getProductPrice(){
        visibilityOfElement(productPrice, 30);
        return driver.findElement(productPrice).getText();
    }

    public void clickOnAcceptAlert(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void clickOnNavBarCartOption(){
        driver.findElement(navBarCartOption).click();
    }

}
