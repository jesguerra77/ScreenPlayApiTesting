package ApiRestAutomation.stepdefinitions.apiInteractionSteps;

import ApiRestAutomation.Questions.SearchUser;
import ApiRestAutomation.Task.CreateUser;
import ApiRestAutomation.Task.DeleteUser;
import ApiRestAutomation.Task.QueryUsers;
import ApiRestAutomation.Task.UpdateUser;
import ApiRestAutomation.stepdefinitions.Constants;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ApiInteractionSteps {
    @When("^(.*) realiza el registro correcto con (.*) (.*) y (.*)$")
    public void realizaElRegistroCorrectoConNombreYCargo(String userAdmin, String name, String salary, String age) {
        theActorCalled(userAdmin).entersTheScene();
        theActorInTheSpotlight().attemptsTo(
                CreateUser.toCompany(name, salary, age)
                        .withStatusCode(200)
                        .withValidationMessage(Constants.VALID_CREATED_USER_SUCCESFUL.toString())
        );
    }

    @When("^(.*) realiza el registro incorrecto con (.*) (.*) y (.*)$")
    public void realizaElRegistroIncorrectoConNombreYCargo(String userAdmin, String name, String salary, String age) {
        theActorCalled(userAdmin).entersTheScene();
        theActorInTheSpotlight().attemptsTo(
                CreateUser.toCompany(name, salary, age)
                        .withStatusCode(400)
                        .withValidationMessage(Constants.VALID_CREATE_USER_FAILED.toString())
        );
    }

    @When("(.*) consulta los usuarios en el sistema$")
    public void consultaLosUsuariosEnElSistema(String userAdmin) {
        theActorCalled(userAdmin).entersTheScene();
        theActorInTheSpotlight().attemptsTo(
                QueryUsers.toObtainUsers()
                        .withStatus(200)
                        .withMessage(Constants.VALID_GET_USERS.toString())
        );

    }

    @When("(.*) consulta usuario con el (.*)$")
    public void consultaUsuarioConElId(String userAdmin, String idUser) {
        consultaLosUsuariosEnElSistema(userAdmin);
        theActorInTheSpotlight().remember(Constants.GET_DATA_USER.toString(), theActorInTheSpotlight()
                .asksFor(SearchUser.with(idUser)));
    }

    @When("el administrador elimina el usuario con los datos correctos (.*)$")
    public void elAdministradorEliminaElUsuarioConLosDatosCorrectosEmail(String idUser) {
        theActorInTheSpotlight().recall(Constants.GET_DATA_USER.toString());
        theActorInTheSpotlight().attemptsTo(
                DeleteUser.with(idUser)
                        .withStatusCode(200)
                        .withMessageValidation(Constants.VALID_DELETE_USER.toString())
        );
    }

    @When("(.*) intenta eliminar un usuario con (.*)$")
    public void intentaEliminarUnUsuarioConIdIncorrecto(String userAdmin, String idUser) {
        theActorCalled(userAdmin).entersTheScene();
        theActorInTheSpotlight().attemptsTo(
                DeleteUser.with(idUser)
                        .withStatusCode(404)
                        .withMessageValidation(Constants.VALID_DELETE_USER_ERROR.toString())
        );
    }

    @When("(.*) realiza la solicitud de actualización del usuario con (.*) (.*) (.*) y (.*)$")
    public void realizaLaSolicitudDeActualizacionDelUsuarioConid(String userAdmin,
                                                                 String idUser, String name, String salary, String age) {
        theActorCalled(userAdmin).entersTheScene();
        theActorInTheSpotlight().attemptsTo(
                UpdateUser.with(idUser, name, salary, age)
        );
    }
}
