package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pages.AuthorizationPage;
import praktikum.pages.MainPage;
import praktikum.pages.RecoverPasswordPage;
import praktikum.pages.RegistrationPage;

public class SignInButtonsTest {
    private static WebDriver driver;
    @ClassRule
    public static DriverRule factory = new DriverRule();

    @BeforeClass
    public static void setUp() {
        driver = factory.getDriver();
        new MainPage(driver).openBrowser();
    }

    @Test
    @DisplayName("Test button 'sign in personal account' on main page")
    public void checkButtonSignInPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnButtonSignInAccount();
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.isAuthorizationPageIsOpen();
    }

    @Test
    @DisplayName("Test button 'sign in' on registration page")
    public void checkLinkSingInOnRegistrationPage() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.clickOnButtonSignInAccount();
        authorizationPage.clickOnRegistrationLink();
        registrationPage.isRegistrationPageOpen();
        registrationPage.clickOnLinkSignIn();
        authorizationPage.isAuthorizationPageIsOpen();

    }

    @Test
    @DisplayName("Test button 'sign in' on recovery password page")
    public void checkLinkSingInOnRecoverPasswordPage() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage(driver);
        mainPage.clickOnButtonSignInAccount();
        authorizationPage.clickOnForgotPasswordLink();
        recoverPasswordPage.isRecoverPasswordPageOpen();
        recoverPasswordPage.clickOnSignInLink();
        authorizationPage.isAuthorizationPageIsOpen();
    }
}
