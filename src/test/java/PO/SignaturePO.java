package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignaturePO extends PageObject {

    @FindBy(xpath = "//span[text()='Firma CCB 1']")
    private WebElement firstSignature;

    public SignaturePO(WebDriver driver) {
        super(driver);
    }

    public String getFirstSignatureText() {
        return this.firstSignature.getText();
    }

    public WebElement getFirstSignature() {
        return firstSignature;
    }
}

