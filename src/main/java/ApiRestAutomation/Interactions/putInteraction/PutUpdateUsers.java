package ApiRestAutomation.Interactions.putInteraction;

import ApiRestAutomation.Interactions.ApiAutomationInteraction;
import ApiRestAutomation.Models.CreateUserRequest;
import ApiRestAutomation.Models.UpdateUserResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutUpdateUsers extends ApiAutomationInteraction {

    private String idUser;
    private CreateUserRequest updateDataResponseBuilder;

    public PutUpdateUsers(String idUser, CreateUserRequest updateDataResponseBuilder) {
        this.idUser = idUser;
        this.updateDataResponseBuilder = updateDataResponseBuilder;
    }

    @Override
    @Step("{0} realiza el proceso de actualización del usuario")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(RootApiPaths.UPDATE_USER.getUrlPath())
                        .with(requestSpecification -> rootBasicRequest()
                                .pathParam("id", idUser)
                                .body(updateDataResponseBuilder))
        );
    }

    public static PutUpdateUsers with(String idUser, CreateUserRequest updateDataResponseBuilder) {
        return instrumented(PutUpdateUsers.class, idUser, updateDataResponseBuilder);
    }

    public static Question<UpdateUserResponse> getUpdateUserResponse() {
        return new ResponseBody<>(UpdateUserResponse.class);
    }
}
