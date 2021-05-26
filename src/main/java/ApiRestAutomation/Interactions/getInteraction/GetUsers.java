package ApiRestAutomation.Interactions.getInteraction;

import ApiRestAutomation.Interactions.ApiAutomationInteraction;
import ApiRestAutomation.Models.GetUsersResponse;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUsers extends ApiAutomationInteraction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(RootApiPaths.LIST_USER.getUrlPath())
                        .with(requestSpecification -> rootBasicRequest())
        );
    }

    public static GetUsers fromApplication() {
        return instrumented(GetUsers.class);
    }

    public static Question<GetUsersResponse> getUsersResponse() {
        return new ResponseBody<>(GetUsersResponse.class);
    }
}
