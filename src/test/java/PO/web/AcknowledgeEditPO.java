package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AcknowledgeEditPO extends PageObject {

    @FindBy(xpath = "//span[text(), 'ANNULLA']")
    private WebElement cancelButton;

    private final WebDriverWait wait;

    public AcknowledgeEditPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getSaveButtonText() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.cancelButton,  "ANNULLA"));

        return this.cancelButton.getText();
    }

    public ConfigurationPO clickCancel() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.cancelButton));

        this.cancelButton.click();
        return new ConfigurationPO(driver);
    }
}

