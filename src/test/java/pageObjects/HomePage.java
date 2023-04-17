package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseClass;
import utilities.CommonMethods;

import java.util.List;

public class HomePage extends CommonMethods {

    public HomePage() {
        PageFactory.initElements(BaseClass.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@id='logo']//a[1]/img)[1]")
    public WebElement logo;

    @FindBy(xpath = "(//span[@class='announcement'])/a")
    public WebElement topAnnouncement;

    @FindBy(xpath = "(//button[@class='localization-form__item-button'])[1]")
    public WebElement languageBtn;

    @FindBy(xpath = "(//button[@class='localization-form__item-button'])[2]")
    public WebElement currencyBtn;

    @FindBy(xpath = "(//*[@data-resource-type='product,collection'])[1]")
    public WebElement searchForm;

    @FindBy(xpath = "(//a[@class='button button--outline button--icon'])[1]")
    public WebElement accountBtn;

    @FindBy(xpath = "(//a[@class='button button--solid button--icon no-js-hidden'])[1]")
    public WebElement cartBtn;

    @FindBy(xpath = "(//span[@class='text-animation--underline-in-header'])[0]")
    public List<WebElement> navBar;

    @FindBy(xpath = "(//span[@class='text-animation--underline-in-header'])[1]")
    public WebElement shopBtn;

    @FindBy(xpath = "(//span[@class='text-animation--underline-in-header'])[2]")
    public WebElement weightsBtn;

    @FindBy(xpath = "(//span[@class='text-animation--underline-in-header'])[3]")
    public WebElement barbellsBtn;

    @FindBy(xpath = "(//span[@class='text-animation--underline-in-header'])[4]")
    public WebElement rackCagesBtn;

    @FindBy(xpath = "(//span[@class='text-animation--underline-in-header'])[5]")
    public WebElement flooringBtn;

    @FindBy(xpath = "(//span[@class='text-animation--underline-in-header'])[6]")
    public WebElement mmaBtn;

    @FindBy(xpath = "(//span[@class='text-animation--underline-in-header'])[7]")
    public WebElement giftCardsBtn;

    @FindBy(xpath = "(//span[@class='header-info-block__caption text-size--xsmall'])[1]")
    public WebElement pickingUpLink;

    @FindBy(xpath = "//div[@class='store-selector-container modal-content']")
    public WebElement selectPickupLocation;

    @FindBy(xpath = "(//span[@class='header-info-block__title'])[1]")
    public WebElement selectStoreBtn;

    @FindBy(xpath = "(//span[@class='header-info-block__title'])[2]")
    public WebElement fastShippingLink;

    @FindBy(xpath = "//figure[@class='lazy-image lazy-image--background element--hide-on-small lazyloaded']")
    public WebElement dealImg;

    @FindBy(xpath = "//button[@class='recommendation-modal__button']")
    public WebElement continueBtn;


    // ------- Best Selling Products
    @FindBy(xpath = "(//h2[@class='section-heading__title h4'])[4]")
    public WebElement bestSellingProductsHead;

    @FindBy(xpath = "(//*[@id='product-item-7036882092241']//button)[1]")
    public WebElement add7ftOlympicBar700lbsWithCollars;

    @FindBy(xpath = "(//*[@id='product-item-7036884975825']//button)[1]")
    public WebElement addAmStaffTR057DSquatPressRack;


    // ------- Body Weight Training
    @FindBy(xpath = "(//h2[@class='section-heading__title h4'])[5]")
    public WebElement bodyWeightTrainingHead;

    @FindBy(xpath = "//span[@class='css-slider-button css-slider-next']")
    public WebElement nextSlider;

    @FindBy(xpath = "(//*[@id='product-item-7089020305617']//a)[3]")
    public WebElement UndulationRopeBattleRopeWithSleeve;


    //------- Shopping Cart
    @FindBy(xpath = "//input[@id='agree']")
    public WebElement agreeCheckBox;

    @FindBy(xpath = "(//a[@class='button button--solid button--icon no-js-hidden'])[1]")
    public WebElement viewCartBtn;

    @FindBy(xpath = "//button[@id='CheckOut']")
    public WebElement checkOutBtn;

    @FindBy(xpath = "(//button[@class='sidebar__close'])[2]")
    public WebElement sliderBarClose;


}
