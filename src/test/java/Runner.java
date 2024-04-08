//import Extent.ExtentReports;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                monochrome = true,
                plugin = {
                        "pretty",
                        "html:test-output",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                dryRun = false,
                features = "src/test/resources",
                glue = "Modules/Steps",
                tags = "@SexyGaming"
        )

public class Runner {

        public static void main(String[] args) {

        }
}
