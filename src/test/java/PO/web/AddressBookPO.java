package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookPO extends PageObject {

    @FindBy(xpath = "//span[text()='Rubrica']")
    private WebElement title;

    @FindBy(linkText = "Modifica contatti")
    private WebElement editContactButton;

    @FindBy(linkText = "NUOVO CONTATTO")
    private WebElement createContact;

    public AddressBookPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return this.title.getText();
    }

    public AddressBookEditPO edit() {
        this.editContactButton.click();
        return new AddressBookEditPO(driver);
    }

    public AddressBookCreatePO create() {
        this.createContact.click();
        return new AddressBookCreatePO(driver);
    }
}

