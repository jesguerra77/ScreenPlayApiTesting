package ApiRestAutomation.step_definitions.apiInteractionSteps;

import ApiRestAutomation.Interactions.postInteraction.PostCreateUser;
import ApiRestAutomation.Models.CreateUserResponse;
import ApiRestAutomation.step_definitions.Constants;
import io.cucumber.java.en.Then;

import static ApiRestAutomation.Interactions.utils.ApiInteraction.getStatusCode;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ValidationResponses {
    @Then("el empleado con (.*) y (.*) es creado de forma correcta")
    public void elEmpleadoEsCreadoDeFormaCorrecta(String name, String job) {

        assertThat(Constants.VALID_CREATE_USER_RESPONSE_MESSAGE.toString(), theActorInTheSpotlight().asksFor(
                PostCreateUser.getCreateResponse()), is(notNullValue()));

        CreateUserResponse createUserResponse = theActorInTheSpotlight().asksFor(
                PostCreateUser.getCreateResponse());

        assertThat("", theActorInTheSpotlight().asksFor(PostCreateUser.getCreateResponse()), is(notNullValue()));
        theActorInTheSpotlight().should(
                seeThat(Constants.VALID_NAME_MESSAGE.toString(), actorSee -> createUserResponse.getName(), equalTo(name)),
                seeThat(Constants.VALID_ID_MESSAGE.toString(), actorSee -> createUserResponse.getId(), is(not(nullValue()))),
                seeThat(Constants.VALID_JOB_MESSAGE.toString(), actorSee -> createUserResponse.getJob(), equalTo(job)),
                seeThat(Constants.VALID_DATE_MESSAGE.toString(), actorSee -> createUserResponse.getCreatedAt(), is(notNullValue()))
        );
    }

    @Then("el empleado no pudo ser creado correctamente")
    public void elEmpleadoNoPudoSerCreadoCorrectamente() {

        theActorInTheSpotlight().should(
                seeThat(Constants.VALID_CREATE_USER_FAILED.toString(), actor1 -> theActorInTheSpotlight().asksFor(
                        getStatusCode()), equalTo(400))
        );
        theActorInTheSpotlight().should(
                seeThat("", actorSee -> actorSee.asksFor(PostCreateUser.getCreateResponse()), is(nullValue()))
        );

    }
}

