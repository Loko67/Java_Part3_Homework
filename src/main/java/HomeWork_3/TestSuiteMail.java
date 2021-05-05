package alexey.zasovin.HomeWork_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class TestSuiteMail {

    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://mail.ru/";
    private static final String CREATE_LETTER = "https://e.mail.ru/inbox/";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        login();
        sendingBlankLetter();
        driver.quit();
    }

    private static void login() throws InterruptedException {
        driver.get(LOGIN_PAGE_URL);
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input.email-input")).sendKeys("alexeytest00");
        driver.findElement(By.xpath("//button[@data-testid='enter-password']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div.password-input-container>input")).sendKeys("Geekbrains");
        driver.findElement(By.cssSelector("button.second-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='alexeytest00@mail.ru']"));
    }

    private static void sendingBlankLetter() throws InterruptedException {

        driver.get(CREATE_LETTER);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".compose-button__txt")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".container--ItIg4 > .inputContainer--nsqFu > .container--H9L5q")).sendKeys("co_baka1@mail.ru");
        driver.findElement(By.cssSelector(".container--ItIg4 > .inputContainer--nsqFu > .container--H9L5q")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//span[text()='Отправить']")).click();
        driver.findElement(By.xpath("//button/span[text()='Отправить']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Письмо отправлено']"));
    }
}
