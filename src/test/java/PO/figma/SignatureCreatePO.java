package PO.figma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignatureCreatePO extends PageObject {

    @FindBy(xpath = "//span[text()='Crea nuova firma']")
    private WebElement title;

    @FindBy(linkText = "CREA")
    private WebElement createButton;

    public SignatureCreatePO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Crea nuova firma"));

        return this.title.getText();
    }

    public SignaturePO save() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.createButton));

        this.createButton.click();
        return new SignaturePO(driver);
    }
}

