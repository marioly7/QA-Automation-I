package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.conf.BasePage;

public class CompletedOrderPage extends BasePage {

    protected final By successAlert = By.className("showSweetAlert");
    protected final By orderValuesContainer = By.xpath("//div[contains(@class, 'sweet-alert') and contains(@class, 'showSweetAlert') and contains(@class, 'visible')]/p");
    protected final By okButton = By.xpath("//button[contains(text(), 'OK')]");

    public CompletedOrderPage(WebDriver driver) {
        super(driver);
    }

    public boolean succesAlertIsDisplayed(){
        return driver.findElement(successAlert).isDisplayed();
    }

    public String [] getOrderValues(){
        presenceOfElementLocated(orderValuesContainer, 30);
        String[] lineas = driver.findElement(orderValuesContainer).getText().split("\n");
        String totalPrice = null;
        String cardNumber = null;
        String name = null;

        for (String linea : lineas) {
            if (linea.startsWith("Amount:")) {
                totalPrice = linea.replace("Amount:", "").trim();
            } else if (linea.startsWith("Card Number:")) {
                cardNumber = linea.replace("Card Number:", "").trim();
            } else if (linea.startsWith("Name:")) {
                name = linea.replace("Name:", "").trim();
            }
        }

        String [] orderValues = {totalPrice, cardNumber, name};
        return orderValues;
    }

    public void clickOnOkButton(){
        driver.findElement(okButton).click();
    }
}
