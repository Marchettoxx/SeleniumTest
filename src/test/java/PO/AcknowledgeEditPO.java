package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AcknowledgeEditPO extends PageObject {

    @FindBy(css = "a.jsx-10245d16cf96f25c.cmcommunicationsacknowledgementconfigurationeditmo-link.WebB2BcalloutMedUp[href='/cmcommunicationsacknowledgementconfigurationreadmo']")
    private WebElement saveButton;

    public AcknowledgeEditPO(WebDriver driver) {
        super(driver);
    }

    public String getSaveButtonText() {
        return this.saveButton.getText();
    }

    public ConfigurationPO clickSave() {
        this.saveButton.click();
        return new ConfigurationPO(driver);
    }
}

