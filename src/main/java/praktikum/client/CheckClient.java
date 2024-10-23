package praktikum.client;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.CoreMatchers.equalTo;

public class CheckClient {
    @Step("Verify that client authorized and status code 200")
    public String getOkForAuthorizationClient(Response response) {
        String token = response.then()
                .assertThat()
                .statusCode(HTTP_OK)
                .and().body("success", equalTo(true))
                .and().extract().body().path("accessToken");
        return token.substring(7);
    }
}
