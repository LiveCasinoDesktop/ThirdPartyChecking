package Utilities.Listeners;

import Utilities.Helper.Waiting;
import Utilities.Objects.Component;
import engine.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

    public static class FORMATTER{

        public static String dateFormat(){
            LocalDate currentDate = LocalDate.now();

            // Format the time as 24-hour time
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy");

            return currentDate.format(formatter);

        }
        public static String timeFormat(){
            LocalTime currentTime = LocalTime.now();

            // Format the time as 24-hour time
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            return currentTime.format(formatter);

        }

        public static int hourTimeFormatter(String currentTime){

            String[] hour = currentTime.split(":");

            return Integer.parseInt(hour[0]);
        }
    }
}
