package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.CommonMethods;

public class DiscountCodeQuickShop_TC extends CommonMethods {

    private double totalBeforeDiscount = 0;
    private double discountExpected = 0;

    @BeforeClass
    public void SetUp() throws InterruptedException {
        getDriver();
    }

    @DataProvider
    public Object[][] invalidDiscountCode() {
        return new Object[][]{
                new Object[]{getProperty("invalidCode")}
        };
    }

    @DataProvider
    public Object[][] validDiscountCode() {
        return new Object[][]{
                new Object[]{getProperty("validCode")}
        };
    }

    @Test(priority = 1)
    public void DC01_addProductToCheckOutPage() throws InterruptedException {
        waitForVisibility(homePage.continueBtn).click();
        ScrolByPixel(1500);
        //add product to cart
        waitForVisibility(homePage.add7ftOlympicBar700lbsWithCollars).click();
        homePage.sliderBarClose.click();
        ScrolByPixel(230);
        waitForVisibility(homePage.addAmStaffTR057DSquatPressRack).click();
        //on the way to check out page
        waitForVisibility(homePage.agreeCheckBox).click();
        ScrolByPixel(50);
        waitForVisibility(homePage.checkOutBtn).click();
        String destinationActual = driver.getCurrentUrl();
        Assert.assertTrue(destinationActual.contains(getProperty("checkOutPageUrl")));
    }

    @Test(priority = 2)
    public void DC02_verifyTotalBeforeAddingDiscountCode() throws InterruptedException {
        for (int i = 1; i < checkOutPage.orderPriceList.size(); i++) {
            totalBeforeDiscount += getDouble(checkOutPage.orderPriceList.get(i));
        }
        Assert.assertEquals(totalBeforeDiscount, getDouble(checkOutPage.totalAmount));
    }

    @Test(priority = 3, dataProvider = "invalidDiscountCode")
    public void DC03_verifyAlertMsgShowAfterAddingInvalidDiscountCode(String discountCode) throws InterruptedException {
        sendText(checkOutPage.inputDiscountCode, discountCode);
        checkOutPage.applyBtn.click();
        Assert.assertTrue(checkOutPage.invalidCodeAlert.isDisplayed());
    }

    @Test(priority = 4, dataProvider = "validDiscountCode")
    public void DC04_verifyAddingValidDiscountCode(String discountCode) throws InterruptedException {
        sendText(checkOutPage.inputDiscountCode, discountCode);
        checkOutPage.applyBtn.click();
        waitForVisibility(checkOutPage.love10Tag);
        Assert.assertTrue(checkOutPage.love10Tag.isDisplayed());
    }

    @Test(priority = 5)
    public void DC05_verifyDiscountAfterAddingDiscountCode() throws InterruptedException {
        discountExpected = twoDecimalPoint((totalBeforeDiscount * Double.parseDouble(getProperty("discountAmount"))));
        double discountActual = getDouble(checkOutPage.discountAmount);
        Assert.assertEquals(discountExpected, discountActual);
    }

    @Test(priority = 6)
    public void DC06_verifyTotalAfterAddingDiscountCode() throws InterruptedException {
        double totalAfterDiscountExpected = totalBeforeDiscount - discountExpected;
        double totalAfterDiscountActual = getDouble(checkOutPage.totalAmount);
        Assert.assertEquals(totalAfterDiscountExpected, totalAfterDiscountActual);
    }

    @AfterClass
    public void TearDown() {
        tearDown();
    }
}
