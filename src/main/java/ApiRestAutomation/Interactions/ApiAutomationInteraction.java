package ApiRestAutomation.Interactions;

import ApiRestAutomation.Interactions.utils.ApiInteraction;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static net.serenitybdd.rest.SerenityRest.given;

public abstract class ApiAutomationInteraction extends ApiInteraction {


    protected static RequestSpecification rootBasicRequest() {
        return given()
                .contentType(ContentType.JSON)
                .header("header1","value1");
    }

    protected enum RootApiPaths {

        CREATE_USER("/create"),
        DELETE_USER("/delete/{id}"),
        UPDATE_USER("/update/{id}"),
        LIST_USER("/employees"),
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
