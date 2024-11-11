package praktikum;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import praktikum.client.CheckClient;
import praktikum.client.ClientEnvConfig;
import praktikum.pages.AuthorizationPage;
import praktikum.pages.MainPage;
import praktikum.pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static praktikum.EnvConfig.BASE_URL;

//тест написан с учётом добавления новых правил в тз о корректных email, name и password для успешной регистрации;
@RunWith(Parameterized.class)
public class PositiveRegistrationTest {
    private static WebDriver driver;
    private final String name;
    private final String email;
    private final String password;

    @ClassRule
    public static DriverRule factory = new DriverRule();

    public PositiveRegistrationTest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @BeforeClass
    public static void setUp() {
        driver = factory.getDriver();
        open(BASE_URL);
        new MainPage(driver).clickOnButtonSignInAccount();
        new AuthorizationPage(driver).clickOnRegistrationLink();
    }

    @Parameterized.Parameters
    public static Object[][] registrationData() {
        return new Object[][]{
                {"Barkas", "Barkasov@yaya.com", "naturelBlond"}
        };
    }

    @Test
    @DisplayName("Test positive registration")
    public void registrationClient() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.setName(name);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);
        registrationPage.clickOnRegistrationButton();
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.isAuthorizationPageIsOpen();
        authorizationPage.setEmail(email);
        authorizationPage.isEmailCorrect(email);
        authorizationPage.setPassword(password);
        authorizationPage.isPasswordCorrect(password);
        authorizationPage.clickOnLoginButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.isMainPageOpenAnAuthUser();
    }

    @After
    public void tearDown() {
        CheckClient checkClient = new CheckClient();
        ClientEnvConfig clientEnvConfig = new ClientEnvConfig();
        Response response = clientEnvConfig.authorizationClient(email, password);
        String token = checkClient.getOkForAuthorizationClient(response);
        clientEnvConfig.deleteClient(token);
    }
}
