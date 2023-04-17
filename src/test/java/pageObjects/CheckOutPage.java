package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseClass;
import utilities.CommonMethods;

import java.util.List;

public class CheckOutPage extends CommonMethods {

    public CheckOutPage() {
        PageFactory.initElements(BaseClass.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@id='logo']//a[1]/img)[1]")
    public List<WebElement> orderNameList;

    @FindBy(xpath = "//div[@class='_1ip0g651 _1fragem1g _1fragemcx _1fragem24 _1fragem2k _1fragem3n']")
    public List<WebElement> orderPriceList;

    @FindBy(xpath = "//input[@placeholder='Gift card or discount code']")
    public WebElement inputDiscountCode;

    @FindBy(xpath = "//button[@aria-label='Apply Discount Code']")
    public WebElement applyBtn;

    @FindBy(xpath = "//span[@class='i8os0m4'][1]")
    public WebElement love10Tag;

    @FindBy(xpath = "//p[@id='error-for-TextField0']")
    public WebElement invalidCodeAlert;

    @FindBy(xpath = "(//div[@class='_1qy6ue6a']/span)[1]")
    public WebElement subtotalAmount;

    @FindBy(xpath = "(//div[@class='_1qy6ue6a']/span)[2]")
    public WebElement discountAmount;

    @FindBy(xpath = "(//div[@class='_1qy6ue6a']/span)[3]")
    public WebElement  shippingAmount;

    @FindBy(xpath = "//div[@class='_1x41w3pa']//strong")
    public WebElement totalAmount;





}
