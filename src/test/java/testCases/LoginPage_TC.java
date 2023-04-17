package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.CommonMethods;

public class LoginPage_TC extends CommonMethods {

    @BeforeClass
    public void SetUp() throws InterruptedException {
        getDriver();
        homePage.continueBtn.click();
    }

    @DataProvider
    public Object[][] invalidUsernamesAndPasswords() {
        return new Object[][]{
                new Object[]{"", ""},   //001
                new Object[]{"", getProperty("validPassword")},	//002
                new Object[]{getProperty("validUsername"), ""}, //003
                new Object[]{getProperty("invalidUsername"), getProperty("validPassword")},  //004
                new Object[]{getProperty("validUsername"), getProperty("invalidPassword")},	 //005
                new Object[]{getProperty("invalidUsername"), getProperty("invalidPassword")},//006
                new Object[]{getProperty("caseChangedValidUsername"), getProperty("caseChangedValidPassword")},//006
        };
    }

    @DataProvider
    public Object[][] validUsernameAndPassword() {
        return new Object[][]{
                new Object[]{getProperty("validUsername"), getProperty("validPassword")},	 //007
        };
    }

    @Test(dataProvider = "invalidUsernamesAndPasswords")
    public void VerifyLoginFailed(String username, String password) throws InterruptedException {
        accountPage.loginToMyAccount(username, password);
        Assert.assertTrue(accountPage.alertMsg.isDisplayed());
        System.out.println(accountPage.alertMsg);
    }

    @Test(dataProvider = "validUsernameAndPassword")
    public void VerifyLoginSuccess(String username, String password) throws InterruptedException {
        accountPage.loginToMyAccount(username, password);
    }


    @AfterClass
    public void TearDown() {
        tearDown();
    }

}
