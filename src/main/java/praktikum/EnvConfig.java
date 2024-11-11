package praktikum;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import praktikum.client.ClientCredentials;

import static io.restassured.RestAssured.given;

public class EnvConfig {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    public static final int IMPLICIT_WAIT = 5;
    public static final String ACTIONS_CLIENT = "/api/auth/user";
    public static final String AUTHORIZATION_CLIENT = "/api/auth/login";
    public static final String CREATE_REGISTRATION_CLIENT = "/api/auth/register";

    public RequestSpecification spec() {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL);
    }

    protected Response authorizeClient(ClientCredentials client) {
        return spec()
                .when()
                .body(client)
                .post(AUTHORIZATION_CLIENT);
    }

    protected void deleteClientSpec(String token) {
        spec()
                .auth().oauth2(token)
                .when()
                .delete(ACTIONS_CLIENT);
    }
}
