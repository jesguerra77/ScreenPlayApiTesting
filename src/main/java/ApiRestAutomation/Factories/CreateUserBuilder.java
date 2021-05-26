package ApiRestAutomation.Factories;

import ApiRestAutomation.Models.CreateUserRequest;

public class CreateUserBuilder {

    public static CreateUserRequest createUserRequest(String name, String salary, String age) {
        return CreateUserRequest.builder()
                .name(name)
                .salary(salary)
                .age(age)
                .build();
    }
}
