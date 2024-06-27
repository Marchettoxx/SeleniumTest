package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunicationDetailPO extends PageObject {

    @FindBy(css = "div.bb-header-title.bb-ellipsis[title='321 Prendere visione con urgenza']")
    private WebElement title;

    @FindBy(xpath = "//span[@class='k-breadcrumb-item-text' and text()='Comunicazioni']")
    private WebElement communicationLinkBreadCrumb;

    @FindBy(linkText = "Comunicazioni")
    private WebElement commMenuLink;

    @FindBy(linkText = "Nuovo messaggio")
    private WebElement newMessageLink;

    @FindBy(linkText = "INOLTRA")
    private WebElement forwardButton;

    @FindBy(linkText = "RISPONDI")
    private WebElement answerButton;

    private WebDriverWait wait;

    public CommunicationDetailPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "321 Prendere visione con urgenza"));

        return this.title.getText();
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

