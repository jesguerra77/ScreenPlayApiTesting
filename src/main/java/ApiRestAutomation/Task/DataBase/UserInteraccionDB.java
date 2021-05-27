package ApiRestAutomation.Task.DataBase;

import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;


import java.sql.Statement;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UserInteraccionDB implements Task {

    private Statement statement;
    private String sqlQuery;

    public UserInteraccionDB(Statement statement, String sqlQuery) {
        this.statement = statement;
        this.sqlQuery = sqlQuery;
    }

    @SneakyThrows
    @Override
    @Step("0 genera la conección con la base de datos")
    public <T extends Actor> void performAs(T actor) {
        statement.execute(sqlQuery);
        statement.close();
    }

    public static UserInteraccionDB with(Statement statement, String sqlQuery) {
        return instrumented(UserInteraccionDB.class, statement, sqlQuery);
    }
}
