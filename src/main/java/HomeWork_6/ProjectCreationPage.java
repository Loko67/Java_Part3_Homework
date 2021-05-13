package HomeWork6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProjectCreationPage extends BaseView {

    public ProjectCreationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='crm_project[name]']")
    public WebElement nameProject;

    public ProjectCreationPage fillName(String name) {
        nameProject.sendKeys(name);
        return this;
    }

    @FindBy(xpath = "//*[text()='Укажите организацию']")
    public WebElement listOrganizations;
    public ProjectCreationPage openListOrganization() throws InterruptedException {
        Thread.sleep(5000);
        listOrganizations.click();
        return this;
    }

    @FindBy(css = "#select2-drop>div>input")
    public WebElement organization;

    public ProjectCreationPage selectOrganization(String nameOrganization) throws InterruptedException {
        organization.sendKeys(nameOrganization);
        Thread.sleep(3000);
        organization.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(xpath = "//div[@class='select2-container select2']/a")
    public WebElement listContacts;

    public ProjectCreationPage openListContacts() throws InterruptedException {
        Thread.sleep(3000);
        listContacts.click();
        return this;
    }

    @FindBy(css = "#select2-drop>div>input")
    public WebElement contact;

    public ProjectCreationPage selectContact(String nameContact) {
        contact.sendKeys(nameContact);
        organization.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(name = "crm_project[businessUnit]")
    public WebElement businessUnitSelect;

    public ProjectCreationPage selectBusinessUnit(String businessUnit) {
        new Select(businessUnitSelect).selectByVisibleText(businessUnit);
        return this;
    }

    @FindBy(name = "crm_project[curator]")
    public WebElement curatorSelect;

    public ProjectCreationPage selectCurator(String curator) {
        new Select(curatorSelect).selectByVisibleText(curator);
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    public WebElement rpSelect;

    public ProjectCreationPage selectrp(String rp) {
        new Select(rpSelect).selectByVisibleText(rp);
        return this;
    }

    @FindBy(name = "crm_project[administrator]")
    public WebElement administratorSelect;

    public ProjectCreationPage selectAdministrator(String administrator) {
        new Select(administratorSelect).selectByVisibleText(administrator);
        return this;
    }

    @FindBy(name = "crm_project[manager]")
    public WebElement managerSelect;

    public ProjectCreationPage selectManager(String manager) {
        new Select(managerSelect).selectByVisibleText(manager);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement buttonSaveAndClose;

    @FindBy(xpath = requestSuccessLocator)
    public WebElement requestSuccess;

    public static final String requestSuccessLocator = "//*[text()='Проект сохранен']";

    public By loadFinishLocator = By.xpath("//span[text()='Укажите организацию']/..");
}
