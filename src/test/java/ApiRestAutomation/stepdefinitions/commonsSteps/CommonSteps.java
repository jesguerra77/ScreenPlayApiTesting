package ApiRestAutomation.stepdefinitions.commonsSteps;

import ApiRestAutomation.Database.Querys.Querys;
import ApiRestAutomation.Questions.GenerateConnection;
import ApiRestAutomation.Task.DataBase.UserInteraccionDB;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import java.sql.SQLException;
import java.sql.Statement;

import static net.serenitybdd.screenplay.actors.OnStage.*;


public class CommonSteps {

    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    final String urlBase = variables.getProperty("env.base.url1");
    Statement statement;

    @Given("como administrador quiero validar los permisos en el sistema$")
    public void theAdminCanCreateUser() {
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(urlBase)));
    }

    @Given("como (.*) quiero conectarme a la base de datos$")
    public void theAdminCanUseDB(String userAdmin) throws SQLException {
        final String urlDB = variables.getProperty("hostBd");
        final String user = variables.getProperty("user");
        final String password = variables.getProperty("password");
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(urlBase)));
        theActorCalled(userAdmin).entersTheScene();
        statement = theActorInTheSpotlight().asksFor(GenerateConnection.toDataBase(urlDB, user, password)).createStatement();
    }

    @When("(.*) inserta un usuario en la base datos con los datos (.*) (.*) (.*) (.*)$")
    public void insertaUnUsuarioEnLaBaseDatos(String userAdmin, String idUser, String name, String months, String salary) {
        theActorInTheSpotlight().attemptsTo(
                UserInteraccionDB.with(statement, Querys.INSERT.toString().replace(
                        "{idEmpleado}", idUser).replace("{nombre}", name).replace("{meses}", months).replace("{salario}", salary))
        );
    }

    @When("(.*) quiere consultar los usuarios que tengan un salario mayor a (.*) y tengan menos de (.*) en la compañia$")
    public void quiereConsultarLosUsuariosQueTenganUnSalarioMayorASalarioYTenganMenosDeMesesEnLaCompañia(String userAdmin, String salary, String months) {
        theActorInTheSpotlight()
                .attemptsTo(UserInteraccionDB.with(statement, Querys.WHERE.toString().replace("{salario}", salary).replace("{meses}", months)));
    }
}
