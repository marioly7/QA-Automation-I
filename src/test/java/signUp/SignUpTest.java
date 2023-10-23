package signUp;

import conf.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class SignUpTest extends BaseTest {

    protected final String usernameExist = "user00000";
    protected final String passwordExist = "user00000";
    protected Integer randomNumber = (int) (Math.random() * 1000);
    protected Integer randomNumber2 = (int) (Math.random() * 1000);
    protected final String newUsername = "user" + randomNumber + "random" + randomNumber2;
    protected final String newPassword = "user0000011122233";

    @Test(description = "Add user with valid credentials")
    public void testAddUserWithValidCredentials() {
        HomePage homePage = new HomePage(webDriver);
        homePage.clickOnSignUpOption();
        RegisterPage registerPage = new RegisterPage(webDriver);
        registerPage.signUpContainerIsDisplayed();
        registerPage.addUser(newUsername,newPassword);
        registerPage.clickOnSignUpButton();
        Assert.assertEquals(registerPage.getTextFromAlert(), "Sign up successful.");
        registerPage.clickOnAcceptAlert();
    }

    @Test(description = "Add user with empty fields")
    public void testAddUserWithEmptyFields(){
        HomePage homePage = new HomePage(webDriver);
        homePage.clickOnSignUpOption();
        RegisterPage registerPage = new RegisterPage(webDriver);
        registerPage.signUpContainerIsDisplayed();
        registerPage.addUser("","");
        registerPage.clickOnSignUpButton();
        Assert.assertEquals(registerPage.getTextFromAlert(), "Please fill out Username and Password.");
        registerPage.clickOnAcceptAlert();
    }

    @Test(description = "Add user with already exist credentials")
    public void testAddUserWithAlreadyExistCredentials(){
        HomePage homePage = new HomePage(webDriver);
        homePage.clickOnSignUpOption();
        RegisterPage registerPage = new RegisterPage(webDriver);
        registerPage.signUpContainerIsDisplayed();
        registerPage.addUser(usernameExist, passwordExist);
        registerPage.clickOnSignUpButton();
        Assert.assertEquals(registerPage.getTextFromAlert(), "This user already exist.");
        registerPage.clickOnAcceptAlert();
    }
}
