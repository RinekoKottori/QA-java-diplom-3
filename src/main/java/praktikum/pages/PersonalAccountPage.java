package praktikum.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static praktikum.EnvConfig.BASE_URL;

public class PersonalAccountPage {
    private final WebDriver driver;
    private final By buttonConstructor = By.xpath("//p[text()='Конструктор']");
    private final By logoButtonStellarBurger = By.className("AppHeader_header__logo__2D0X2");
    private final By buttonLogOut = By.className("Account_button__14Yp3");
    private final By descriptionOfPersonalAccountPage = By.className("Account_text__fZAIn");

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open browser")
    public void openDriver() {
        open(BASE_URL);
    }

    @Step("Check is personal account open")
    public void isPersonalAccountPageOpen() {
        $(descriptionOfPersonalAccountPage).shouldBe(Condition.visible)
                .shouldHave(exactText("В этом разделе вы можете изменить свои персональные данные"));
    }

    @Step("Click on button 'Конструктор'")
    public void clickOnButtonConstructor() {
        $(buttonConstructor).shouldBe(visible).click();
    }

    @Step("Click on logo Stellar Burgers")
    public void clickOnLogoButtonStellarBurger() {
        $(logoButtonStellarBurger).shouldBe(visible).click();
    }

    @Step("Click on button log out 'Выход'")
    public void clickOnButtonLogOut() {
        $(buttonLogOut).shouldBe(visible).click();
    }

}
