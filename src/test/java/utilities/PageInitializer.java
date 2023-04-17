package utilities;

import pageObjects.AccountPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;

public class PageInitializer extends BaseClass {

    public static HomePage homePage;
    public static AccountPage accountPage;
    public static CheckOutPage checkOutPage;

    public static void initialize() {
        homePage = new HomePage();
        accountPage = new AccountPage();
        checkOutPage = new CheckOutPage();

    }
}