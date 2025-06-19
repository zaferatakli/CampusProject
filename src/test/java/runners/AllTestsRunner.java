package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.*;

@CucumberOptions(features = {"src/test/java/featureFiles"},
        glue = {"stepDefinitions", "hooks"})
public class AllTestsRunner extends AbstractTestNGCucumberTests {
}