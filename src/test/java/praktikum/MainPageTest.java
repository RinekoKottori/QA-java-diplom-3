package praktikum;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.client.CheckClient;
import praktikum.client.ClientEnvConfig;
import praktikum.pages.AuthorizationPage;
import praktikum.pages.MainPage;
import praktikum.pages.PersonalAccountPage;

//Проверка главной страницы
public class MainPageTest {
    private static WebDriver driver;
    Response response;

    @Rule
    public DriverRule factory = new DriverRule();

    @Before
    public void setUp() {
        driver = factory.getDriver();
        new MainPage(driver).openBrowser();
    }


    @Test
    @DisplayName("Test button Personal account without authorization")
    public void checkPersonalAccountButtonWithoutAuth() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnButtonPersonalAccount();
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.isAuthorizationPageIsOpen();
    }

    @Test
    @DisplayName("Test button Personal account with authorization")
    public void checkPersonalAccountButtonWithAuth() {
        ClientEnvConfig clientEnvConfig = new ClientEnvConfig();
        response = clientEnvConfig.registrationNewClient("atrofiya", "atrofiya@yaya.com", "krak476");
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.clickOnButtonSignInAccount();
        authorizationPage.setEmail("atrofiya@yaya.com");
        authorizationPage.setPassword("krak476");
        authorizationPage.clickOnLoginButton();
        mainPage.isMainPageOpen();
        mainPage.clickOnButtonPersonalAccount();
        personalAccountPage.isPersonalAccountPageOpen();
        CheckClient checkClient = new CheckClient();
        clientEnvConfig.authorizationClient("atrofiya@yaya.com", "krak476");
        String token = checkClient.getOkForAuthorizationClient(response);
        clientEnvConfig.deleteClient(token);
    }

    @Test
    @DisplayName("Test sauce section can be selected")
    public void checkSectionSauce() {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectSauceSection();
        mainPage.isSauceSectionSelected();
    }

    @Test
    @DisplayName("Test bun section can be selected")
    public void checkSectionBun() {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectBunSection();
        mainPage.isBunSectionSelected();
    }

    @Test
    @DisplayName("Test main section can be selected")
    public void checkSectionMain() {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainSection();
        mainPage.isMainSectionSelected();
    }
}
