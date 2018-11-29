package pl.b2b.net.ingCollectionsTest.pages.homePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.b2b.net.ingCollectionsTest.SingletonWebDriver;
import pl.b2b.net.ingCollectionsTest.pages.transactionPage.ObjectsTransationPage;

public class TestHomePage {
    private SingletonWebDriver singletonWebDriver;
    private WebDriver webDriver;
    private WebDriverWait wait;
    private ObjectsHomePage objectsHomePage;
    private ObjectsTransationPage objectsTransationPage;

    @BeforeClass
    private void setUp() {
        singletonWebDriver = SingletonWebDriver.getInstance();
        webDriver = singletonWebDriver.getWebDriver();
        wait = singletonWebDriver.getWait();
        objectsHomePage = new ObjectsHomePage(webDriver, wait);
        objectsTransationPage = new ObjectsTransationPage(webDriver, wait);
    }

    @Test(priority = 1)
    public void openHomePageTest() {
        webDriver.get("https://login.ingbank.pl/mojeing/demo/#home");
        Assert.assertTrue(objectsHomePage.getHomePage_assert().isDisplayed());
    }

    @Test(priority = 2)
    public void goToTransactionPage() {
        objectsHomePage.clickTransactionPage();
        Assert.assertEquals(objectsTransationPage.getTransactionPageAssert().getAttribute("innerHTML"), "Wykonaj transakcję");
    }
}
