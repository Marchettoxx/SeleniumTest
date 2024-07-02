package PO.figma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressBookEditPO extends PageObject {

    @FindBy(xpath = "//span[text()='ANNULLA']")
    private WebElement cancelButton;

    private final WebDriverWait wait;

    public AddressBookEditPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getCancelButtonText() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.cancelButton));

        return this.cancelButton.getText();
    }

    public AddressBookPO cancel() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.cancelButton));

        this.cancelButton.click();
        return new AddressBookPO(driver);
    }
}

