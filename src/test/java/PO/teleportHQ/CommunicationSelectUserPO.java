package PO.figma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunicationSelectUserPO extends PageObject {

    @FindBy(xpath = "//span[text()='Seleziona gli utenti destinatari della comunicazione']")
    private WebElement title;

    @FindBy(xpath = "//span[text()='CONFERMA']")
    private WebElement confirmButton;

    private final WebDriverWait wait;

    public CommunicationSelectUserPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Seleziona gli utenti destinatari della comunicazione"));

        return this.title.getText();
    }

    public CommunicationCreatePO confirm() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.confirmButton));

        this.confirmButton.click();
        return new CommunicationCreatePO(driver);
    }
}

