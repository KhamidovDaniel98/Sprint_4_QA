package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class MainPageSamokat {
    private final WebDriver driver;


    //Кнопка заказать вверху
    final By upperOrderButton = By.className("Button_Button__ra12g");

    //Кнопка заказать внизу
    final By lowerOrderButton = By.xpath(".//*[@id='root']//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Кнопка кук
    final By cookiesApprove = By.id("rcc-confirm-button");

    //Текст в FAQ
    final By importantTextField = By.xpath(".//*[@class='accordion__panel' and not(@hidden)]/p");

    //Заголовок для раскрывающегося блока
    private final By accordionHeaders = By.className("accordion__heading");

    //Абзац в раскрывающемся блоке
    private final By accordionItems = By.xpath(".//div[@class='accordion__panel']/p");

    //Кнопка "Принять куки"
    private final By cookieAcceptButton = By.id("rcc-confirm-button");


    public MainPageSamokat(WebDriver driver) {

        this.driver = driver;
    }


    //Метод для нажатия на кнопку "Принять куки"
    public void clickOnCookieAcceptButton() {

        this.driver.findElement(this.cookieAcceptButton).click();
    }



    //Метод для получения текста на заголовке блока в аккордеона
    public String getAccordionHeaderText (int index) {
        return this.driver.findElements(this.accordionHeaders).get(index).getText();
    }

    //Методя для получения текста из раскрывающегося блока в аккордеоне
    public String getAccordionItemText(int index) {
        return this.driver.findElements(this.accordionItems).get(index).getText();
    }

    //Метод для ожидания загрузки элемента аккордеона
    public void waitForLoadItem(int index) {
        new WebDriverWait(this.driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(this.driver.findElements(this.accordionItems).get(index)));
    }

    //Метод для нажатия на заголовок блока в аккордеоне
    public void clickAccordionHeader(int index) {
        this.driver.findElements(this.accordionHeaders).get(index).click();
    }

    //Метод для проверки раскрытия блока аккордеона
    public boolean isAccordionItemDisplayed(int index) {
        return this.driver.findElements(this.accordionItems).get(index).isDisplayed();
    }


    //Метод подтверждение кук
    public void setCookiesApprove() {

        driver.findElement(cookiesApprove).click();
    }

    // метод нажатие на заказ сверху страницы
    public void createOrderWithUpperButton() {

        driver.findElement(upperOrderButton).click();
    }

    // метод нажатие на заказ снизу страницы
    public void createOrderWithLowerButton() {

        driver.findElement(lowerOrderButton).click();
    }
}
