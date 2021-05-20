package ApiRestAutomation.Interactions.utils;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;

public abstract class ApiInteraction implements Task{

    protected static class ResponseBody<T> implements Question<T> {
        private final Class<T> tClass;

        public ResponseBody(Class<T> tClass) {
            this.tClass = tClass;
        }

        @Override
        public T answeredBy(Actor actor) {
            return SerenityRest.lastResponse().body().jsonPath().getObject("", tClass);
        }
    }

    public static Question<Integer> getStatusCode() {
        return Question.about("Status Code").answeredBy(actor -> SerenityRest.lastResponse().getStatusCode());
    }


}
