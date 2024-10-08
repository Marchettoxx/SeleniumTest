package PO.teleportHQ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunicationCreatePO extends PageObject {

    @FindBy(xpath = "//span[text()='Nuova comunicazione']")
    private WebElement title;

    @FindBy(xpath = "//span[text()='ANNULLA']")
    private WebElement cancelButton;

    @FindBy(xpath = "//span[text()='Seleziona']")
    private WebElement selectButton;

    @FindBy(xpath = "//a[contains(@class, 'cmcommunicationsregulatoryalertadmin-link1') and span='Comunicazioni']")
    private WebElement communicationLinkBreadCrumb;

    @FindBy(xpath = "//a[contains(@class, 'cmcommunicationsregulatoryalertadmin-link4') and span='Comunicazioni']")
    private WebElement commMenuLink;

    private final WebDriverWait wait;

    public CommunicationCreatePO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Nuova comunicazione"));

        return this.title.getText();
    }

    public CommunicationPO cancel() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.cancelButton));

        this.cancelButton.click();
        return new CommunicationPO(driver);
    }

    public CommunicationSelectUserPO select() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.selectButton));

        this.selectButton.click();
        return new CommunicationSelectUserPO(driver);
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
}

