package Modules.Steps;

import engine.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

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

    @After()
    public void after() {
        driver.close();
    }

}
