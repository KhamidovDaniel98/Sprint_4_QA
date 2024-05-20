package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.ArrayList;
import java.util.List;


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

    public MainPageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    //Подтверждение кук
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


    //метод получения текстов из списка о важном
    public List<String> getTextFromImportantList() {
        List<WebElement> elements = driver.findElements(By.className("accordion__button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elements.get(0));

        ArrayList<String> listOfTexts = new ArrayList<String>();
        for (WebElement element : elements) {
            element.click();
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            String textField = driver.findElement(importantTextField).getText();
            listOfTexts.add(textField);
        }

        return listOfTexts;
    }




}
