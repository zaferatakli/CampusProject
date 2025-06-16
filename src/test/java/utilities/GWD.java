package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Locale;
import java.util.Set;

public class GWD {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>();
    private static ThreadLocal<String> originalWindowHandle = new ThreadLocal<>();
    public static ThreadLocal<WebDriverWait> threadWait = new ThreadLocal<>();
    public static WebDriver getDriver() {
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if (threadDriver.get() == null) {

            if (threadBrowserName.get() == null) {
                threadBrowserName.set(ConfigReader.getProperty("browser"));
            }
            switch (threadBrowserName.get().toLowerCase()) {
                case "firefox":
                    threadDriver.set(new FirefoxDriver());
                    break;
                case "safari":
                    threadDriver.set(new SafariDriver());
                    break;
                case "edge":
                    threadDriver.set(new EdgeDriver());
                    break;
                case "chrome":
                default:
                    threadDriver.set(new ChromeDriver());
                    break;
            }

            threadDriver.get().manage().window().maximize();
            threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigReader.getIntProperty("pageLoadTimeout")));
            threadWait.set(new WebDriverWait(threadDriver.get(), Duration.ofSeconds(30)));
        }
        return threadDriver.get();
    }

    public static void tearDown() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (threadDriver.get() != null) {
            threadDriver.get().quit();
            threadDriver.remove();
        }
    }

    public static void switchToNewWindow() {
        String currentWindow = threadDriver.get().getWindowHandle(); // Mevcut pencerenin ID'si
        Set<String> allWindowHandles = threadDriver.get().getWindowHandles(); // Tüm açık pencerelerin ID'leri

        System.out.println("DEBUG: Current Window Handle: " + currentWindow); // EKLE
        System.out.println("DEBUG: All Window Handles before switch: " + allWindowHandles); // EKLE

        // Yeni pencerenin açılmasını bekle
        threadWait.get().until(ExpectedConditions.numberOfWindowsToBe(allWindowHandles.size() + 1));
        allWindowHandles = threadDriver.get().getWindowHandles(); // Yeni window handle'ları al

        System.out.println("DEBUG: All Window Handles after new window opened: " + allWindowHandles); // EKLE

        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(currentWindow)) {
                threadDriver.get().switchTo().window(windowHandle);
                System.out.println("DEBUG: Successfully switched to new window. Current URL now: " + threadDriver.get().getCurrentUrl()); // Bu zaten vardı
                return;
            }
        }
        Assert.fail("No new window/tab was opened or switch failed.");
    }

    // Orijinal pencereye geri dönme metodu (parametre almıyor)
    public static void switchToOriginalWindow() {
        String handle = originalWindowHandle.get(); // Kayıtlı orijinal handle'ı al
        if (handle != null) {
            threadDriver.get().switchTo().window(handle); // Orijinal pencereye geç
        } else {
            System.err.println("Original window handle not set. Cannot switch back.");
            // Testin burada hata vermesini istiyorsanız: Assert.fail("Original window handle not set.");
        }
    }
}
