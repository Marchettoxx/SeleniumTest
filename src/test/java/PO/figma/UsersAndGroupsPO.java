package PO.figma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersAndGroupsPO extends PageObject {

    @FindBy(xpath = "//span[text()='Utenti e gruppi']")
    private WebElement title;

    @FindBy(xpath = "//span[text()='laura.bianchini@cassacentrale.it']")
    private WebElement detailLink;

    @FindBy(xpath = "//span[@class='jsx-dffb6c7ed3f4b965' and text()='Gestione gruppi']")
    private WebElement groupsLink;

    @FindBy(xpath = "//span[text()='NUOVO UTENTE']")
    private WebElement createButton;

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
        this.wait.until(ExpectedConditions.elementToBeClickable(this.createButton));

        this.createButton.click();
        return new UserCreatePO(driver);
    }
}

