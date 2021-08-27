package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/GetPost.feature",
        glue = {"StepDefinition"},
        dryRun = false,
        monochrome=false,
        strict=true,

        //----Different types of report format----

        plugin = { "pretty" }
        //plugin = { "usage" }
        //plugin = { "pretty", "html:target/cucumber-reports" }
       // plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class Run extends AbstractTestNGCucumberTests {
}
