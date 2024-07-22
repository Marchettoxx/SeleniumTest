package PO.teleportHQ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunicationDetailPO extends PageObject {

    @FindBy(xpath = "//span[text()='[Nome comunicazione]']")
    private WebElement title;

    @FindBy(xpath = "//a[contains(@class, 'cmcommunicationsregulatoryalertadminview-link') and span='Comunicazioni']")
    private WebElement communicationLinkBreadCrumb;

    @FindBy(xpath = "//a[contains(@class, 'cmcommunicationsregulatoryalertadminview-link2') and span='Comunicazioni']")
    private WebElement commMenuLink;

    @FindBy(xpath = "//a[contains(@class, 'cmdettagliocomunicazioneutentebanca-link') and span='Comunicazioni']")
    private WebElement communicationLinkBreadCrumbBase;

    @FindBy(xpath = "//a[contains(@class, 'cmdettagliocomunicazioneutentebanca-link3') and span='Comunicazioni']")
    private WebElement commMenuLinkBase;

    @FindBy(xpath = "//a[text()='Nuovo messaggio']")
    private WebElement newMessageLink;

    @FindBy(xpath = "//span[text()='INOLTRA']")
    private WebElement forwardButton;

    @FindBy(xpath = "//span[text()='RISPONDI']")
    private WebElement answerButton;

    private final WebDriverWait wait;

    public CommunicationDetailPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "[Nome comunicazione]"));

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

    public CommunicationPO returnBackBreadCrumbBase() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.communicationLinkBreadCrumbBase));

        this.communicationLinkBreadCrumbBase.click();
        return new CommunicationPO(driver);
    }

    public CommunicationPO backBase() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.commMenuLinkBase));

        this.commMenuLinkBase.click();
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

