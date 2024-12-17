package ru.praktikum_services.qa_scooter;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikum_services.qa_scooter.pages.SamokatHomePage;

import static org.junit.Assert.assertEquals;

public class LogoSamokatTest {

    private WebDriver driver;

    public LogoSamokatTest(){}

    @Test
    public void LogoTest() {
        ChromeOptions options = new ChromeOptions();

        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        SamokatHomePage homePageSamokat = new SamokatHomePage(driver);
        homePageSamokat.waitForHeaderTitleIsVisible();
        homePageSamokat.clickLogoSamokat();
        assertEquals("Url не соответсвует ожидаемому", "https://qa-scooter.praktikum-services.ru/",driver.getCurrentUrl());
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
