package ApiRestAutomation.Interactions;

import ApiRestAutomation.Interactions.utils.ApiInteraction;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static net.serenitybdd.rest.SerenityRest.with;

public abstract class ApiAutomationInteraction extends ApiInteraction {


    protected static RequestSpecification rootBasicRequest() {
        return with()
                .contentType(ContentType.JSON)
                .accept("*/*");
    }

    protected enum RootApiPaths {

        CREATE_USER("/users"),
        DELETE_USER("/users/2"),
        UPDATE_USER("/users/2"),
        LIST_USER("/users?page={page}"),
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
