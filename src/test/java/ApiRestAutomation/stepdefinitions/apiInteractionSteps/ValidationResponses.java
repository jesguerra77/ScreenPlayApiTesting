package ApiRestAutomation.stepdefinitions.apiInteractionSteps;

import ApiRestAutomation.Interactions.deleteInteraction.DeleteUsers;
import ApiRestAutomation.Interactions.getInteraction.GetUsers;
import ApiRestAutomation.Interactions.postInteraction.PostCreateUser;
import ApiRestAutomation.Interactions.putInteraction.PutUpdateUsers;
import ApiRestAutomation.Models.*;
import ApiRestAutomation.Questions.SearchUser;
import ApiRestAutomation.stepdefinitions.Constants;
import io.cucumber.java.en.Then;

import static ApiRestAutomation.Interactions.utils.ApiInteraction.getStatusCode;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ValidationResponses {
    @Then("el empleado con (.*) (.*) y (.*) es creado de forma correcta$")
    public void elEmpleadoesCreadoDeFormaCorrecta(String name, String salary, String age) {

        assertThat(Constants.VALID_CREATE_USER_RESPONSE_MESSAGE.toString(), theActorInTheSpotlight().asksFor(
                PostCreateUser.getCreateResponse()), is(notNullValue()));

        DataUser createUserResponse = theActorInTheSpotlight().asksFor(
                PostCreateUser.getCreateResponse()).getData();

        theActorInTheSpotlight().should(
                seeThat(Constants.VALID_NAME_MESSAGE.toString(), actorSee -> createUserResponse.getName(), equalTo(name)),
                seeThat(Constants.VALID_SALARY_USER.toString(), actorSee -> createUserResponse.getSalary(), equalTo(salary)),
                seeThat(Constants.VALID_AGE_USER.toString(), actorSee -> createUserResponse.getAge(), equalTo(age)),
                seeThat(Constants.VALID_ID_USER.toString(), actorSee -> createUserResponse.getId().toString(), is(notNullValue()))
        );
    }

    @Then("el empleado no pudo ser creado correctamente")
    public void elEmpleadoNoPudoSerCreadoCorrectamente() {

        theActorInTheSpotlight().should(
                seeThat(Constants.VALID_CREATE_USER_FAILED.toString(), actor1 -> theActorInTheSpotlight().asksFor(
                        getStatusCode()), equalTo(400))
        );
        theActorInTheSpotlight().should(
                seeThat(Constants.VALID_EMPTY_RESPONSE.toString(), actorSee -> actorSee.asksFor(
                        PostCreateUser.getCreateResponse()), is(nullValue()))
        );

    }

    @Then("los usuarios creados en el sistema son listados")
    public void losUsuariosCreadosEnElSistemaSonListados() {
        theActorInTheSpotlight().should(
                seeThat(Constants.VALID_GET_USERS.toString(), actor1 -> theActorInTheSpotlight().asksFor(
                        getStatusCode()), equalTo(200)));
        theActorInTheSpotlight().should(
                seeThat(Constants.VALID_GET_USERS.toString(), actorSee -> actorSee.asksFor(
                        GetUsers.getUsersResponse()), is(notNullValue()))
        );
    }

    @Then("el usuario con el (.*) es listado en el sistema$")
    public void elUsuarioEsListadoEnElSistema(String idUser) {
        Datum datum = theActorInTheSpotlight().asksFor(SearchUser.with(idUser)).get(0);

        theActorInTheSpotlight().should(
                seeThat(Constants.VALID_ID_USER.toString(), actor -> datum.getId().toString(), equalTo(idUser)),
                seeThat(Constants.VALID_NAME_USER.toString(), actor -> datum.getEmployee_name(), is(notNullValue())),
                seeThat(Constants.VALID_SALARY_USER.toString(), actor -> datum.getEmployee_salary().toString(), is(notNullValue())),
                seeThat(Constants.VALID_AGE_USER.toString(), actor -> datum.getEmployee_age().toString(), is(notNullValue())),
                seeThat(Constants.VALID_IMAGE_USER.toString(), actor -> datum.getProfile_image(), is(notNullValue()))
        );
    }

    @Then("el usuario con el (.*) sea eliminado de la compañia$")
    public void elUsuarioEsEliminadoDeLaCompania(String idUser) {
        DeleteUserSuccessful deleteUserSuccessful = theActorInTheSpotlight()
                .asksFor(DeleteUsers.getDeleteUsersResponse());
        theActorInTheSpotlight().should(
                seeThat(Constants.VALID_DELETE_USER.toString(), actorSee -> deleteUserSuccessful.getData(), equalTo(idUser))
        );
    }

    @Then("el usuario no puede ser eliminado de la compañía$")
    public void elUsuarioNoPuedeSerEliminadoDeLaCompania() {
        theActorInTheSpotlight().should(
                seeThat(Constants.VALID_DELETE_USER_ERROR.toString(), actor1 -> theActorInTheSpotlight().asksFor(
                        getStatusCode()), equalTo(404))
        );
        theActorInTheSpotlight().should(
                seeThat(Constants.VALID_EMPTY_RESPONSE.toString(), actorSee -> actorSee.asksFor(
                        DeleteUsers.getDeleteUsersFailResponse()).getMessage(), equalTo(
                        Constants.EXPECT_DELETE_ERROR_MESSAGE.toString()))
        );
    }

    @Then("el usuario es actualizado con los siguientes datos (.*) (.*) (.*)$")
    public void elUsuarioEsActualizado(String name, String salary, String age) {
        data updateUserResponse = theActorInTheSpotlight().asksFor(
                PutUpdateUsers.getUpdateUserResponse()).getData();

        theActorInTheSpotlight().should(
                seeThat(Constants.VALID_UPDATE_USER.toString(), actor -> updateUserResponse
                        .getName(), equalTo(name)),
                seeThat(Constants.VALID_SALARY_USER.toString(), actor -> updateUserResponse
                        .getSalary(), equalTo(salary)),
                seeThat(Constants.VALID_AGE_USER.toString(), actor -> updateUserResponse
                        .getAge(), equalTo(age))
        );
    }
}

