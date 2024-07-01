package PO.figma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserDetailPO extends PageObject {

    @FindBy(xpath = "//span[text()='[Cognome nome]']")
    private WebElement title;

    @FindBy(css = "div.cmdettaglioutente-breadcrumb-item2 a")
    private WebElement backLink;

    @FindBy(css = "div.cmdettaglioutente-drawer-item1 a")
    private WebElement backMenuLink;

    @FindBy(linkText = "MODIFICA")
    private WebElement editButton;

    private final WebDriverWait wait;

    public UserDetailPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "[Cognome nome]"));

        return this.title.getText();
    }

    public UsersAndGroupsPO back() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.backLink));

        this.backLink.click();
        return new UsersAndGroupsPO(driver);
    }

    public UsersAndGroupsPO backBreadCrumb() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.backMenuLink));

        this.backMenuLink.click();
        return new UsersAndGroupsPO(driver);
    }

    public UserEditPO edit() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.editButton));

        this.editButton.click();
        return new UserEditPO(driver);
    }
}

