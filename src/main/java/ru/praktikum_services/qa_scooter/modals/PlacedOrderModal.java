package ru.praktikum_services.qa_scooter.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlacedOrderModal {
    private final WebDriver driver;
    //Заголовок МО
    private final By title = By.xpath(".//div[contains(text(),'Заказ оформлен')]");

    public PlacedOrderModal(WebDriver driver) {
        this.driver = driver;
    }

    //Проверка наличия заголовка "Заказ оформлен"
    public void checkTitle(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(title));
    }

}
