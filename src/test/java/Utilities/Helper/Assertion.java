package Utilities.Helper;

import Utilities.Objects.Component;
import engine.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Assertion extends Driver {

    public static void containsValue(Component component, String attribute, String value){

        WebElement element = driver.findElement(By.xpath(component.getPath()));

        Assert.assertTrue(element.getAttribute(attribute).contains(value));
    }


}
