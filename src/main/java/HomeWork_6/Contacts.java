package HomeWork6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static HomeWork6.Configuration.loadWindow;

public class Contacts extends BaseView {
    public Contacts(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Создать контактное лицо']")
    public WebElement createContactButton;

    public void createContact() {
        createContactButton.click();
        webDriverWait.until
                (ExpectedConditions.elementToBeClickable(new CreationContactPage(driver).loadFinishLocator));
        webDriverWait.until
                (ExpectedConditions.invisibilityOfElementLocated(loadWindow));
    }

    public By createContactButtonLocator = By.xpath("//a[text()='Создать контактное лицо']");
}