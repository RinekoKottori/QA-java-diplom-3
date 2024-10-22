package praktikum;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.client.CheckClient;
import praktikum.client.ClientEnvConfig;
import praktikum.pages.AuthorizationPage;
import praktikum.pages.MainPage;
import praktikum.pages.PersonalAccountPage;

public class PersonalAccountPageTest {
    private static WebDriver driver;
    Response response;

    @Rule
    public DriverRule factory = new DriverRule();

    @Before
    public void setUp() {
        driver = factory.getDriver();
        new PersonalAccountPage(driver).openBrowser();
        ClientEnvConfig clientEnvConfig = new ClientEnvConfig();
        response = clientEnvConfig.registrationNewClient("atrofiya", "atrofiya@yaya.com", "krak476");
    }

    @Test
    @DisplayName("Test log out button on personal account page")
    public void checkLogOutButton() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.clickOnButtonSignInAccount();
        authorizationPage.setEmail("atrofiya@yaya.com");
        authorizationPage.setPassword("krak476");
        authorizationPage.clickOnLoginButton();
        mainPage.isMainPageOpen();
        mainPage.clickOnButtonPersonalAccount();
        personalAccountPage.clickOnButtonLogOut();
        authorizationPage.isAuthorizationPageIsOpen();
    }

    @Test
    @DisplayName("Test logo button on personal account page")
    public void checkLogoButtonStellarBurger() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.clickOnButtonSignInAccount();
        authorizationPage.setEmail("atrofiya@yaya.com");
        authorizationPage.setPassword("krak476");
        authorizationPage.clickOnLoginButton();
        mainPage.clickOnButtonPersonalAccount();
        personalAccountPage.clickOnLogoButtonStellarBurger();
        mainPage.isMainPageOpen();
    }

    @Test
    @DisplayName("Test Constructor button on personal account page")
    public void checkButtonConstructor() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.clickOnButtonSignInAccount();
        authorizationPage.setEmail("atrofiya@yaya.com");
        authorizationPage.setPassword("krak476");
        authorizationPage.clickOnLoginButton();
        mainPage.clickOnButtonPersonalAccount();
        personalAccountPage.clickOnButtonConstructor();
        mainPage.isMainPageOpen();
    }

    @After
    public void tearDown() {
        CheckClient checkClient = new CheckClient();
        ClientEnvConfig clientEnvConfig = new ClientEnvConfig();
        clientEnvConfig.authorizationClient("atrofiya@yaya.com", "krak476");
        String token = checkClient.getOkForAuthorizationClient(response);
        clientEnvConfig.deleteClient(token);
    }
}
