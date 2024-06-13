package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public ConfigurationPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return this.title.getText();
    }

    public CommunicationPO clickCommunication() {
        this.communicationLink.click();
        return new CommunicationPO(driver);
    }

    public NotificationPO clickNotification() {
        this.notificationLink.click();
        return new NotificationPO(driver);
    }

    public TextPO clickText() {
        this.textLink.click();
        return new TextPO(driver);
    }

    public SignaturePO clickSignature() {
        this.signatureLink.click();
        return new SignaturePO(driver);
    }
}

