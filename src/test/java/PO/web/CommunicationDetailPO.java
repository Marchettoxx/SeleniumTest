package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunicationDetailPO extends PageObject {

    @FindBy(xpath = "//div[text()='1392 PROVA2']")
    private WebElement title;

    @FindBy(xpath = "//div[text()='1414 a']")
    private WebElement titleBase;

    @FindBy(xpath = "//span[text()='Comunicazioni']")
    private WebElement communicationLinkBreadCrumb;

    @FindBy(xpath = "//span[text()='Comunicazioni']")
    private WebElement commMenuLink;

    @FindBy(xpath = "//div[contains(text(), 'Non ricevuta')]")
    private WebElement newMessageLink;

    @FindBy(xpath = "//span[contains(text(), 'INOLTRA')]")
    private WebElement forwardButton;

    @FindBy(xpath = "//span[contains(text(), 'RISPONDI')]")
    private WebElement answerButton;

    private final WebDriverWait wait;

    public CommunicationDetailPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "1392 PROVA2"));

        return this.title.getText();
    }

    public String getTitleBase() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.titleBase, "1414 a"));

        return this.titleBase.getText();
    }

    public CommunicationPO returnBackBreadCrumb() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.communicationLinkBreadCrumb));

        this.communicationLinkBreadCrumb.click();
        return new CommunicationPO(driver);
    }

    public CommunicationPO back() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.commMenuLink));

        this.commMenuLink.click();
        return new CommunicationPO(driver);
    }

    public ChatPO openChat() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.newMessageLink));

        this.newMessageLink.click();
        return new ChatPO(driver);
    }

    public CommunicationForwardPO forward() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.forwardButton));

        this.forwardButton.click();
        return new CommunicationForwardPO(driver);
    }

    public CommunicationAnswerPO answer() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.answerButton));

        this.answerButton.click();
        return new CommunicationAnswerPO(driver);
    }
}

