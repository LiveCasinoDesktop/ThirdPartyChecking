package Utilities.Helper;

import Utilities.Objects.Component;
import engine.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class Drivers extends Driver {

    public static void changeWindow(){
        try {
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            Set<String> windowHandles = driver.getWindowHandles();
            String newWindowHandle = "";
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(originalWindowHandle)) {
                    newWindowHandle = windowHandle;
                    break;
                }
            }
            driver.switchTo().window(newWindowHandle);
        } catch (Exception e) {
            System.out.println("Failed to switch to another window");
            throw e;
        }
    }

    public static void selectOriginalWindow(){
        driver.switchTo().window(originalWindowHandle);
    }

    public static void changeIFrame(Component component){

        WebElement element = driver.findElement(By.xpath(component.getPath()));
        driver.switchTo().frame(element);

    }

    public static void maximize(){

        driver.manage().window().maximize();
    }

    public static void hoverToElement(Component component){

        Actions actions = new Actions(driver);

        WebElement element = driver.findElement(By.xpath(component.getPath()));
        actions.moveToElement(element).perform();
    }
    public static void hoverToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void refresh(){
        driver.navigate().refresh();
    }
}
