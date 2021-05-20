package ApiRestAutomation.Interactions;

import ApiRestAutomation.Interactions.utils.ApiInteraction;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import static net.serenitybdd.rest.SerenityRest.given;

public abstract class ApiAutomationInteraction extends ApiInteraction {
    static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    static final String urlBase = variables.getProperty("env.base.url");

    public static RequestSpecification rootBasicRequest() {
        return given()
                .baseUri(urlBase)
                .contentType("application/json; charset=UTF-8");
    }

    protected enum RootApiPaths {

        CREATE_USER("/api/users"),
        DELETE_USER("/api/users/2"),
        UPDATE_USER("/api/users/2"),
        LIST_USER("/api/users?page={page}"),
        ;
        private String urlPath;


        RootApiPaths(String urlPath) {
            this.urlPath = urlPath;
        }

        public String getUrlPath() {
            return urlPath;
        }
    }
}
