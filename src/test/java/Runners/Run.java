package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/GetPost.feature",
        glue = {"StepDefinition"}
)
public class Run extends AbstractTestNGCucumberTests {
}
