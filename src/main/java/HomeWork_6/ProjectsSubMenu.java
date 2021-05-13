package HomeWork6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectsSubMenu extends BaseView {
    public ProjectsSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Мои проекты']")
    public WebElement myProjects;

    public void createProject() {
        myProjects.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new MyProjectsPage(driver).createProjectButtonLocator));
    }

}
