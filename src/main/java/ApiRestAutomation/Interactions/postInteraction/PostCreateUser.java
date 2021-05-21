package ApiRestAutomation.Interactions.postInteraction;

import ApiRestAutomation.Interactions.ApiAutomationInteraction;
import ApiRestAutomation.Models.CreateUserRequest;
import ApiRestAutomation.Models.CreateUserResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostCreateUser extends ApiAutomationInteraction {

    private CreateUserRequest createUserRequestBuilder;

    public PostCreateUser(CreateUserRequest createUserRequestBuilder) {
        this.createUserRequestBuilder = createUserRequestBuilder;
    }

    @Override
    @Step("{0} Realiza la creación del usuario nuevo")
    public <T extends Actor> void performAs(T actor) {

//        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
//        String urlBase = variables.getProperty("env.base.url");
//        String finalUrl = urlBase.concat(RootApiPaths.CREATE_USER.getUrlPath());
//        String otherUrl = finalUrl.replace("'","");

        actor.attemptsTo(
                Post.to(RootApiPaths.CREATE_USER.getUrlPath())
                        .with(requestSpecification -> rootBasicRequest()
                                .body(createUserRequestBuilder))
        );
    }

    public static PostCreateUser with(CreateUserRequest createUserRequestBuilder) {
        return instrumented(PostCreateUser.class, createUserRequestBuilder);
    }

    public static Question<CreateUserResponse> getCreateResponse() {
        return new ResponseBody<>(CreateUserResponse.class);
    }
}
