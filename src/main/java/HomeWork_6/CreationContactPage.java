package HomeWork6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CreationContactPage extends BaseView {
    public CreationContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='crm_contact[lastName]']")
    public WebElement inputLastName;

    public CreationContactPage fillLastName(String lastName) {
        inputLastName.sendKeys(lastName);
        return this;
    }

    @FindBy(xpath = "//input[@name='crm_contact[firstName]']")
    public WebElement inputFirstName;

    public CreationContactPage fillFirstName(String FirstName) {
        inputFirstName.sendKeys(FirstName);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']/..")
    public WebElement openListOrganizations;

    public CreationContactPage selectOrganization(String nameOrganization) {
        openListOrganizations.click();
        webDriverWait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + nameOrganization + "']")));
        driver.findElement(By.xpath("//div[text()='" + nameOrganization + "']")).click();
        return this;
    }

    @FindBy(xpath = "//input[@name='crm_contact[jobTitle]']")
    public WebElement inputJobTitle;

    public CreationContactPage fillJobTitle(String jobTitle) {
        inputJobTitle.sendKeys(jobTitle);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement buttonSaveAndClose;

    @FindBy(xpath = requestSuccessLocator)
    public WebElement requestSuccess;

    public static final String requestSuccessLocator = "//*[text()='Контактное лицо сохранено']";

    public By loadFinishLocator = By.xpath("//input[@name='crm_contact[email]']");
}
