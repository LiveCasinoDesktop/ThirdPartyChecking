package Utilities.Helper;

import Utilities.Objects.Component;
import engine.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    public static void changeIFrame(Component component){

        WebElement element = driver.findElement(By.xpath(component.getPath()));
        driver.switchTo().frame(element);


    }
}
