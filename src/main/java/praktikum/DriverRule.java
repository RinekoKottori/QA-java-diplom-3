package praktikum;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverRule extends ExternalResource {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @Override
    protected void before() throws Throwable {
        initDriver();
    }

    @Override
    protected void after() {
        driver.quit();
    }

    public void initDriver() {
        if ("firefox".equals(System.getProperty("browser"))) {
            initFirefox();
        } else if ("yandex".equals(System.getProperty("browser"))) {
            initYandex();
        }
        else {
            initChrome();
        }
        WebDriverRunner.setWebDriver(driver);
    }

    private void initFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    private void initChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    private void initYandex() {
        WebDriverManager.chromedriver().driverVersion("126.0.6478.0").setup();

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\kuzne\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");

        driver = new ChromeDriver(options);
    }
}
