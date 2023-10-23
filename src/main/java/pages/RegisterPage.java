package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.conf.BasePage;

public class RegisterPage extends BasePage {
    protected final By usernameInput = By.id("sign-username");
    protected final By passInput = By.id("sign-password");
    protected final By signUpContainer = By.id("signInModal");
    protected final By signUpButton = By.xpath("//button[contains(@onclick, 'register()')]");


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void addUser(String username, String password) {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passInput).sendKeys(password);
    }

    public void signUpContainerIsDisplayed(){
        visibilityOfElement(signUpContainer, 30);
    }

    public void clickOnSignUpButton(){
        driver.findElement(signUpButton).click();
    }

    public void clickOnAcceptAlert(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}
