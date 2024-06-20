package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupsPO extends PageObject {

    @FindBy(linkText = "NUOVO GRUPPO")
    private WebElement newGroupButton;

    @FindBy(linkText = "Gruppo Compliance 231 (ristretto)")
    private WebElement detailLink;

    @FindBy(linkText = "Gestione utenti")
    private WebElement usersLink;

    @FindBy(linkText = "NUOVO GRUPPO")
    private WebElement createButton;

    public GroupsPO(WebDriver driver) {
        super(driver);
    }

    public String getGroupText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(this.detailLink, "Gruppo Compliance 231 (ristretto)"));

        return this.detailLink.getText();
    }

    public GroupDetailPO clickDetailGroup() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.detailLink));

        this.detailLink.click();
        return new GroupDetailPO(driver);
    }

    public UsersAndGroupsPO back() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.usersLink));

        this.usersLink.click();
        return new UsersAndGroupsPO(driver);
    }

    public GroupCreatePO create() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.createButton));

        this.createButton.click();
        return new GroupCreatePO(driver);
    }
}

