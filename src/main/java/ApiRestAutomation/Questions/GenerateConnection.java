package ApiRestAutomation.Questions;

import com.google.inject.internal.cglib.core.$ReflectUtils;
import lombok.SneakyThrows;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.sql.Connection;
import java.sql.DriverManager;


public class GenerateConnection implements Question<Connection> {

    private String host;
    private String user;
    private String password;

    public GenerateConnection(String host, String user, String password) {
        this.host = host;
        this.user = user;
        this.password = password;
    }

    @SneakyThrows
    @Override
    public Connection answeredBy(Actor actor) {
        return DriverManager.getConnection(host, user, password);
    }

    public static GenerateConnection toDataBase(String host, String user, String password) {
        return Instrumented.instanceOf(GenerateConnection.class).withProperties(host, user, password);
    }
}
