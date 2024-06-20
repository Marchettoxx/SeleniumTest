package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunicationDetailPO extends PageObject {

    @FindBy(xpath = "//span[text()='[Nome comunicazione]']")
    private WebElement title;

    @FindBy(linkText = "Comunicazioni")
    private WebElement communicationLinkBreadCrumb;

    @FindBy(linkText = "Comunicazioni")
    private WebElement commMenuLink;

    @FindBy(linkText = "Nuovo messaggio")
    private WebElement newMessageLink;

    @FindBy(linkText = "INOLTRA")
    private WebElement forwardButton;

    @FindBy(linkText = "RISPONDI")
    private WebElement answerButton;

    public CommunicationDetailPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(this.title, "[Nome comunicazione]"));

        return this.title.getText();
    }

    public CommunicationPO returnBackBreadCrumb() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.communicationLinkBreadCrumb));

        this.communicationLinkBreadCrumb.click();
        return new CommunicationPO(driver);
    }

    public CommunicationPO back() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.commMenuLink));

        this.commMenuLink.click();
        return new CommunicationPO(driver);
    }

    public ChatPO openChat() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.newMessageLink));

        this.newMessageLink.click();
        return new ChatPO(driver);
    }

    public CommunicationForwardPO forward() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.forwardButton));

        this.forwardButton.click();
        return new CommunicationForwardPO(driver);
    }

    public CommunicationAnswerPO answer() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.answerButton));

        this.answerButton.click();
        return new CommunicationAnswerPO(driver);
    }
}

