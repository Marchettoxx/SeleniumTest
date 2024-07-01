package PO.figma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignaturePO extends PageObject {

    @FindBy(xpath = "//span[text()='Firma CCB 1']")
    private WebElement firstSignature;

    @FindBy(linkText = "Presa visione")
    private WebElement ackTab;

    @FindBy(linkText = "Modifica")
    private WebElement editButton;

    @FindBy(linkText = "NUOVA FIRMA")
    private WebElement createButton;

    private final WebDriverWait wait;

    public SignaturePO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getFirstSignatureText() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.firstSignature, "Firma CCB 1"));

        return this.firstSignature.getText();
    }

    public ConfigurationPO back() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.ackTab));

        this.ackTab.click();
        return new ConfigurationPO(driver);
    }

    public SignatureEditPO edit() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.editButton));

        this.editButton.click();
        return new SignatureEditPO(driver);
    }

    public SignatureCreatePO create() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.createButton));

        this.createButton.click();
        return new SignatureCreatePO(driver);
    }
}

