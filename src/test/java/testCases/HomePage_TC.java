package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.CommonMethods;

public class HomePage_TC extends CommonMethods {

    @BeforeClass
    public void SetUp() throws InterruptedException {
        getDriver();
    }

    @Test(priority = 1)
    public void verifyLogoIsDisplayInCorrectFile() throws InterruptedException {
        waitForVisibility(homePage.logo);
        Assert.assertTrue(homePage.logo.isDisplayed());
        String logoSourceExpected = getProperty("logoImage");
        String logoSourceActual = homePage.logo.getAttribute("src");
        Assert.assertEquals(logoSourceActual,logoSourceExpected);
    }

    @Test(priority = 2)
    public void verifyAnnouncementIsDisplayInCorrectText() throws InterruptedException {
        waitForVisibility(homePage.topAnnouncement);
        Assert.assertTrue(homePage.topAnnouncement.isDisplayed());
        String announcmentTextExpected = getProperty("announcementText");
        String announcmentTextActual = homePage.topAnnouncement.getText();
        Assert.assertEquals(announcmentTextActual, announcmentTextExpected);
    }

    @Test(priority = 3)
    public void verifyLanguageBtnIsDisplayedAsEnglish() throws InterruptedException {
        waitForVisibility(homePage.languageBtn);
        Assert.assertTrue(homePage.languageBtn.isDisplayed());
        String languageBtnTextExpected = getProperty("languageBtnText");
        String languageBtnTextActual = (homePage.languageBtn.getText()).trim();
        Assert.assertEquals(languageBtnTextActual, languageBtnTextExpected);
    }

    @Test(priority = 4)
    public void verifyCurrencyBtnIsDisplayedAsCAD() throws InterruptedException {
        waitForVisibility(homePage.currencyBtn);
        Assert.assertTrue(homePage.currencyBtn.isDisplayed());
        String currencyBtnTextExpected = getProperty("currencyBtnText");
        String currencyBtnTextActual = (homePage.currencyBtn.getText()).trim();
        Assert.assertEquals(currencyBtnTextActual, currencyBtnTextExpected);
    }

    @Test(priority = 5)
    public void verifySearchBoxDisplayed() throws InterruptedException {
        waitForVisibility(homePage.searchForm);
        Assert.assertTrue(homePage.searchForm.isDisplayed());
        System.out.println("pass");
    }

    @Test(priority = 6)
    public void verifyCartBtnDisplayed() throws InterruptedException {
        waitForVisibility(homePage.cartBtn);
        Assert.assertTrue(homePage.cartBtn.isDisplayed());
    }

    @Test(priority = 7)
    public void verifyNavBarDisplayed() throws InterruptedException {
        for(int i = 1; i < homePage.navBar.size(); i++) {
            Assert.assertTrue(homePage.navBar.get(i).isDisplayed());
        }
    }

    @AfterClass
    public void TearDown() {
        tearDown();
    }

}
