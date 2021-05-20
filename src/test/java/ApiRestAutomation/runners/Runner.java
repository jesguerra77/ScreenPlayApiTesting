package ApiRestAutomation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/features",
        plugin = {"pretty","summary"},
        strict = true,
        snippets = CAMELCASE,
        glue = {"ApiRestAutomation/step_definitions"}

)
public class Runner {
    public Runner() {
    }
}
