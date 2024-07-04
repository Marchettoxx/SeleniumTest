package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersAndGroupsPO extends PageObject {

    @FindBy(xpath = "//div[text()='Utenti e gruppi']")
    private WebElement title;

    @FindBy(xpath = "//div[contains(text(), '1test@test.it')]")
    private WebElement detailLink;

    @FindBy(xpath = "//span[contains(text(), 'Gestione gruppi')]")
    private WebElement groupsLink;

    @FindBy(xpath = "//span[contains(text(), 'NUOVO UTENTE')]")
    private WebElement createButton;

    @FindBy(xpath = "//span[contains(text(), 'Nuovo utente')]")
    private WebElement clickNewUserLink;

    private final WebDriverWait wait;

    public UsersAndGroupsPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Utenti e gruppi"));

        return this.title.getText();
    }

    public UserDetailPO clickDetailUser() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.detailLink));

        this.detailLink.click();
        return new UserDetailPO(driver);
    }

    public GroupsPO clickGroups() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.groupsLink));

        this.groupsLink.click();
        return new GroupsPO(driver);
    }

    public UserCreatePO create() {
        driver.manage().window().maximize();

        this.wait.until(ExpectedConditions.elementToBeClickable(this.createButton));
        this.createButton.click();

        this.wait.until(ExpectedConditions.elementToBeClickable(this.clickNewUserLink));
        this.clickNewUserLink.click();

        return new UserCreatePO(driver);
    }
}

