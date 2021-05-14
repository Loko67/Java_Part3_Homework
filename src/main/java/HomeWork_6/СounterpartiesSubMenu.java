package HomeWork6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static HomeWork6.Configuration.loadWindow;

public class СounterpartiesSubMenu extends BaseView{
    public СounterpartiesSubMenu(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[text()='Контактные лица']")
    public WebElement counterparties;

    public void createСounterparty() {
        counterparties.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new Contacts(driver).createContactButtonLocator));
        webDriverWait.until
                (ExpectedConditions.invisibilityOfElementLocated(loadWindow));
    }

}