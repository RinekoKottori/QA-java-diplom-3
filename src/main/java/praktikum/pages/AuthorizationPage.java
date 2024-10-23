package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AuthorizationPage {
    private final WebDriver driver;
    private final By fieldEmail = By.cssSelector("input[type='text']");
    private final By fieldPassword = By.cssSelector("input[type='password']");
    private final By buttonLogin = By.className("button_button_size_medium__3zxIa");
    private final By nameOfAuthorizePage = By.xpath("//h2[text()='Вход']");
    private final By registrationLink = By.cssSelector("a[href='/register']");
    private final By forgotPasswordLink = By.cssSelector("a[href='/forgot-password']");

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check is authorization page is open")
    public void isAuthorizationPageIsOpen() {
        $(nameOfAuthorizePage).shouldBe(visible).shouldHave(exactText("Вход"));
    }

    @Step("Enter user email")
    public void setEmail(String email) {
        $(fieldEmail).shouldBe(visible).sendKeys(Keys.CONTROL + "A");
        $(fieldEmail).sendKeys(Keys.BACK_SPACE);
        $(fieldEmail).setValue(email);
    }

    @Step("Check is user email is correct")
    public void isEmailCorrect(String email) {
        String actualEmail = $(fieldEmail).getAttribute("value");
        assertThat(actualEmail, equalTo(email));
    }

    @Step("Enter user password")
    public void setPassword(String password) {
        $(fieldPassword).shouldBe(visible).sendKeys(Keys.CONTROL + "A");
        $(fieldPassword).sendKeys(Keys.BACK_SPACE);
        $(fieldPassword).setValue(password);
    }

    @Step("Check is user password is correct")
    public void isPasswordCorrect(String password) {
        String actualPassword = $(fieldPassword).getAttribute("value");
        assertThat(actualPassword, equalTo(password));
    }

    @Step("Click on login button 'Войти'")
    public void clickOnLoginButton() {
        $(buttonLogin).shouldBe(visible).click();
    }

    @Step("Click on link-button 'Зарегистрироваться'")
    public void clickOnRegistrationLink() {
        $(registrationLink).shouldBe(visible).click();
    }

    @Step("Click on link-button 'Восстановить пароль'")
    public void clickOnForgotPasswordLink() {
        $(forgotPasswordLink).shouldBe(visible).click();
    }

}

