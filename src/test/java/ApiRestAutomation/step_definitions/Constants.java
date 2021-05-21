package ApiRestAutomation.step_definitions;

public enum  Constants {

    VALID_NAME_MESSAGE("Validando el nombre del nuevo usuario creado"),
    VALID_JOB_MESSAGE("Validando el cargo del nuevo usuario creado"),
    VALID_ID_MESSAGE("Validando el id del nuevo usuario creado"),
    VALID_DATE_MESSAGE("Validando la fecha de creación del usuario"),
    VALID_CREATE_USER_RESPONSE_MESSAGE("Validando que la respuesta de la solicitud de creación de usuario no este vacía"),
    VALID_CREATED_USER_SUCCESFUL("Validando la creación correcta del usuario"),
    VALID_CREATE_USER_FAILED("Validando que la creación no haya sido correcta");

    private final String message;


    Constants(String s) {
        this.message = s;
    }
    @Override
    public String toString(){
        return this.message;
    }
}
