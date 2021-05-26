package ApiRestAutomation.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"ApiRestAutomation/stepdefinitions"}

)
public class Runner {
    public Runner() {
    }
}
