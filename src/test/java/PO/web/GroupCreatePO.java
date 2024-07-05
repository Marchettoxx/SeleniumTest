package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupCreatePO extends PageObject {

    @FindBy(xpath = "//div[text()='Nuovo gruppo']")
    private WebElement title;

    @FindBy(xpath = "//span[contains(text(), 'ANNULLA')]")
    private WebElement cancelButton;

    @FindBy(xpath = "//span[contains(text(), 'Aggiungi utente')]")
    private WebElement addButton;

    private final WebDriverWait wait;

    public GroupCreatePO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Nuovo gruppo"));

        return this.title.getText();
    }

    public UsersAndGroupsPO cancel() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.cancelButton));

        this.cancelButton.click();
        return new UsersAndGroupsPO(driver);
    }

    public GroupAddUserPO add() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.addButton));

        this.addButton.click();
        return new GroupAddUserPO(driver);
    }
}

