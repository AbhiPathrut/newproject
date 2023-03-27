package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features/",
        glue = "stepdefinitions",
        monochrome = true,
        dryRun = false,
        tags = "@Policy_01 or @Policy_02 or @Policy_03", 
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber-reports/cucumber.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
