package praktikum.client;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import praktikum.EnvConfig;

public class ClientEnvConfig extends EnvConfig {

    @Step("Send DELETE request to api/auth/user")
    @DisplayName("Delete a client")
    public void deleteClient(String token) {
        deleteClientSpec(token);
    }

    @Step("Send POST request to api/auth/login for authorize user")
    @DisplayName("Authorize a client")
    public Response authorizationClient(String email, String password) {
        ClientCredentials client = new ClientCredentials(email, password);
        return authorizeClient(client);
    }

    @Step("Send POST request to api/auth/register for creating user")
    @DisplayName("Register a client")
    public Response registrationNewClient(String name, String email, String password) {
        Client client = new Client(name, email, password);
        return spec()
                .body(client)
                .when()
                .post(CREATE_REGISTRATION_CLIENT);
    }
}
