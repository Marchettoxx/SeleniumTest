package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressBookPO extends PageObject {

    @FindBy(xpath = "//span[text()='Rubrica']")
    private WebElement title;

    @FindBy(linkText = "Modifica contatti")
    private WebElement editContactButton;

    @FindBy(linkText = "NUOVO CONTATTO")
    private WebElement createContact;

    private final WebDriverWait wait;

    public AddressBookPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Rubrica"));

        return this.title.getText();
    }

    public AddressBookEditPO edit() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.editContactButton));

        this.editContactButton.click();
        return new AddressBookEditPO(driver);
    }

    public AddressBookCreatePO create() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.createContact));

        this.createContact.click();
        return new AddressBookCreatePO(driver);
    }
}

