package PO.teleportHQ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChatPO extends PageObject {

    @FindBy(xpath = "//span[text()='TORNA AL DETTAGLIO']")
    private WebElement backButton;

    @FindBy(xpath = "//span[text()='Chat con ABI 08016']")
    private WebElement title;

    private final WebDriverWait wait;

    public ChatPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Chat con ABI 08016"));

        return this.title.getText();
    }

    public CommunicationDetailPO closeChat() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.backButton));

        this.backButton.click();
        return new CommunicationDetailPO(driver);
    }
}

