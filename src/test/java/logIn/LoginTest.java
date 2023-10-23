package logIn;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import conf.BaseTest;

public class LoginTest extends BaseTest{

    protected final String usernameExist = "user00000";
    protected final String passwordExist = "user00000";

    @Test(description = "Login with valid credentials")
    public void testLoginWithValidCredentials() throws InterruptedException {
        HomePage homePage = new HomePage(webDriver);
        homePage.clickOnLoginOption();
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginContainerIsDisplayed();
        loginPage.loginAs(usernameExist, passwordExist);
        loginPage.clickOnLoginButton();
        Thread.sleep(2000);
        Assert.assertEquals(homePage.getNameOfUser().getText(), "Welcome " + usernameExist);
    }
}
