package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features/",
        glue = "stepdefinitions",
        monochrome = true,
        dryRun = false,
        tags = "@myapplication or @Edges or @usermanagement or @Zones", 
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber-reports/cucumber.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
