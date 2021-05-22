package ApiRestAutomation.step_definitions.apiInteractionSteps;

import ApiRestAutomation.Interactions.getInteraction.GetUsers;
import ApiRestAutomation.Interactions.postInteraction.PostCreateUser;
import ApiRestAutomation.Models.CreateUserResponse;
import ApiRestAutomation.Models.Datum;
import ApiRestAutomation.Questions.SearchUser;
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

    @Then("los usuarios creados en el sistema son listados")
    public void losUsuariosCreadosEnElSistemaSonListados() {
        theActorInTheSpotlight().should(
                seeThat(Constants.VALID_GET_USERS.toString(), actor1 -> theActorInTheSpotlight().asksFor(
                        getStatusCode()), equalTo(200)));
        theActorInTheSpotlight().should(
                seeThat("", actorSee -> actorSee.asksFor(GetUsers.getUsersResponse()), is(notNullValue()))
        );
    }

    @Then("el usuario con el (.*) es listado en el sistema$")
    public void elUsuarioEsListadoEnElSistema(String idUser) {
        Datum datum = theActorInTheSpotlight().asksFor(SearchUser.with(idUser)).get(0);

        theActorInTheSpotlight().should(
                seeThat(Constants.VALID_ID_USER.toString(), actor -> datum.getId(), equalTo(idUser)),
                seeThat(Constants.VALID_EMAIL_USER.toString(), actor -> datum.getEmail(), is(notNullValue())),
                seeThat(Constants.VALID_LAST_NAME_USER.toString(), actor -> datum.getLastName(), is(notNullValue())),
                seeThat(Constants.VALID_FIRST_NAME_USER.toString(), actor -> datum.getFirstName(), is(notNullValue())),
                seeThat(Constants.VALID_AVATAR_NAME_USER.toString(), actor -> datum.getAvatar(), is(notNullValue()))
        );
    }
}

