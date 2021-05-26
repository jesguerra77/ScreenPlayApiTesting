package ApiRestAutomation.Interactions.deleteInteraction;

import ApiRestAutomation.Interactions.ApiAutomationInteraction;
import ApiRestAutomation.Models.DeleteUserFail;
import ApiRestAutomation.Models.DeleteUserSuccessful;
import ApiRestAutomation.Models.GetUsersResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteUsers extends ApiAutomationInteraction {

    private String idUser;

    public DeleteUsers(String idUser) {
        this.idUser = idUser;
    }

    @Override
    @Step("{0} Realiza la eliminación del usuario")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(RootApiPaths.DELETE_USER.getUrlPath())
                        .with(requestSpecification -> rootBasicRequest()
                                .pathParam("id", idUser))
        );
    }

    public static DeleteUsers with(String idUser) {
        return instrumented(DeleteUsers.class, idUser);
    }
    public static Question<DeleteUserSuccessful> getDeleteUsersResponse() {
        return new ResponseBody<>(DeleteUserSuccessful.class);
    }
    public static Question<DeleteUserFail> getDeleteUsersFailResponse() {
        return new ResponseBody<>(DeleteUserFail.class);
    }
}
