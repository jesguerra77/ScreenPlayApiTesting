package ApiRestAutomation.Task;

import ApiRestAutomation.Interactions.deleteInteraction.DeleteUsers;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import javax.servlet.http.HttpServletResponse;

import static ApiRestAutomation.Interactions.utils.ApiInteraction.getStatusCode;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.Matchers.equalTo;

public class DeleteUser implements Task {

    private String idUser;
    private String messageValidation;
    private Integer statusCode = HttpServletResponse.SC_OK;

    public DeleteUser(String idUser) {
        this.idUser = idUser;
    }

    @Override
    @Step("{0} Inicia el proceso de eliminación del usuario")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                DeleteUsers.with(idUser)
        );
        actor.should(
                seeThat(messageValidation, actorSee -> actor.asksFor(getStatusCode()), equalTo(statusCode))
        );
    }

    public static DeleteUser with(String idUser) {
        return instrumented(DeleteUser.class, idUser);
    }

    public DeleteUser withStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public DeleteUser withMessageValidation(String messageValidation) {
        this.messageValidation = messageValidation;
        return this;
    }

}
