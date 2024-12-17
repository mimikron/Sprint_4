package ru.praktikum_services.qa_scooter;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikum_services.qa_scooter.pages.SamokatHomePage;

import static org.junit.Assert.assertEquals;

public class LogoYandexTest {

    private WebDriver driver;

    public LogoYandexTest(){}

    @Test
    public void LogoTest() {
        ChromeOptions options = new ChromeOptions();

        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        SamokatHomePage homePageSamokat = new SamokatHomePage(driver);
        homePageSamokat.waitForHeaderTitleIsVisible();
        homePageSamokat.clickLogoYandex();


        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        String title=driver.getTitle();

        assertEquals("Url не соответсвует ожидаемому", "https://dzen.ru/?yredirect=true",driver.getCurrentUrl());
        assertEquals("Дзен — платформа для просмотра и создания контента. Вы всегда найдёте здесь то, что подходит именно вам: сотни тысяч авторов ежедневно делятся постами, статьями, видео и короткими роликами", title);

        System.out.println(driver.getCurrentUrl());
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
