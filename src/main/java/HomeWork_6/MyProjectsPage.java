package HomeWork6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyProjectsPage extends BaseView{
    public MyProjectsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Создать проект']")
    public WebElement createProjectButton;

    public void createProject() {
        createProjectButton.click();
        webDriverWait.until
                (ExpectedConditions.elementToBeClickable(new ProjectCreationPage(driver).loadFinishLocator));
        webDriverWait.until
                (ExpectedConditions.invisibilityOfElementLocated(new ProjectCreationPage(driver).loadWindow));
    }

    public By createProjectButtonLocator = By.xpath("//a[text()='Создать проект']");
}

