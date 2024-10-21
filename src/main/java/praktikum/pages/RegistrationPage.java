package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static praktikum.EnvConfig.BASE_URL;

public class RegistrationPage {
    private final WebDriver driver;
    private final By fieldName = By.xpath("//label[text()='Имя']/following-sibling::input");
    private final By fieldEmail = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By fieldPassword = By.cssSelector("input[type='password']");
    private final By registrationButton = By.className("button_button_type_primary__1O7Bx");
    private final By linkSignIn = By.cssSelector("a[href='/login']");
    private final By errorMessagePassword = By.cssSelector("p.input__error");
    private final By registrationPageName = By.xpath("//h2[text()='Регистрация']");
    private final By registrationForm = By.cssSelector("form.Auth_form__3qKeq");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("open browser")
    public void openDriver() {
        open(BASE_URL);
    }

    @Step("Check is registration page open")
    public void isRegistrationPageOpen() {
        $(registrationPageName).shouldBe(visible).shouldHave(exactText("Регистрация"));
    }

    @Step("Enter user name")
    public void setName(String name) {
        $(fieldName).shouldBe(visible).sendKeys(Keys.CONTROL + "A");
        $(fieldName).sendKeys(Keys.BACK_SPACE);
        $(fieldName).sendKeys(name);
    }

    @Step("Check is user name correct")
    public void isNameCorrect(String name) {
        String actualName = $(fieldName).getAttribute("value");
        assertThat(actualName, equalTo(name));
    }

    @Step("Enter user email")
    public void setEmail(String email) {
        $(fieldEmail).shouldBe(visible).sendKeys(Keys.CONTROL + "A");
        $(fieldEmail).sendKeys(Keys.BACK_SPACE);
        $(fieldEmail).sendKeys(email);
    }

    @Step("Check is user name correct")
    public void isEmailCorrect(String email) {
        String actualEmail = $(fieldEmail).getAttribute("value");
        assertThat(actualEmail, equalTo(email));
    }

    @Step("Enter user password")
    public void setPassword(String password) {
        $(fieldPassword).shouldBe(visible).sendKeys(Keys.CONTROL + "A");
        $(fieldPassword).sendKeys(Keys.BACK_SPACE);
        $(fieldPassword).sendKeys(password);
    }

    @Step("Check is user password correct")
    public void isPasswordCorrect(String password) {
        String actualPassword = $(fieldPassword).getAttribute("value");
        assertThat(actualPassword, equalTo(password));
    }

    @Step("Check is user password incorrect")
    public void isPasswordIncorrect() {
        $(registrationForm).click();
        $(errorMessagePassword).shouldBe(visible).shouldHave(exactText("Некорректный пароль"));
    }

    @Step("Click on registration button 'Зарегистрироваться'")
    public void clickOnRegistrationButton() {
        $(registrationButton).shouldBe(visible).click();
    }

    @Step("Click on link-button 'Войти'")
    public void clickOnLinkSignIn() {
        $(linkSignIn).shouldBe(visible).click();
    }

}
