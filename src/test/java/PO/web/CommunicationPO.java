package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunicationPO extends PageObject {

    @FindBy(css = "div.bb-header-title")
    private WebElement title;

    @FindBy(xpath = "//span[contains(text(), 'CONFIGURAZIONE')]")
    private WebElement configuraButton;

    @FindBy(css = "div.id-cell.bb-ellipsis[title='0/XXXX']")
    private WebElement detailLink;

    @FindBy(xpath = "//span[contains(text(), 'Utenti e Gruppi')]")
    private WebElement usersAndGroupsLink;

    @FindBy(linkText = "Rubrica")
    private WebElement addressbookLink;

    @FindBy(xpath = "//span[contains(text(), 'CREA COMUNICAZIONE')]")
    private WebElement createSplitButton;

    @FindBy(xpath = "//span[contains(text(), 'Alert normativo')]")
    private WebElement alertNormativoLink;
    private final WebDriverWait wait;

    public CommunicationPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 50);
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
        this.wait.until(ExpectedConditions.elementToBeClickable(this.createSplitButton));
        this.createSplitButton.click();

        this.wait.until(ExpectedConditions.elementToBeClickable(this.alertNormativoLink));
        this.alertNormativoLink.click();

        return new CommunicationCreatePO(driver);
    }
}

