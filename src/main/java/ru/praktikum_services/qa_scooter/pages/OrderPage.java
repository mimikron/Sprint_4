package ru.praktikum_services.qa_scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class OrderPage {

    private final WebDriver driver;
    // Заголовок
    private final By orderHeader = By.className("Order_Header__BZXOb");
    //Имя
    private final By name = By.xpath(".//input[@placeholder='* Имя']");
    //Фамилия
    private final By surname = By.xpath(".//input[@placeholder='* Фамилия']");
    //Адрес
    private final By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Станции метро
    private final By stations = By.xpath(".//input[@placeholder='* Станция метро']");
    //Номер телефона
    private final By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private final By next = By.xpath(".//button[contains(text(),'Далее')]");
    //Дата доставки
    private final By arriveDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Срок аренды
    private final By rentTime = By.cssSelector("div.Dropdown-control > div.Dropdown-arrow-wrapper > span");
    //Цвета
    private final By black = By.xpath(".//label[@for='black']");
    private final By grey = By.xpath(".//label[@for='grey']");
    //Комментарий
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка заказать
    private final By order = By.cssSelector("div.Order_Buttons__1xGrp > button:nth-child(2)");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadRegistrationPage(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(orderHeader));
    }

    public void nameInput(String name){
        driver.findElement(this.name).clear();
        driver.findElement(this.name).sendKeys(name);
    }

    public void surnameInput(String surname){
        driver.findElement(this.surname).clear();
        driver.findElement(this.surname).sendKeys(surname);
    }

    public void addressInput(String address){
        driver.findElement(this.address).clear();
        driver.findElement(this.address).sendKeys(address);
    }

    public void stationSelect(String station){
        driver.findElement(this.stations).click();
        driver.findElement(By.xpath(".//*[contains(text(),'" + station + "')]")).click();
        driver.findElement(By.xpath(".//input[@value='" + station + "']"));
    }

    public void phoneInput(String phone){
        driver.findElement(this.phone).clear();
        driver.findElement(this.phone).sendKeys(phone);
    }

    public void registrationParametersInput(String name, String surname, String address, String station, String phone){
        nameInput(name);
        surnameInput(surname);
        addressInput(address);
        stationSelect(station);
        phoneInput(phone);
    }

    public void clickNext(){
        driver.findElement(next).isEnabled();
        driver.findElement(next).click();
    }

    public void arriveDateInput(String arriveDate){
        driver.findElement(this.arriveDate).clear();
        driver.findElement(this.arriveDate).sendKeys(arriveDate);
    }

    public void rentTimeSelect(String rentTime){
        driver.findElement(this.rentTime).click();
        driver.findElement(By.xpath(".//*[contains(text(),'" + rentTime + "')]")).click();
        driver.findElement(By.xpath(".//*[contains(text(),'" + rentTime + "')]"));
    }

    public void colourSelect(String colour){
        if(Objects.equals(colour, "BLACK")){
            driver.findElement(black).click();
        } else {
            driver.findElement(grey).click();
        }
    }

    public void commentInput(String comment){
        driver.findElement(this.comment).clear();
        driver.findElement(this.comment).sendKeys(comment);
    }

    public void rentParametersInput(String arriveDate, String rentTime, String colour, String comment){
        arriveDateInput(arriveDate);
        rentTimeSelect(rentTime);
        colourSelect(colour);
        commentInput(comment);
    }

    public void clickOrderButton(){
     driver.findElement(order).isEnabled();
     driver.findElement(order).click();
    }

}
