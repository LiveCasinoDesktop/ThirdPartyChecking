package Utilities.Helper;

import Utilities.Objects.Component;
import engine.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JavaScript extends Driver {

    public static void scrollTo(Component component){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.xpath(component.getPath()));
        // Execute JavaScript to scroll the element into view:
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }


    public static void scrollTo(Component component, int index){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> element = driver.findElements(By.xpath(component.getPath()));
        // Execute JavaScript to scroll the element into view:
        js.executeScript("arguments[0].scrollIntoView(true);", element.get(index-1));

    }
}
