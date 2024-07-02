package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextEditPO extends PageObject {

    @FindBy(xpath = "//span[contains(text(), 'SALVA')]")
    private WebElement saveButton;

    private final WebDriverWait wait;

    public TextEditPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getSaveButtonText() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.saveButton, "SALVA"));

        return this.saveButton.getText();
    }

    public TextPO save() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.saveButton));

        this.saveButton.click();
        return new TextPO(driver);
    }
}

