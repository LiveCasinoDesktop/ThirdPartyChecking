package engine;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Driver {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String originalWindowHandle;
    public void start() {

        //WebDriverManager.chromedriver().setup();
        driver = new GoogleChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.manage().window().setSize(new Dimension(1324, 968));

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        originalWindowHandle = driver.getWindowHandle();
    }

    public void close() {

        driver.quit();
    }
}
