package PO.teleportHQ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunicationForwardPO extends PageObject {

    @FindBy(xpath = "//span[text()='Inoltra comunicazione 34893549085']")
    private WebElement title;

    @FindBy(xpath = "//span[text()='ANNULLA']")
    private WebElement cancelButton;

    @FindBy(xpath = "//span[text()='SELEZIONA']")
    private WebElement selectButton;

    private final WebDriverWait wait;

    public CommunicationForwardPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Inoltra comunicazione 34893549085"));

        return this.title.getText();
    }

    public CommunicationDetailPO cancel() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.cancelButton));

        this.cancelButton.click();
        return new CommunicationDetailPO(driver);
    }

    public CommunicationSelectContactPO select() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.selectButton));

        this.selectButton.click();
        return new CommunicationSelectContactPO(driver);
    }
}

