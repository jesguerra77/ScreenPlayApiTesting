package ApiRestAutomation.Interactions.db;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InteractWithDb implements Ability {

    private static Connection connection;

    public InteractWithDb(Connection connection) {
        InteractWithDb.connection = connection;
    }

    public static Connection fromPostGresSql(String host, String user, String pass) throws SQLException {
        return connection = DriverManager.getConnection(host, user, pass);
    }

    public static InteractWithDb as(Actor actor) {
        return actor.abilityTo(InteractWithDb.class);
    }
}
