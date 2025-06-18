package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import java.time.Duration;

public class ReusableMethods {
    public WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(ConfigReader.getIntProperty("explicitWait")));
    public Actions action = new Actions(GWD.getDriver());
    public Robot robot;

    public void myClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.click();
    }
    public void myDoubleClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        action.doubleClick(element).build().perform();
    }

    public void clickAndClose(WebElement clickElement, WebElement assertElement) {
        wait.until(ExpectedConditions.visibilityOf(clickElement));
        wait.until(ExpectedConditions.elementToBeClickable(clickElement));
        jsClick(clickElement);
        wait.until(ExpectedConditions.visibilityOfAllElements(assertElement));
        Assert.assertTrue(assertElement.isDisplayed());
        action.sendKeys(Keys.ESCAPE).build().perform();
    }

    public void mySendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void hoverOver(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        action.moveToElement(element).build().perform();
    }

    public void scrollToElement(WebElement elements) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", elements);
    }

    public void verifyContainsText(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()), value + " not displayed!");
    }

    public void verifyEqualsText(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertEquals(value.toLowerCase(), element.getText().toLowerCase());
        action.sendKeys(Keys.ESCAPE).build().perform();
    }

    public void jsClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public static void setZoomPercentage(WebDriver driver, int percent) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='" + percent + "%'");
    }

    public void setWait(int sn) {
        try {
            Thread.sleep(sn * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void pressTab(int count) {
        try {
            for (int i = 1; i <= count; i++) {
                robot = new Robot();
                robot.delay(500);
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void pressEnter() {
        try {
            robot = new Robot();
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    public void pressSpace() {
        try {
            robot = new Robot();
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

}
