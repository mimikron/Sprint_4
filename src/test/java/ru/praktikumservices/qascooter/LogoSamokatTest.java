package ru.praktikumservices.qascooter;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikumservices.qascooter.constants.Urls;
import ru.praktikumservices.qascooter.pages.SamokatHomePage;

import static org.junit.Assert.assertEquals;

public class LogoSamokatTest {

    private WebDriver driver;

    @Test
    public void LogoTest() {
        ChromeOptions options = new ChromeOptions();

        driver = new ChromeDriver(options);
        driver.get(Urls.MAIN_PAGE);

        SamokatHomePage homePageSamokat = new SamokatHomePage(driver);
        homePageSamokat.waitForHeaderTitleIsVisible();
        homePageSamokat.clickLogoSamokat();
        assertEquals("Url не соответсвует ожидаемому", Urls.MAIN_PAGE, driver.getCurrentUrl());
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
