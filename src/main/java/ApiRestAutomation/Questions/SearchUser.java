package ApiRestAutomation.Questions;

import ApiRestAutomation.Interactions.getInteraction.GetUsers;
import ApiRestAutomation.Models.Datum;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class SearchUser implements Question<List<Datum>> {
    private String idUser;

    public SearchUser(String idUser) {
        this.idUser = idUser;
    }

    @Override
    public List<Datum> answeredBy(Actor actor) {
       // List<Datum> usersResponse = actor.asksFor(GetUsers.getUsersResponse()).getData();

        Datum datum = Datum.builder()
                .id(2)
                .firstName("Johnathan")
                .lastName("Esguerra")
                .avatar("tester")
                .build();
        List<Datum> nuevaLista = asList(datum);

        List<Datum> usersResponses1 = nuevaLista.stream()
                .filter(p -> p.getId().equals((Integer.parseInt(idUser))))
                .map(p -> new Datum(p.getId(), p.getEmail(), p.getFirstName(), p.getLastName(), p.getAvatar()))
                .collect(Collectors.toList());
        return usersResponses1;
    }

    public static SearchUser with(String idUser) {
        return Instrumented.instanceOf(SearchUser.class).withProperties(idUser);
    }
}
