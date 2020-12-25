package stepDefs;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@UItest", features = "src/test/resources/features")
public class RunCucumberTest {
}
