package PO.figma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.autoconfigure.jms.JmsProperties;

public class ConfigurationPO extends PageObject {

    @FindBy(xpath = "//span[text()='Configurazione']")
    private WebElement title;

    @FindBy(linkText = "Comunicazioni")
    private WebElement communicationLink;

    @FindBy(linkText = "Notifiche")
    private WebElement notificationLink;

    @FindBy(linkText = "Testi di default")
    private WebElement textLink;

    @FindBy(linkText = "Firme")
    private WebElement signatureLink;

    @FindBy(linkText = "Modifica")
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

