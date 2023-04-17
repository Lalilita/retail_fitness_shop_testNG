package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseClass;
import utilities.CommonMethods;

public class AccountPage extends CommonMethods {

    public AccountPage() {
        PageFactory.initElements(BaseClass.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='customer_email']")
    public WebElement inputEmail;

    @FindBy(xpath = "//input[@id='customer_password']")
    public WebElement inputPassword;

    @FindBy(xpath = "(//button[@type='submit' and @class='button button--solid button--regular'])[1]")
    public WebElement loginBtn;

    @FindBy(xpath = "//a[@id='customer_register_link']")
    public WebElement newCustomerSignUp;

    @FindBy(xpath = "//span[@class='alert__icon']")
    public WebElement alertMsg;


    //-----METHOD
    public void loginToMyAccount(String username, String password) {
        homePage.accountBtn.click();
        sendText(inputEmail, username);
        sendText(inputPassword, password);
        loginBtn.click();
    }


}
