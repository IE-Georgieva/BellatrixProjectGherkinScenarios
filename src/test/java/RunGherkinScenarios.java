import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber.html"},
        features = "src/test/java/featureFile",
        glue = {"stepDefinitions"}
)
public class RunGherkinScenarios extends AbstractTestNGCucumberTests {
}