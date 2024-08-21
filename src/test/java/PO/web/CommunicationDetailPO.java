package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunicationDetailPO extends PageObject {

    @FindBy(xpath = "//div[text()='2/2024 Test chat']")
    private WebElement title;

    @FindBy(xpath = "//div[text()='13/2024 Prova banca affilitata CC9016']")
    private WebElement titleBase;

    @FindBy(xpath = "//li[@class='k-breadcrumb-item']//span[@class='k-breadcrumb-item-text' and text()='Comunicazioni']")
    private WebElement communicationLinkBreadCrumb;

    @FindBy(xpath = "//li[@role='menuitem' and @aria-label='Comunicazioni']")
    private WebElement commMenuLink;

    @FindBy(xpath = "//div[contains(text(), 'Approvata')]")
    private WebElement newMessageLink;

    @FindBy(xpath = "//span[contains(text(), 'INOLTRA')]")
    private WebElement forwardButton;

    @FindBy(xpath = "//span[contains(text(), 'RISPONDI')]")
    private WebElement answerButton;

    private final WebDriverWait wait;

    public CommunicationDetailPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "2/2024 Test chat"));

        return this.title.getText();
    }

    public String getTitleBase() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "13/2024 Prova banca affilitata CC9016"));

        return this.title.getText();
    }

    public CommunicationPO returnBackBreadCrumb() {
        driver.manage().window().maximize();

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

