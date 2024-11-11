package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static praktikum.EnvConfig.BASE_URL;

public class MainPage {
    private final WebDriver driver;
    private final By buttonPersonalAccount = By.xpath("//p[text()='Личный Кабинет']");
    private final By buttonSignInAccount = By.className("button_button__33qZ0");
    private final By bun = By.xpath("//span[text()='Булки']");
    private final By sauce = By.xpath("//span[text()='Соусы']");
    private final By main = By.xpath("//span[text()='Начинки']");
    private final By constructorPageHeadName = By.className("text_type_main-large");
    private final By SelectedBun = By.xpath("//section[@class = 'BurgerIngredients_ingredients__1N8v2']/div[1]/div[1]");
    private final By SelectedSauce = By.xpath("//section[@class = 'BurgerIngredients_ingredients__1N8v2']/div[1]/div[2]");
    private final By SelectedMain = By.xpath("//section[@class = 'BurgerIngredients_ingredients__1N8v2']/div[1]/div[3]");
    private final String selectedSectionClass = "tab_tab_type_current__2BEPc";
    private final By authorizeMainPage = By.className("button_button_type_primary__1O7Bx");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open browser")
    public void openBrowser() {
        open(BASE_URL);
    }

    @Step("Check is main page open")
    public void isMainPageOpen() {
        $(constructorPageHeadName).shouldBe(visible).shouldHave(exactText("Соберите бургер"));
    }

    @Step("Check if the main page is open as an authorized user")
    public void isMainPageOpenAnAuthUser() {
        $(authorizeMainPage).shouldBe(visible).shouldHave(exactText("Оформить заказ"));
    }

    @Step("Click on button personal account 'Личный кабинет'")
    public void clickOnButtonPersonalAccount() {
        $(buttonPersonalAccount).shouldBe(visible).click();
    }

    @Step("Click on button Sign in account 'Войти в аккаунт'")
    public void clickOnButtonSignInAccount() {
        $(buttonSignInAccount).shouldBe(visible).click();
    }

    @Step("Select bun section")
    public void selectBunSection() {
        $(sauce).shouldBe(visible).click();
        $(bun).shouldBe(visible).click();
    }

    @Step("Check is bun section selected")
    public void isBunSectionSelected() {
        $(SelectedBun).shouldHave(cssClass(selectedSectionClass));
    }

    @Step("Select sauce section")
    public void selectSauceSection() {
        $(sauce).shouldBe(visible).click();
    }

    @Step("Check is sauce section selected")
    public void isSauceSectionSelected() {
        $(SelectedSauce).shouldHave(cssClass(selectedSectionClass));
    }

    @Step("Select main section")
    public void selectMainSection() {
        $(main).shouldBe(visible).click();
    }

    @Step("Check is main section selected")
    public void isMainSectionSelected() {
        $(SelectedMain).shouldHave(cssClass(selectedSectionClass));
    }

}
