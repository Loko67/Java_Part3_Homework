package alexey.zasovin.HomeWork_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;

public class TestSuiteCrmGeekBrains {

    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String CREATE_PROJECT_URL = "https://crm.geekbrains.space/project/my";
    private static final String CREATE_PROJECT_URL_WITH_MINIMALLY_INFORMATION = "https://crm.geekbrains.space/contact/";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        login();
        projectСreation();
        creationContactPersonInOrganizationWithMinimallyFilledInformation();
        Thread.sleep(5000);
        driver.quit();
    }

    private static void login() {
        driver.get(LOGIN_PAGE_URL);
        driver.manage().window().maximize();
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }

    private static void projectСreation() throws InterruptedException {

        driver.get(CREATE_PROJECT_URL);
        driver.findElement(By.xpath("//div/a[@href=\"/project/create/\"]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name='crm_project[name]']")).sendKeys("name101");
        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("123test");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='select2-container select2']/a")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys("Иванов Иван");
        driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys(Keys.ENTER);
        Select businessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnit.selectByVisibleText("Research & Development");
        Select curator = new Select(driver.findElement(By.name("crm_project[curator]")));
        curator.selectByVisibleText("Амелин Владимир");
        Select rp = new Select(driver.findElement(By.name("crm_project[rp]")));
        rp.selectByVisibleText("Гатов Фёдор");
        Select administrator = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administrator.selectByVisibleText("Козлов Илья");
        Select manager = new Select(driver.findElement(By.name("crm_project[manager]")));
        manager.selectByVisibleText("Новиков Андрей");
        driver.findElement(By.cssSelector("div.pull-right div:nth-of-type(4)>button")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[text()='Проект сохранен']"));
    }

    private static void creationContactPersonInOrganizationWithMinimallyFilledInformation() throws InterruptedException {

        driver.get(CREATE_PROJECT_URL_WITH_MINIMALLY_INFORMATION);
        driver.findElement(By.xpath("//div/a[@href=\"/contact/create\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='crm_contact[lastName]']")).sendKeys("Иванов");
        driver.findElement(By.xpath("//input[@name='crm_contact[firstName]']")).sendKeys("Иван");
        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".select2-input")).sendKeys("123test");
        driver.findElement(By.cssSelector(".select2-input")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//input[@name='crm_contact[jobTitle]']")).sendKeys("Тестировщик");
        driver.findElement(By.cssSelector("div.pull-right div:nth-of-type(4)>button")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[text()='Контактное лицо сохранено']"));
    }

}
