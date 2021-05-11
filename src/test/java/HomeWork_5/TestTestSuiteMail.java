package HomeWork5;

import alexey.zasovin.HomeWork_3.TestSuiteMail;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTestSuiteMail {

    private static WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String HOME_PAGE_URL = "https://mail.ru/";

    @BeforeMethod
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
    }

    @Test
    @DisplayName("Авторизация")
    void login() throws InterruptedException {
        driver.get(HOME_PAGE_URL);
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input.email-input")).sendKeys("alexeytest00");
        driver.findElement(By.xpath("//button[@data-testid='enter-password']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.password-input-container>input")));
        driver.findElement(By.cssSelector("div.password-input-container>input")).sendKeys("Geekbrains");
        driver.findElement(By.cssSelector("button.second-button")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class='ph-project__user-name svelte-h2te2i']")));
        Assertions.assertTrue("alexeytest00@mail.ru".equals
                (driver.findElement(By.cssSelector("span[class='ph-project__user-name svelte-h2te2i']")).getText()));
    }

    @Test
    @DisplayName("Отправление пустого письма")
    void sendingBlankLetter() throws InterruptedException {
        login();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".compose-button__txt")));
        driver.findElement(By.cssSelector(".compose-button__txt")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Отправить']")));
        driver.findElement(By.cssSelector(".container--ItIg4 > .inputContainer--nsqFu > .container--H9L5q")).sendKeys("co_baka1@mail.ru");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='co_baka1@mail.ru']")));
        driver.findElement(By.cssSelector(".container--ItIg4 > .inputContainer--nsqFu > .container--H9L5q")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//span[text()='Отправить']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button/span[text()='Отправить']")));
        driver.findElement(By.xpath("//button/span[text()='Отправить']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Письмо отправлено']")));
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}
