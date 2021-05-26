package ApiRestAutomation.Task;

import ApiRestAutomation.Factories.CreateUserBuilder;
import ApiRestAutomation.Interactions.putInteraction.PutUpdateUsers;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static ApiRestAutomation.Interactions.utils.ApiInteraction.getStatusCode;
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.Matchers.equalTo;

public class UpdateUser implements Task {
    private String idUser;
    private String name;
    private String salary;
    private String age;
    private String messageValidation;
    private Integer statusCode = SC_OK;

    public UpdateUser(String idUser, String name, String salary, String age) {
        this.idUser = idUser;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    @Override
    @Step("{0} inicia el proceso de actualización del usuario")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PutUpdateUsers.with(
                        idUser, CreateUserBuilder.createUserRequest(name, salary, age))
        );
        actor.should(
                seeThat(messageValidation, actorSee -> actor.asksFor(getStatusCode()), equalTo(statusCode))
        );
    }

    public static UpdateUser with(String idUser, String name, String salary, String age) {
        return instrumented(UpdateUser.class, idUser, name, salary, age);
    }

    public UpdateUser whitStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public UpdateUser withMessageValidation(String messageValidation) {
        this.messageValidation = messageValidation;
        return this;
    }
}
