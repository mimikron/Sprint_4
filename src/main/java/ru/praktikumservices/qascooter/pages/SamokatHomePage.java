package ru.praktikumservices.qascooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class SamokatHomePage {

    private final WebDriver driver;
    //Лого Самокат
    private final By logoSamokat = By.xpath(".//img[@alt='Scooter']");
    //Лого Яндекс
    private final By logoYandex = By.xpath(".//img[@alt='Yandex']");
    //Заголовок страницы
    private final By headerTitle = By.className("Home_Header__iJKdX");
    //Кнока Заказать верхняя
    private final By orderButtonTop = By.cssSelector("div.Header_Nav__AGCXC > button.Button_Button__ra12g");
    //Кнопка Заказать нижняя
    private final By orderButtonBottom = By.cssSelector("div.Home_FinishButton__1_cWm > button");
    // Заголовок "Вопросы о важном"
    private final By questionsTitle = By.className("Home_SubHeader__zwi_E");
    // Список "Вопросы о важном"
    private final By questionList = By.className("accordion");

    public SamokatHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogoSamokat(){
        driver.findElement(logoSamokat).click();
    }

    public void clickLogoYandex(){
        driver.findElement(logoYandex).click();
    }

    public void waitForHeaderTitleIsVisible(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(headerTitle));
    }

    public void waitForFaqIsVisible(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(questionsTitle));
    }

    public String clickQuestionAndGetAnswer(String question){
        WebElement element = driver.findElement(questionList);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath(".//div[text()='" + question + "']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='" + question + "']/parent::div/following-sibling::div/p")));
        return driver.findElement(By.xpath(".//div[text()='" + question + "']/parent::div/following-sibling::div/p")).getText();
    }

    public void clickOrderButton(boolean isTop){
        if(isTop){
            driver.findElement(orderButtonTop).isEnabled();
            driver.findElement(orderButtonTop).click();
        } else {
            WebElement element = driver.findElement(orderButtonBottom);
            element.isEnabled();
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
        }
    }
}
