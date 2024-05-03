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

    public static void scrollToBottom(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Execute script to scroll to top (using window.scrollTo)
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");


    }


    public static void scrollTo(Component component, int index){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> element = driver.findElements(By.xpath(component.getPath()));
        // Execute JavaScript to scroll the element into view:
        js.executeScript("arguments[0].scrollIntoView(true);", element.get(index-1));

    }
    public static void scrollTo(List<WebElement> element, int index){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Execute JavaScript to scroll the element into view:
        js.executeScript("arguments[0].scrollIntoView(true);", element.get(index-1));

    }

    public static void scrollTo(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Execute JavaScript to scroll the element into view:
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public static void click(Component component){

        WebElement element = driver.findElement(By.xpath(component.getPath()));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void click(WebElement element){

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
