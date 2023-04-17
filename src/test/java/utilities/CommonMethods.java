package utilities;


import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
//import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.awt.SystemColor.window;

public class CommonMethods extends PageInitializer{

    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static void clickRadioOrCheckbox(List<WebElement> radioOrCheckbox, String value) {

        String actualValue;
        // el = each element
        for (WebElement el : radioOrCheckbox) {
            actualValue = el.getAttribute("value").trim();
            if (el.isEnabled() && actualValue.equals(value)) {
                el.click();
                break;
            }
        }
    }

    public static void selectDropDownValue(WebElement element, String textToSelect) {

        try {
            Select select = new Select(element);

            List<WebElement> options = select.getOptions();
            for (WebElement el : options) {
                if (el.getText().equals(textToSelect)) {
                    select.selectByVisibleText(textToSelect);
                    break;
                }
            }

        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
    }

    public static void selectDropDownIndex(WebElement element, int indexValue) {

        try {
            Select select = new Select(element);

            int size = select.getOptions().size();

            if (size > indexValue) {
                select.selectByIndex(indexValue);
            }

        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }

    }

    // methods that dismisses alerts and catches exception if alert is not present
    public static void dismissAlert() {

        try {

            Alert alert = BaseClass.getDriver().switchTo().alert();
            alert.dismiss();

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }

    }

    // methods that gets text of alert and catches exception if laert is not present
    // return type has to be String
    public static String getAlertText() {

        String alertText = null; // in method, every variable must be initiate. But the class is not
        try {
            Alert alert = BaseClass.getDriver().switchTo().alert();
            alertText = alert.getText();

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
        return alertText;

    }

    // accept alert
    public static void aceptAlert() {

        try {

            Alert alert = BaseClass.getDriver().switchTo().alert();
            alert.accept();

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    // sends text to alert box
    public static void sendAlertText(String text) {

        try {

            Alert alert = BaseClass.getDriver().switchTo().alert();
            alert.sendKeys(text);
            alert.accept();

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }

    }

    // iframe
    public static void switchToFrame(String nameOrId) {

        try {
            BaseClass.getDriver().switchTo().frame(nameOrId);
        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }

    }

    // iframe
    public static void switchToFrame(WebElement element) {

        try {
            BaseClass.getDriver().switchTo().frame(element);

        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }

    }

    // iframe index
    public static void switchToFrame(int index) {

        try {
            BaseClass.getDriver().switchTo().frame(index);

        } catch (NoSuchFrameException e) {
            e.printStackTrace();
        }
    }

    // handle windows by switching to child Window (either window and tab)
    public static void switchToChildWindow() {
        String mainWindow = BaseClass.getDriver().getWindowHandle();
        Set<String> windows = BaseClass.getDriver().getWindowHandles();

        for (String eachWindow : windows) {

            if (!eachWindow.equals(mainWindow)) {
                BaseClass.getDriver().switchTo().window(eachWindow);
                break;
            }
        }
    }

    public static WebDriverWait getWaitObject() {
        WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(Constants.explicit_wait_time));
        return wait;
    }

    public static WebElement waitForClickability(WebElement element) {

        return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForVisibility(WebElement element) {

        return getWaitObject().until(ExpectedConditions.visibilityOf(element));
    }

    public static void click(WebElement element) {
        waitForVisibility(element).click();
    }

    // js executer
    public static JavascriptExecutor getJSObject() {
        JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
        return js;
    }

    public static void jsClick(WebElement element) {
        getJSObject().executeScript("arguments[0].click();", element);
    }

    public static void scrollToElement(WebElement element) {
        getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void ScrolByPixel(int pixel) {
        // scroll down positive
        // scroll up negative

        getJSObject().executeScript("window.scrollBy(0," + pixel + ")");

    }

    public static String getTimeStemp() {

        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

        return sdf.format(date.getTime());
    }

    public static byte[] takeScreenshot(String filename) {
        TakesScreenshot ts = (TakesScreenshot) BaseClass.getDriver();
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

        File file = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = Constants.SCREENSHOT_FILEPATH + filename + getTimeStemp() + ".png";

        try {
            FileUtils.copyFile(file, new File(destinationFile));
        } catch (Exception ex) {
            System.out.println("Cannot take screenshot!");
        }

        return picBytes;
    }

    public static void wait(int second) {

        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void selectCalendarDate(List<WebElement> element, String text) {
        for (WebElement pickDate : element) {
            if (pickDate.isEnabled()) {
                if (pickDate.getText().equals(text)) {
                    pickDate.click();
                    break;
                }
            }
        }
    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(BaseClass.getDriver());
        actions.moveToElement(element).perform();
    }

    public static void dragAndDrop(WebElement source, WebElement target) {
        Actions actions = new Actions(BaseClass.getDriver());
        actions.dragAndDrop(source, target).perform();
    }

    public static void doubleClick(WebElement source) {
        Actions actions = new Actions(BaseClass.getDriver());
        actions.doubleClick(source).perform();
    }

    /**
     * return a list of string from a list of elements ignores any element with no
     * text
     *
     * @param list
     * @return
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<String>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    /*
     * Method to generate new email by random char and int
     *
     * by: Lalita 06/10/2022
     *
     */
    public static String generateRandomEmail() {
        Random rd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            char c = 'a';
            c += rd.nextInt(5);
            sb.append(c);
        }
        int randomNum = rd.nextInt(1000);
        return sb.toString() + randomNum + "@mail.com";
    }

    public static boolean isClickable(WebElement el, WebDriver driver)
    {
        try{
            WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(Constants.explicit_wait_time));
            wait.until(ExpectedConditions.elementToBeClickable(el));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public static double twoDecimalPoint(double number){
        number = Math.round(number * 100.0) / 100.0;
        return number;
    }

    public static double getDouble(WebElement element){
        String text = element.getText();
        text = text.substring(text.indexOf("$") + 1);
        double result = Double.parseDouble(text);
        result = Math.round(result * 100.0) / 100.0;
        return result;
    }

    public static void goToTop(){
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }


}
