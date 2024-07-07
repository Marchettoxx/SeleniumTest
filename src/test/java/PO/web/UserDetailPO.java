package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserDetailPO extends PageObject {

    @FindBy(xpath = "//div[contains(text(), 'WORKFLOW test')]")
    private WebElement title;

    @FindBy(xpath = "//li[@class='k-breadcrumb-item ng-star-inserted']//span[@class='k-breadcrumb-item-text' and text()='Utenti e Gruppi']")
    private WebElement backLink;

    @FindBy(css = "li.k-drawer-item[aria-label='Utenti e Gruppi']")
    private WebElement backMenuLink;

    @FindBy(xpath = "//span[contains(text(), 'MODIFICA')]")
    private WebElement editButton;

    private final WebDriverWait wait;

    public UserDetailPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "WORKFLOW test"));

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

