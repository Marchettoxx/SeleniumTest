package PO.figma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunicationSelectContactPO extends PageObject {

    @FindBy(xpath = "//span[text()='Seleziona i contatti a cui inoltrare la comunicazione']")
    private WebElement title;

    @FindBy(xpath = "//a[@href='/cmdettagliocomunicazioneutentebancainoltro']")
    private WebElement closeButton;

    private final WebDriverWait wait;

    public CommunicationSelectContactPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Seleziona i contatti a cui inoltrare la comunicazione"));

        return this.title.getText();
    }

    public CommunicationForwardPO close() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.closeButton));

        this.closeButton.click();
        return new CommunicationForwardPO(driver);
    }
}

