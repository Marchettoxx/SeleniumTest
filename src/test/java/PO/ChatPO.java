package PO;

import model.UserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChatPO extends PageObject {

    @FindBy(linkText = "TORNA AL DETTAGLIO")
    private WebElement backButton;

    @FindBy(xpath = "//span[text()='Comunicazioni']")
    private WebElement title;

    public ChatPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Chat con ABI 08016"));

        return this.title.getText();
    }

    public CommunicationDetailPO closeChat(UserType userType) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.backButton));

        this.backButton.click();
        return new CommunicationDetailPO(driver);
    }
}

