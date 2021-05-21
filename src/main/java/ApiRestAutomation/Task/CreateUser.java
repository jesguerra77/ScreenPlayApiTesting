package ApiRestAutomation.Task;

import ApiRestAutomation.Factories.CreateUserBuilder;
import ApiRestAutomation.Interactions.postInteraction.PostCreateUser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import javax.servlet.http.HttpServletResponse;

import static ApiRestAutomation.Interactions.utils.ApiInteraction.getStatusCode;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class CreateUser implements Task {

    private String messageValidation;
    private String name;
    private String job;
    private Integer statusCode = HttpServletResponse.SC_OK;

    public CreateUser(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    @Step("{0} Inicia la acción de creación de usuario nuevo en la compañía")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                PostCreateUser.with(CreateUserBuilder.createUserRequest(name, job))
        );
        theActorInTheSpotlight().should(
                seeThat(messageValidation, actor1 -> actor.asksFor(getStatusCode()), equalTo(statusCode))
        );
    }

    public static CreateUser toCompany(String name, String job) {
        return instrumented(CreateUser.class, name, job);
    }

    public CreateUser withStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public CreateUser withValidationMessage(String messageValidation) {
        this.messageValidation = messageValidation;
        return this;
    }
}
