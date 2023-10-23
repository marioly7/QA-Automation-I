package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.conf.BasePage;

public class LoginPage extends BasePage {

    protected final By userInput = By.id("loginusername");
    protected final By passWordInput = By.id("loginpassword");
    protected final By loginButton = By.xpath("//button[contains(@onclick, 'logIn()')]");
    protected final By loginContainer = By.id("logInModalLabel");
    protected final By errorAlert = By.id("danger-alert");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void typeUserName(String user) {
        WebElement element = driver.findElement(userInput);
        element.sendKeys(user);
    }


    public void typePassWord(String passWord) {
        WebElement element = driver.findElement(passWordInput);
        element.sendKeys(passWord);
    }

    public void loginContainerIsDisplayed(){
        visibilityOfElement(loginContainer, 30);
    }

    public void clickOnLoginButton() {
        WebElement element = driver.findElement(loginButton);
        element.click();
    }


    public void loginAs(String user, String passWord) {
        typeUserName(user);
        typePassWord(passWord);
        clickOnLoginButton();
    }

}
