package ApiRestAutomation.step_definitions.commonsSteps;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class CommonSteps {
    @Given("el administrador quiere crear un usuario nuevo en la compañia$")
    public void theAdminCanCreateUser() {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        final String urlBase = variables.getProperty("env.base.url");
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(urlBase)));
    }
}
