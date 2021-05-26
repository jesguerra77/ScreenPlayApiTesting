package ApiRestAutomation.Questions;

import ApiRestAutomation.Interactions.getInteraction.GetUsers;
import ApiRestAutomation.Models.Datum;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.stream.Collectors;

public class SearchUser implements Question<List<Datum>> {
    private String idUser;

    public SearchUser(String idUser) {
        this.idUser = idUser;
    }

    @Override
    public List<Datum> answeredBy(Actor actor) {
        List<Datum> usersResponseData = actor.asksFor(GetUsers.getUsersResponse()).getData();

        return usersResponseData.stream()
                .filter(p -> p.getId().equals((Integer.parseInt(idUser))))
                .map(p -> new Datum(p.getId(), p.getEmployee_name(), p.getEmployee_salary(), p.getEmployee_age(), p.getProfile_image()))
                .collect(Collectors.toList());
    }

    public static SearchUser with(String idUser) {
        return Instrumented.instanceOf(SearchUser.class).withProperties(idUser);
    }
}
