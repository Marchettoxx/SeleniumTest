package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfigurationPO extends PageObject {

    @FindBy(xpath = "//span[text()='Configurazione']")
    private WebElement title;

    @FindBy(linkText = "Comunicazioni")
    private WebElement communicationLink;

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
}

