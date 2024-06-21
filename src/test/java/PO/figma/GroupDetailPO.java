package PO.figma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupDetailPO extends PageObject {

    @FindBy(xpath = "//span[text()='[Nome gruppo]']")
    private WebElement title;

    @FindBy(linkText = "Utenti e gruppi")
    private WebElement backLink;

    @FindBy(linkText = "MODIFICA")
    private WebElement editButton;

    public GroupDetailPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(this.title, "[Nome gruppo]"));
        
        return this.title.getText();
    }

    public GroupsPO back() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.backLink));

        this.backLink.click();
        return new GroupsPO(driver);
    }

    public GroupEditPO edit() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.editButton));

        this.editButton.click();
        return new GroupEditPO(driver);
    }
}

