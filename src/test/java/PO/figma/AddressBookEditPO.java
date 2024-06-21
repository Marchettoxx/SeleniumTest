package PO.figma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressBookEditPO extends PageObject {

    @FindBy(linkText = "ANNULLA")
    private WebElement cancelButton;

    public AddressBookEditPO(WebDriver driver) {
        super(driver);
    }

    public String getCancelButtonText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.cancelButton));

        return this.cancelButton.getText();
    }

    public AddressBookPO cancel() {
        this.cancelButton.click();
        return new AddressBookPO(driver);
    }
}

