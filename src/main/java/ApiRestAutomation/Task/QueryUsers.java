package ApiRestAutomation.Task;

import ApiRestAutomation.Interactions.getInteraction.GetUsers;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import org.apache.http.HttpStatus;

import static ApiRestAutomation.Interactions.utils.ApiInteraction.getStatusCode;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class QueryUsers implements Task {

    private String messageValidation;
    private int statusCode = HttpStatus.SC_OK;

    @Override
    @Step("{0} Inicia la acción de consultar los usuarios de la compañía")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GetUsers.fromApplication()
        );
        theActorInTheSpotlight().should(
                seeThat(messageValidation, actorSee -> actor.asksFor(getStatusCode()), equalTo(statusCode))
        );
    }

    public static QueryUsers toObtainUsers() {
        return instrumented(QueryUsers.class);
    }

    public QueryUsers withMessage(String messageValidation) {
        this.messageValidation = messageValidation;
        return this;
    }

    public QueryUsers withStatus(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }
}
