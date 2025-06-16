package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import java.io.File;
import java.time.Duration;

public class ReusableMethods {
    public WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(ConfigReader.getIntProperty("explicitWait")));
    public Actions action = new Actions(GWD.getDriver());
    public Robot robot;


    public void performDownloadWithRobot(int tabCount) {
        try {
            robot = new Robot();
            robot.delay(1000); // Wait a bit for the new window/dialog to become active

            for (int i = 0; i < tabCount; i++) {
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
                robot.delay(500); // Short delay between tabs
            }
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(1000); // Wait for the download to initiate
        } catch (AWTException e) {
            e.printStackTrace();
            Assert.fail("Failed to perform download with Robot due to AWTException: " + e.getMessage());
        }
    }
    public void checkButtonAbsence(WebElement element, String buttonName) {
        try {
            waitUntilInvisible(element, 1);
            if (element.isDisplayed()) {
                Assert.fail(buttonName + " button was unexpectedly visible.");
            }
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("✅ " + buttonName + " button is not present on the page (as expected).");
        } catch (Exception e) {
            System.err.println("⚠️ An unexpected error occurred while checking " + buttonName + " button absence: " + e.getMessage());
            Assert.fail("Failed to verify non-presence of " + buttonName + " button due to an unexpected error.");
        }
    }


    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilInvisible(WebElement element, int seconds) {
        WebDriverWait tempWait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(seconds));
        tempWait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void myClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.click();
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
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
    }

    public void verifyEqualsText(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().equals(value.toLowerCase()));
        action.sendKeys(Keys.ESCAPE).build().perform();
    }

    public void jsClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].click();", element);
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
    public File checkFileDownloaded(String downloadPath, String fileNamePart, int timeoutInSeconds) {
        File downloadDir = new File(downloadPath);
        long startTime = System.currentTimeMillis();
        File foundFile = null;

        while (System.currentTimeMillis() - startTime < timeoutInSeconds * 1000L) {
            File[] listOfFiles = downloadDir.listFiles();
            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile() && file.getName().contains(fileNamePart) && file.length() > 0 && !file.getName().endsWith(".tmp") && !file.getName().endsWith(".crdownload")) {
                        foundFile = file;
                        System.out.println("✅ File downloaded: " + file.getName());
                        return foundFile;
                    }
                }
            }
            setWait(1);
        }
        Assert.fail("❌ File containing '" + fileNamePart + "' was not found in " + downloadPath + " within " + timeoutInSeconds + " seconds.");
        return null;
    }

    public void deleteDownloadedFiles(String downloadPath, String fileNamePart) {
        File downloadDir = new File(downloadPath);
        File[] listOfFiles = downloadDir.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().contains(fileNamePart)) {
                    if (file.delete()) {
                        System.out.println("🗑️ Deleted downloaded file: " + file.getName());
                    } else {
                        System.err.println("⚠️ Failed to delete file: " + file.getName());
                    }
                }
            }
        }
    }
}

