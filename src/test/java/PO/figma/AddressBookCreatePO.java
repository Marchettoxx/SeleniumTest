package PO.figma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressBookCreatePO extends PageObject {

    @FindBy(xpath = "//span[text()='Crea nuovo contatto']")
    private WebElement title;

    @FindBy(linkText = "CREA")
    private WebElement createButton;

    private final WebDriverWait wait;

    public AddressBookCreatePO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Crea nuovo contatto"));

        return this.title.getText();
    }

    public AddressBookPO create() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.createButton));

        this.createButton.click();
        return new AddressBookPO(driver);
    }
}

