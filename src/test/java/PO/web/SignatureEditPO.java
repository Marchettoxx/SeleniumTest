package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignatureEditPO extends PageObject {

    @FindBy(linkText = "SALVA")
    private WebElement saveButton;

    public SignatureEditPO(WebDriver driver) {
        super(driver);
    }

    public String getSaveButtonText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(this.saveButton, "SALVA"));

        return this.saveButton.getText();
    }

    public SignaturePO save() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.saveButton));

        this.saveButton.click();
        return new SignaturePO(driver);
    }
}

