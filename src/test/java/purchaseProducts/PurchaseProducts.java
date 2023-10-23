package purchaseProducts;

import basePage.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class PurchaseProducts extends BaseTest {

    protected final String[] expectedOrderValues = {"Marioly Vargas", "España", "Barcelona", "48392732332", "Septiembre", "2022"};

    @Test
    public void purchaseProducts() {

        String expectedProductName = "MacBook air";
        String expectedProductPrice = "700";

        HomePage homePage = new HomePage(webDriver);
        homePage.clickOnLaptopsOption();

        LaptopsPage laptopsPage = new LaptopsPage(webDriver);
        laptopsPage.selectItem();

        ProductPage productPage = new ProductPage(webDriver);
        Assert.assertEquals(productPage.getProductName(), expectedProductName);
        Assert.assertEquals(productPage.getProductPrice(), "$" + expectedProductPrice + " *includes tax");

        productPage.clickOnAddToCartButton();
        productPage.clickOnAcceptAlert();
        productPage.clickOnNavBarCartOption();

        CartPage cartPage = new CartPage(webDriver);
        Assert.assertEquals(cartPage.getProductName(), expectedProductName);
        Assert.assertEquals(cartPage.getTotalPrice(), expectedProductPrice);

        cartPage.clickOnPlaceOrderButton();

        PlaceOrderPage placeOrderPage = new PlaceOrderPage(webDriver);
        placeOrderPage.completePlaceOrder(expectedOrderValues);
        placeOrderPage.clickOnPurchaseButton();

        CompletedOrderPage completedOrderPage = new CompletedOrderPage(webDriver);
        completedOrderPage.succesAlertIsDisplayed();

        Assert.assertTrue(completedOrderPage.succesAlertIsDisplayed());
        Assert.assertEquals(completedOrderPage.getOrderValues()[0], expectedProductPrice+" USD");
        Assert.assertEquals(completedOrderPage.getOrderValues()[1], expectedOrderValues[3]);
        Assert.assertEquals(completedOrderPage.getOrderValues()[2], expectedOrderValues[0]);

        completedOrderPage.clickOnOkButton();

        Assert.assertTrue(homePage.categoriesAreDisplayed());
    }
}
