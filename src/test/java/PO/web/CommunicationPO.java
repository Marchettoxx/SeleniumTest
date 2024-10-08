package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunicationPO extends PageObject {

    @FindBy(xpath = "//div[text()='Comunicazioni']")
    private WebElement title;

    @FindBy(xpath = "//span[contains(text(), 'CONFIGURA')]")
    private WebElement configuraButton;

    @FindBy(xpath = "//div[text()='2/2024']")
    private WebElement detailLink;

    @FindBy(xpath = "//div[text()='13/2024']")
    private WebElement detailLinkBase;

    @FindBy(xpath = "//span[text()='Utenti e Gruppi']")
    private WebElement usersAndGroupsLink;

    @FindBy(xpath = "//span[text()='Rubrica']")
    private WebElement addressbookLink;

    @FindBy(xpath = "//span[contains(text(), 'NUOVA COMUNICAZIONE')]")
    private WebElement createSplitButton;

    @FindBy(xpath = "//span[contains(text(), 'Alert normativo')]")
    private WebElement alertNormativoLink;

    @FindBy(xpath = "//input[@placeholder='Inserisci oggetto']")
    private WebElement input;

    @FindBy(xpath = "//bb-button[@lefticon='fa-sharp fa-regular fa-magnifying-glass']")
    private WebElement searchButton;


    private final WebDriverWait wait;

    public CommunicationPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 20);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Comunicazioni"));

        return this.title.getText();
    }

    public ConfigurationPO clickConfig() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.configuraButton));

        this.configuraButton.click();
        return new ConfigurationPO(driver);
    }

    public CommunicationDetailPO clickDetail() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.input));
        this.input.sendKeys("Test chat");

        this.wait.until(ExpectedConditions.elementToBeClickable(this.searchButton));
        this.searchButton.click();

        this.wait.until(ExpectedConditions.elementToBeClickable(this.detailLink));
        this.detailLink.click();

        return new CommunicationDetailPO(driver);
    }

    public CommunicationDetailPO clickDetailBase() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.input));
        this.input.sendKeys("Prova banca affilitata CC9016");

        this.wait.until(ExpectedConditions.elementToBeClickable(this.searchButton));
        this.searchButton.click();

        this.wait.until(ExpectedConditions.elementToBeClickable(this.detailLinkBase));
        this.detailLinkBase.click();

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
        this.wait.until(ExpectedConditions.elementToBeClickable(this.createSplitButton));
        this.createSplitButton.click();

        this.wait.until(ExpectedConditions.elementToBeClickable(this.alertNormativoLink));
        this.alertNormativoLink.click();

        return new CommunicationCreatePO(driver);
    }
}

