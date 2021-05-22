package ApiRestAutomation.step_definitions.commonsSteps;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class CommonSteps {
    @Given("como administrador quiero validar los permisos en el sistema$")
    public void theAdminCanCreateUser() {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        final String urlBase = variables.getProperty("env.base.url");
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(urlBase)));
    }
}
