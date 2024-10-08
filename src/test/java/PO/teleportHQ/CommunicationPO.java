package PO.teleportHQ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunicationPO extends PageObject {

    @FindBy(xpath = "//span[text()='Comunicazioni']")
    private WebElement title;

    @FindBy(xpath = "//span[text()='CONFIGURA']")
    private WebElement configuraButton;

    @FindBy(xpath = "//span[text()='6/2024']")
    private WebElement detailLink;

    @FindBy(xpath = "//span[text()='Utenti e gruppi']")
    private WebElement usersAndGroupsLink;

    @FindBy(xpath = "//span[text()='Rubrica']")
    private WebElement addressbookLink;

    @FindBy(xpath = "//span[text()='NUOVA COMUNICAZIONE']")
    private WebElement createButton;

    private final WebDriverWait wait;

    public CommunicationPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        driver.manage().window().maximize();

        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Comunicazioni"));

        return this.title.getText();
    }

    public ConfigurationPO clickConfig() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.configuraButton));

        this.configuraButton.click();
        return new ConfigurationPO(driver);
    }

    public CommunicationDetailPO clickDetail() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.detailLink));

        this.detailLink.click();
        return new CommunicationDetailPO(driver);
    }

    public UsersAndGroupsPO clickUsersAndGroups() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.usersAndGroupsLink));

        this.usersAndGroupsLink.click();
        return new UsersAndGroupsPO(driver);
    }

    public AddressBookPO clickAddressBook() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.addressbookLink));

        this.addressbookLink.click();
        return new AddressBookPO(driver);
    }

    public CommunicationCreatePO create() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.createButton));

        this.createButton.click();
        return new CommunicationCreatePO(driver);
    }
}

