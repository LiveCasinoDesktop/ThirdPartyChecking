package Modules.Steps;

import engine.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private Driver driver;
    private String folderName;
    public Hooks(Driver driver) {
        this.driver = driver;
    }
    @Before()
    public void before(Scenario scenario) {
        driver.start();
    }

    @AfterStep()
    public void screenshot(Scenario scenario){
        if(scenario.isFailed()){

            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }

    }
    @After()
    public void after() {
        driver.close();
    }

}
