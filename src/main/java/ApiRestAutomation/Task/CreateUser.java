package ApiRestAutomation.Task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateUser implements Task {

    private String messageValidation;
    private Integer statusCode;

    @Override
    @Step("{0} Iniciar la acción de creación de usuario nuevo en la compañía")
    public <T extends Actor> void performAs(T actor) {


    }
    public static CreateUser toCompany(){
        return instrumented(CreateUser.class);
    }
}
