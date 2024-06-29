package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfigurationPO extends PageObject {

    @FindBy(xpath = "//div[@class='bb-header-title bb-ellipsis ng-star-inserted' and contains(text(), 'Configurazione')]")
    private WebElement title;

    @FindBy(xpath = "//span[@class='k-item-text' and contains(text(), 'Comunicazioni')]")
    private WebElement communicationLink;

    @FindBy(xpath = "//span[contains(text(), 'Notifiche')]")
    private WebElement notificationLink;

    @FindBy(xpath = "//span[contains(text(), 'Testi di default')]")
    private WebElement textLink;

    @FindBy(xpath = "//span[contains(text(), 'Firme')]")
    private WebElement signatureLink;

    @FindBy(xpath = "//span[@class='k-button-text' and contains(text(), 'MODIFICA')]")
    private WebElement editAckLink;

    private final WebDriverWait wait;

    public ConfigurationPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Configurazione"));

        return this.title.getText();
    }

    public CommunicationPO clickCommunication() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.communicationLink));

        this.communicationLink.click();
        return new CommunicationPO(driver);
    }

    public NotificationPO clickNotification() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.notificationLink));

        this.notificationLink.click();
        return new NotificationPO(driver);
    }

    public TextPO clickText() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.textLink));

        this.textLink.click();
        return new TextPO(driver);
    }

    public SignaturePO clickSignature() {
        this.wait.until(ExpectedConditions.elementToBeClickable(signatureLink));

        this.signatureLink.click();
        return new SignaturePO(driver);
    }

    public AcknowledgeEditPO clickEditAcknowledge() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.editAckLink));

        this.editAckLink.click();
        return new AcknowledgeEditPO(driver);
    }
}

