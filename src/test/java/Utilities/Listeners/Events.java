package Utilities.Listeners;

import Utilities.Helper.Waiting;
import Utilities.Objects.Component;
import engine.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Events extends Driver {

    public static void click(Component component){

        WebElement element = driver.findElement(By.xpath(component.getPath()));
        element.click();
    }

    public static void sendKeys(Component component, String value){

        WebElement element = driver.findElement(By.xpath(component.getPath()));
        element.sendKeys(value);

    }


    public static void switchTab(){

        String originalWindow = driver.getWindowHandle();

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static String getText(Component component){

        WebElement element = driver.findElement(By.xpath(component.getPath()));

        return element.getText();
    }

    public static List<String> getListText(Component component){

        Waiting.presence(component, 10);
        List<WebElement> elements = driver.findElements(By.xpath(component.getPath()));

        List<String> list = new ArrayList<>();

        for(WebElement element : elements){

            list.add(element.getText());

        }

        return list;
    }

    public static int getSize(Component component){

        List<WebElement> elements = driver.findElements(By.xpath(component.getPath()));

        return elements.size();
    }
}
