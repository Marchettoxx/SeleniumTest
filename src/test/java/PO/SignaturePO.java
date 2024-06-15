package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignaturePO extends PageObject {

    @FindBy(xpath = "//span[text()='Firma CCB 1']")
    private WebElement firstSignature;

    public SignaturePO(WebDriver driver) {
        super(driver);
    }

    public String getFirstSignatureText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(this.firstSignature, "Firma CCB 1"));

        return this.firstSignature.getText();
    }
}

