package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunicationCreatePO extends PageObject {

    @FindBy(css = "div.bb-header-title.bb-ellipsis[title='Nuova comunicazione']")
    private WebElement title;

    @FindBy(xpath = "//span[contains(text(), 'ANNULLA')]")
    private WebElement cancelButton;

    @FindBy(xpath = "//span[contains(text(), 'CONFERMA')]")
    private WebElement confirmModal;

    @FindBy(xpath = "//kendo-combobox[@id='legalType']//input[@class='k-input-inner']")
    private WebElement inputField;

    @FindBy(xpath = "//span[contains(text(), 'No')]")
    private WebElement clickAway;

    @FindBy(xpath = "//bb-button[@label='SELEZIONA']")
    private WebElement selectButton;

    private final WebDriverWait wait;

    public CommunicationCreatePO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);;
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Nuova comunicazione"));

        return this.title.getText();
    }

    public CommunicationPO cancel() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.cancelButton));
        this.cancelButton.click();

        this.wait.until(ExpectedConditions.elementToBeClickable(this.confirmModal));
        this.confirmModal.click();

        return new CommunicationPO(driver);
    }

    public CommunicationSelectUserPO select() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.inputField));
        this.inputField.sendKeys("Capogruppo");

        this.wait.until(ExpectedConditions.elementToBeClickable(this.clickAway));
        this.clickAway.click();

        driver.manage().window().maximize();

        this.wait.until(ExpectedConditions.elementToBeClickable(this.selectButton));

        this.selectButton.click();
        return new CommunicationSelectUserPO(driver);
    }
}

