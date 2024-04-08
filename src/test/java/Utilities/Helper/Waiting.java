package Utilities.Helper;

import Utilities.Objects.Component;
import engine.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiting extends Driver {

    public static WebDriverWait wait;
    public static void newWindow(int seconds){

        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

    }

    public static void element(Component component, int seconds){

        try{
            wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(component.getPath())));

        }catch (TimeoutException e){

            throw e;
        }

    }

    public static void presence(Component component, int seconds){

        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(component.getPath())));
    }

    public static void fewSeconds(int seconds){

        try{

            seconds *= 1000;
            Thread.sleep(seconds);

        }catch (Exception e){

            System.out.println(e.getMessage());
        }
    }
}
