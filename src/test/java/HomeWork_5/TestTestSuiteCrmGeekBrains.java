package HomeWork5;

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

public class TestTestSuiteCrmGeekBrains {
    private static WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String BASE_URL = "https://crm.geekbrains.space/";
    private static final String CREATE_PROJECT_URL = "https://crm.geekbrains.space/project/my";
    private static final String CREATE_PROJECT_URL_WITH_MINIMALLY_INFORMATION = "https://crm.geekbrains.space/contact/";

    @BeforeMethod
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get(BASE_URL);
        login();
    }

//    @Test
//    @DisplayName("Авторизация")
//    void loginInCrm() {
//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#user-menu>a")));
//        Assertions.assertTrue("Applanatest1 Applanatest1 Applanatest1".equals(driver.findElement(By.cssSelector("#user-menu>a")).getText()));
//        driver.close();
//    }

//    @Test
//    @DisplayName("Создание проекта")
//    void projectСreation() throws InterruptedException {
//        driver.get(CREATE_PROJECT_URL);
//        driver.manage().window().maximize();
//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/a[@href=\"/project/create/\"]")));
//        driver.findElement(By.xpath("//div/a[@href=\"/project/create/\"]")).click();
//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("crm_project[manager]")));
//        driver.findElement(By.xpath("//input[@name='crm_project[name]']")).sendKeys("name105");
//        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
//        Thread.sleep(1500);
//        driver.findElement(By.xpath("//div[text()='123test']")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//div[@class='select2-container select2']/a")).click();
//        driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys("Иванов Иван");
//        driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys(Keys.ENTER);
//        Select businessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
//        businessUnit.selectByVisibleText("Research & Development");
//        Select curator = new Select(driver.findElement(By.name("crm_project[curator]")));
//        curator.selectByVisibleText("Амелин Владимир");
//        Select rp = new Select(driver.findElement(By.name("crm_project[rp]")));
//        rp.selectByVisibleText("Гатов Фёдор");
//        Select administrator = new Select(driver.findElement(By.name("crm_project[administrator]")));
//        administrator.selectByVisibleText("Козлов Илья");
//        Select manager = new Select(driver.findElement(By.name("crm_project[manager]")));
//        manager.selectByVisibleText("Новиков Андрей");
//        driver.findElement(By.cssSelector("div.pull-right div:nth-of-type(4)>button")).click();
//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Проект сохранен']")));
//        Assertions.assertTrue("Все Проекты".equals(driver.findElement(By.cssSelector("div.btn>h1")).getText()));
//        driver.close();
//    }

    @Test
    @DisplayName("Создание контактного лица в организации с минимально заполненной информацией")
    void creationContactPersonInOrganizationWithMinimallyFilledInformation() throws InterruptedException {
        driver.get(CREATE_PROJECT_URL_WITH_MINIMALLY_INFORMATION);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div/a[@href=\"/contact/create\"]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='crm_contact[jobTitle]']")));
        driver.findElement(By.xpath("//input[@name='crm_contact[lastName]']")).sendKeys("Иванов");
        driver.findElement(By.xpath("//input[@name='crm_contact[firstName]']")).sendKeys("Иван");
        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".select2-input")).sendKeys("123test");
        driver.findElement(By.cssSelector(".select2-input")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//input[@name='crm_contact[jobTitle]']")).sendKeys("Тестировщик");
        driver.findElement(By.cssSelector("div.pull-right div:nth-of-type(4)>button")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Контактное лицо сохранено']")));
        Assertions.assertTrue("Все Контактные лица".equals(driver.findElement(By.cssSelector("//div[@data-toggle]/h1")).getText()));
        driver.close();
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }

    private void login() {
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}