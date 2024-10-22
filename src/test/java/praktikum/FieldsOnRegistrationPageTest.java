package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.client.Client;
import praktikum.pages.AuthorizationPage;
import praktikum.pages.MainPage;
import praktikum.pages.RegistrationPage;

//Проверка полей
public class FieldsOnRegistrationPageTest {
    private static WebDriver driver;

    @ClassRule
    public static DriverRule factory = new DriverRule();

    @BeforeClass
    public static void setUp() {
        driver = factory.getDriver();
        new RegistrationPage(driver).openDriver();
        new MainPage(driver).clickOnButtonSignInAccount();
        new AuthorizationPage(driver).clickOnRegistrationLink();
    }

    @Test
    @DisplayName("Test field 'Name'")
    public void checkFieldName() {
        var password = Client.randomClient().getPassword();
        var registrationPage = new RegistrationPage(driver);
        registrationPage.setName(password);
        registrationPage.isNameCorrect(password);
    }

    @Test
    @DisplayName("Test field 'Email'")
    public void checkFieldEmail() {
        var email = Client.randomClient().getEmail();
        var registrationPage = new RegistrationPage(driver);
        registrationPage.setEmail(email);
        registrationPage.isEmailCorrect(email);
    }

    @Test
    @DisplayName("Test field 'Password'")
    public void checkFieldPassword() {
        var password = Client.randomClient().getPassword();
        var registrationPage = new RegistrationPage(driver);
        registrationPage.setPassword(password);
        registrationPage.isPasswordCorrect(password);
    }

    @Test
    @DisplayName("Test field 'Password' get error when length of password < 6")
    public void checkIncorrectPassword() {
        var password = Client.randomClientIncorrectPassword().getPassword();
        var registrationPage = new RegistrationPage(driver);
        registrationPage.setPassword(password);
        registrationPage.isPasswordIncorrect();
    }
}
