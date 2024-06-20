package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunicationAnswerPO extends PageObject {

    @FindBy(xpath = "//span[text()='Chat']")
    private WebElement title;

    @FindBy(linkText = "TORNA AL DETTAGLIO")
    private WebElement backButton;

    public CommunicationAnswerPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Chat"));

        return this.title.getText();
    }

    public CommunicationDetailPO back() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.backButton));

        this.backButton.click();
        return new CommunicationDetailPO(driver);
    }
}

