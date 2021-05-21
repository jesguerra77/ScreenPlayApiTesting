package ApiRestAutomation.Factories;

import ApiRestAutomation.Models.CreateUserRequest;

public class CreateUserBuilder {

    public static CreateUserRequest createUserRequest(String name, String job) {
        return CreateUserRequest.builder()
                .name(name)
                .job(job)
                .build();
    }
}
