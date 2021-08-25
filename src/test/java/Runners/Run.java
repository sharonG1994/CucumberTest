package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/GetPost.feature",
        glue = {"StepDefinition"},
        dryRun = false,
        monochrome=true,
        strict=true,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class Run extends AbstractTestNGCucumberTests {
}
