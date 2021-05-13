package HomeWork6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static HomeWork6.Configuration.BASE_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class ProjectCreationTest extends BaseTest {

    @BeforeEach
    public void goToPage() {
        driver.get(BASE_URL);
    }

    @Test
    void createProject() throws InterruptedException {

        new LoginPage(driver).login("Applanatest1", "Student2020!")
                .navigationMenu.openNavigationMenuItem("Проекты");

        new ProjectsSubMenu(driver).createProject();
        new MyProjectsPage(driver).createProject();

        new ProjectCreationPage(driver)
                .fillName("name111")
                .openListOrganization()
                .selectOrganization("123test")
                .openListContacts()
                .selectContact("Иванов Иван")
                .selectBusinessUnit("Research & Development")
                .selectCurator("Applanatest Applanatest Applanatest")
                .selectrp("Applanatest Applanatest Applanatest")
                .selectAdministrator("Applanatest Applanatest Applanatest")
                .selectManager("Applanatest Applanatest Applanatest")
                .buttonSaveAndClose.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new ProjectCreationPage(driver).requestSuccessLocator)));

        assertThat(new ProjectCreationPage(driver).requestSuccess, isDisplayed());
    }

}
