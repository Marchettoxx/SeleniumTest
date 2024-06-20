package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunicationForwardPO extends PageObject {

    @FindBy(xpath = "//span[text()='Inoltra comunicazione 34893549085']")
    private WebElement title;

    @FindBy(linkText = "ANNULLA")
    private WebElement cancelButton;

    @FindBy(linkText = "SELEZIONA")
    private WebElement selectButton;

    public CommunicationForwardPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Inoltra comunicazione 34893549085"));

        return this.title.getText();
    }

    public CommunicationDetailPO cancel() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.cancelButton));

        this.cancelButton.click();
        return new CommunicationDetailPO(driver);
    }

    public CommunicationSelectContactPO select() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.selectButton));

        this.selectButton.click();
        return new CommunicationSelectContactPO(driver);
    }
}

