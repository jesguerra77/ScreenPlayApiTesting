package ApiRestAutomation.Task.DataBase;

import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;


import java.sql.Statement;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserInteraccionDB implements Task {

    private static Logger logger = LoggerFactory.getLogger(UserInteraccionDB.class);
    private Statement statement;
    private String sqlQuery;

    public UserInteraccionDB(Statement statement, String sqlQuery) {
        this.statement = statement;
        this.sqlQuery = sqlQuery;
    }

    @SneakyThrows
    @Override
    @Step("0 genera la conexión con la base de datos")
    public <T extends Actor> void performAs(T actor) {

        if (statement != null) {
            statement.execute(sqlQuery);
            statement.close();
            logger.info("La conexión con la bd fue exitosa y se realizó la ejecución del script");
        } else
            throw new AssertionError("No fue posible realizar la operación en la base de datos");
    }

    public static UserInteraccionDB with(Statement statement, String sqlQuery) {
        return instrumented(UserInteraccionDB.class, statement, sqlQuery);
    }
}
