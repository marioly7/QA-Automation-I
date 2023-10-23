package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.conf.BasePage;

public class HomePage extends BasePage {

    protected final By laptopsOption = By.xpath("//a[contains(text(), 'Laptops')]");
    protected final By signUpOption = By.id("signin2");
    protected final By loginOption = By.id("login2");
    protected final By nameOfUser = By.id("nameofuser");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnLaptopsOption() {
        driver.findElement(laptopsOption).click();
    }

    public void clickOnSignUpOption(){
        driver.findElement(signUpOption).click();
    }

    public WebElement getNameOfUser(){
        return driver.findElement(nameOfUser);
    }

    public void clickOnLoginOption(){
        driver.findElement(loginOption).click();
    }

    public boolean categoriesAreDisplayed() {
        return driver.findElement(laptopsOption).isDisplayed();
    }
}
