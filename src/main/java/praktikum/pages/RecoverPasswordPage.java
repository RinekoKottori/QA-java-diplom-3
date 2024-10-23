package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoverPasswordPage {
    private final WebDriver driver;
    private final By linkSignIn = By.cssSelector("a[href='/login']");
    private final By headerOfRecoverPasswordPage = By.xpath("//h2[text()='Восстановление пароля']");

    public RecoverPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on link-button 'Вход'")
    public void clickOnSignInLink() {
        $(linkSignIn).shouldBe(visible).click();
    }

    @Step("Check is recovery password page open")
    public void isRecoverPasswordPageOpen() {
        $(headerOfRecoverPasswordPage).shouldBe(visible)
                .shouldHave(exactText("Восстановление пароля"));
    }
}
