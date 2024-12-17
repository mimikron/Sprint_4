package ru.praktikum_services.qa_scooter;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikum_services.qa_scooter.modals.AcceptModal;
import ru.praktikum_services.qa_scooter.modals.PlacedOrderModal;
import ru.praktikum_services.qa_scooter.pages.SamokatHomePage;
import ru.praktikum_services.qa_scooter.pages.OrderPage;
import org.junit.After;

@RunWith(Parameterized.class)
public class OrdersTest extends TestCase {

    private WebDriver driver;

    //Имя
    private final String name;
    //Фамилия
    private final String surname;
    //Адрес
    private final String address;
    //Станция метро
    private final String station;
    //Телефон
    private final String phone;
    //Верхняя кнопка заказать
    private final boolean orderButtonTop;
    //Дата доставки
    private final String arriveDate;
    //Срок аренды
    private final String rentTime;
    //Цвет
    private final String colour;
    // Комментарий
    private final String comment;

    public OrdersTest(String name, String surname, String address, String station, String phone, boolean orderButtonTop, String arriveDate, String rentTime, String colour, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.station = station;
        this.phone = phone;
        this.orderButtonTop = orderButtonTop;
        this.arriveDate = arriveDate;
        this.rentTime = rentTime;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrders() {
        //Тестовые данные
        return new Object[][] {
                {"Николай", "Лапшин", "Россия, г. Самара, пр-т Проспекта, д. 26", "Черкизовская", "+71111111111", true, "27.12.2024", "четверо суток", "BLACK", "комментарий"},
                {"Олег", "Хлебнов", "Россия, г. Самара, ул. Ленина, д. 36", "Новокузнецкая", "+7222222222", false, "27.12.2024", "четверо суток", "GRAY", "комментарий2"},
        };
    }

    @Test
    public void orderTest() {
        ChromeOptions options = new ChromeOptions();

        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        SamokatHomePage homePageSamokat = new SamokatHomePage(driver);

        //Дождаться загрузки страницы
        homePageSamokat.waitForHeaderTitleIsVisible();
        //Нажать Заказать
        homePageSamokat.clickOrderButton(orderButtonTop);

        OrderPage orderPage = new OrderPage(driver);
        //Дождаться загрузки страницы заказа
        orderPage.waitForLoadRegistrationPage();
        //Заполнить данные
        orderPage.registrationParametersInput(name, surname, address, station, phone);
        //Нажать Далее
        orderPage.clickNext();
        //Дождаться загрузки страницы аренды
        orderPage.waitForLoadRegistrationPage();
        //Заполнить поля аренды
        orderPage.rentParametersInput(arriveDate, rentTime, colour, comment);
        //Нажать Заказать
        orderPage.clickOrderButton();

        AcceptModal acceptModal = new AcceptModal(driver);
        //Подтвердить заказ
        acceptModal.accept();

        PlacedOrderModal placedOrderModal = new PlacedOrderModal(driver);
        //Проверка что заказ оформлен
        placedOrderModal.checkTitle();
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
