package PO.figma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignatureCreatePO extends PageObject {

    @FindBy(xpath = "//span[text()='Crea nuova firma']")
    private WebElement title;

    @FindBy(xpath = "//span[text()='ANNULLA']")
    private WebElement cancelButton;

    private final WebDriverWait wait;

    public SignatureCreatePO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Crea nuova firma"));

        return this.title.getText();
    }

    public SignaturePO cancel() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.cancelButton));

        this.cancelButton.click();
        return new SignaturePO(driver);
    }
}

