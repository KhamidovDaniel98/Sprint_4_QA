import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

import static config.Config.URL;

public class BaseTest {

            WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    //  this.driver = new ChromeDriver(); //проверка в Chrome
        driver = new FirefoxDriver();        //проверка в firefox
        this.driver.get(URL);

    }

    @After
    public void tearDown() {

        driver.quit();
    }
}

