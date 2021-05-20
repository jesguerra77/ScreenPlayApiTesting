package ApiRestAutomation.step_definitions.apiInteractionSteps;

import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ApiInteractionSteps {
    @When("realiza el registro con (.*) y (.*)")
    public void realizaElRegistroConNombreYCargo(String userAdmin) {
        theActorCalled(userAdmin).entersTheScene();
        theActorInTheSpotlight().attemptsTo(

        );

    }
}
