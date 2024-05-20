
import org.junit.runner.RunWith;
import org.junit.Test;
import page_object.MainPageSamokat;
import org.junit.runners.Parameterized;
import page_object.OrderPageSamokat;


@RunWith(Parameterized.class)
public class OrderCreationTest extends BaseTest {

    public String name;
    public String lastName;
    public String address;
    public int metroListItem;
    public String phoneNumber;
    public String date;
    public int rentalPeriodItem;
    public String color;
    public String comment;


    public OrderCreationTest(String name,
                             String lastName,
                             String address,
                             int metroListItem,
                             String phoneNumber,
                             String date,
                             int rentalPeriodItem,
                             String color,
                             String comment) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metroListItem = metroListItem;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentalPeriodItem = rentalPeriodItem;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] createOrders() {
        return new Object[][]{
                {"Даниэл", "Хамидов", "Ханты-Мансийск, ул.Мира 27", 2, "+79227658380", "20.05.2024", 0, "black", "Хочу кататься"},
                {"Даниэлян", "Хамимедов", "Ханты-Мансийск, ул.Мира 27", 3, "+79227658380", "21.05.2024", 5, "grey", "Ууу"},

        };
    }


    @Test
    public void checkOrderCreationWithUpperButton() {


        MainPageSamokat mainPage = new MainPageSamokat(driver);
        mainPage.setCookiesApprove();
        mainPage.createOrderWithUpperButton();

        OrderPageSamokat orderPage = new OrderPageSamokat(driver);
        orderPage.createOrder(name, lastName, address, metroListItem, phoneNumber, date, rentalPeriodItem, color, comment);
        orderPage.checkOrderStatus("Заказ оформлен");


    }

    @Test
    public void checkOrderCreationWithLowerButton() {


        MainPageSamokat mainPage = new MainPageSamokat(driver);
        mainPage.setCookiesApprove();
        mainPage.createOrderWithLowerButton();

        OrderPageSamokat orderPage = new OrderPageSamokat(driver);
        orderPage.createOrder(name, lastName, address, metroListItem, phoneNumber, date, rentalPeriodItem, color, comment);
        orderPage.checkOrderStatus("Заказ оформлен");


    }


}
