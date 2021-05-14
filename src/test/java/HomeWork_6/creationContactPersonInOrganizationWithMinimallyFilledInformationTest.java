package HomeWork6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static HomeWork6.Configuration.BASE_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class creationContactPersonInOrganizationWithMinimallyFilledInformationTest extends BaseTest {

    @BeforeEach
    public void goToPage() {
        driver.get(BASE_URL);
    }

    @Test
    void creationContact() {

        new LoginPage(driver).login("Applanatest1", "Student2020!")
                .navigationMenu.openNavigationMenuItem("Контрагенты");
        new СounterpartiesSubMenu(driver).createСounterparty();
        new Contacts(driver).createContact();

        new CreationContactPage(driver)
                .fillLastName("Иванов")
                .fillFirstName("Иван")
                .selectOrganization("123test")
                .fillJobTitle("Тестировщик")
                .buttonSaveAndClose.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new CreationContactPage(driver).requestSuccessLocator)));

        assertThat(new CreationContactPage(driver).requestSuccess, isDisplayed());
    }

}
