package ru.praktikumservices.qascooter.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AcceptModal {
    private final WebDriver driver;

    private final By yes = By.xpath(".//button[contains(text(),'Да')]");

    public AcceptModal(WebDriver driver) {
        this.driver = driver;
    }

    public void accept(){
        driver.findElement(yes).click();
    }
}
