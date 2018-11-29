package pl.b2b.net.ingCollectionsTest.pages.homePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ObjectsHomePage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    public ObjectsHomePage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = DataHomePage.TRANSACTION_PAGE)
    private WebElement transactionPage;

    @FindBy(xpath = DataHomePage.HOME_PAGE_ASSERT)
    private WebElement homePage_assert;

    public WebElement getHomePage_assert() {
        wait.until(ExpectedConditions.visibilityOf(homePage_assert));
        return homePage_assert;
    }

    public void clickTransactionPage(){
        wait.until(ExpectedConditions.elementToBeClickable(transactionPage));
        transactionPage.click();
    }
}
