package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextEditPO extends PageObject {

    @FindBy(linkText = "SALVA")
    private WebElement saveButton;

    public TextEditPO(WebDriver driver) {
        super(driver);
    }

    public String getSaveButtonText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(this.saveButton, "SALVA"));

        return this.saveButton.getText();
    }

    public TextPO save() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.saveButton));

        this.saveButton.click();
        return new TextPO(driver);
    }
}

