package ApiRestAutomation.step_definitions.apiInteractionSteps;

import ApiRestAutomation.Task.CreateUser;
import ApiRestAutomation.step_definitions.Constants;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ApiInteractionSteps {
    @When("^(.*) realiza el registro correcto con (.*) y (.*)$")
    public void realizaElRegistroCorrectoConNombreYCargo(String userAdmin, String name, String job) {
        theActorCalled(userAdmin).entersTheScene();
        theActorInTheSpotlight().attemptsTo(
                CreateUser.toCompany(name, job)
                        .withStatusCode(200)
                        .withValidationMessage(Constants.VALID_CREATED_USER_SUCCESFUL.toString())
        );
    }
    @When("^(.*) realiza el registro incorrecto con (.*) y (.*)$")
    public void realizaElRegistroIncorrectoConNombreYCargo(String userAdmin, String name, String job) {
        theActorCalled(userAdmin).entersTheScene();
        theActorInTheSpotlight().attemptsTo(
                CreateUser.toCompany(name, job)
                        .withStatusCode(400)
                        .withValidationMessage(Constants.VALID_CREATE_USER_FAILED.toString())
        );
    }
}
