package ApiRestAutomation.stepdefinitions;

public enum  Constants {

    VALID_NAME_MESSAGE("Validando el nombre del nuevo usuario creado"),
    VALID_DATE_MESSAGE("Validando la fecha de creación del usuario"),
    VALID_CREATE_USER_RESPONSE_MESSAGE("Validando que la respuesta de la solicitud de creación de usuario no este vacía"),
    VALID_CREATED_USER_SUCCESFUL("Validando la creación correcta del usuario"),
    VALID_CREATE_USER_FAILED("Validando que la creación no haya sido correcta"),
    VALID_GET_USERS("Validando que los usuarios puedan ser obtenidos"),
    VALID_ID_USER("Validando que el usuario corresponda al consultado"),
    VALID_NAME_USER("Validando que el nombre del usuario sea obtenido"),
    VALID_SALARY_USER("Validando que el salario del usuario sea obtenido"),
    VALID_AGE_USER("Validando que el año de nacimiento sea obtenido"),
    VALID_IMAGE_USER("Validando que la imagen del usuario sea obtenida"),
    VALID_DELETE_USER("Validando que el usuario pueda ser eliminado"),
    VALID_DELETE_USER_ERROR("Validando la solicitúd de eliminación no se realice"),
    VALID_EMPTY_RESPONSE("Validando que la respuesta a la solicitud no se genere "),
    VALID_UPDATE_USER("Validando la actualización del usuario"),
    EXPECT_DELETE_ERROR_MESSAGE("Error Occured! Page Not found, contact rstapi2example@gmail.com"),
    GET_DATA_USER("User Data filter");


    private final String message;


    Constants(String s) {
        this.message = s;
    }
    @Override
    public String toString(){
        return this.message;
    }
}
