package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserCreatePO extends PageObject {

    @FindBy(xpath = "//div[contains(text(), 'Nuovo utente')]")
    private WebElement title;

    @FindBy(xpath = "//span[contains(text(), 'ANNULLA')]")
    private WebElement cancelButton;

    @FindBy(linkText = "Aggiungi ad altro gruppo")
    private WebElement addGroupButton;

    private final WebDriverWait wait;

    public UserCreatePO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Nuovo utente"));

        return this.title.getText();
    }

    public UsersAndGroupsPO cancel() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.cancelButton));

        this.cancelButton.click();
        return new UsersAndGroupsPO(driver);
    }

    public UserAddToGroupPO add() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.addGroupButton));

        this.addGroupButton.click();
        return new UserAddToGroupPO(driver);
    }
}

