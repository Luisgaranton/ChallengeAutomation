package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.stepdefinitions", "com.utils", "com.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider()
    public Object[][] scenarios() {
        return super.scenarios();
    }
}