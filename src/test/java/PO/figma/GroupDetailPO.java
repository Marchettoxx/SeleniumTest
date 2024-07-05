package PO.figma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupDetailPO extends PageObject {

    @FindBy(xpath = "//span[text()='[Nome gruppo]']")
    private WebElement title;

    @FindBy(xpath = "//a[text()='Utenti e gruppi']")
    private WebElement backLink;

    @FindBy(xpath = "//span[text()='MODIFICA']")
    private WebElement editButton;

    private final WebDriverWait wait;

    public GroupDetailPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "[Nome gruppo]"));
        
        return this.title.getText();
    }

    public UsersAndGroupsPO back() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.backLink));

        this.backLink.click();
        return new UsersAndGroupsPO(driver);
    }

    public GroupEditPO edit() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.editButton));

        this.editButton.click();
        return new GroupEditPO(driver);
    }
}

