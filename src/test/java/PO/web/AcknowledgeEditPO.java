package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AcknowledgeEditPO extends PageObject {

    @FindBy(linkText = "SALVA")
    private WebElement saveButton;

    public AcknowledgeEditPO(WebDriver driver) {
        super(driver);
    }

    public String getSaveButtonText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.saveButton));

        return this.saveButton.getText();
    }

    public ConfigurationPO clickSave() {
        this.saveButton.click();
        return new ConfigurationPO(driver);
    }
}

