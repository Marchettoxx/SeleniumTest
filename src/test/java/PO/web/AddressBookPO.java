package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressBookPO extends PageObject {

    @FindBy(xpath = "//div[text()='Rubrica']")
    private WebElement title;

    @FindBy(xpath = "//span[contains(text(), 'Modifica contatti')]")
    private WebElement editContactButton;

    @FindBy(xpath = "//span[contains(text(), 'NUOVO CONTATTO')]")
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
        driver.manage().window().maximize();

        this.wait.until(ExpectedConditions.elementToBeClickable(this.editContactButton));

        this.editContactButton.click();
        return new AddressBookEditPO(driver);
    }

    public AddressBookCreatePO create() {
        driver.manage().window().maximize();

        this.wait.until(ExpectedConditions.elementToBeClickable(this.createContact));

        this.createContact.click();
        return new AddressBookCreatePO(driver);
    }
}

