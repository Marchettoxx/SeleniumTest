package PO.figma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserCreatePO extends PageObject {

    @FindBy(xpath = "//span[text()='Nuovo utente']")
    private WebElement title;

    @FindBy(linkText = "CONFERMA")
    private WebElement confirmButton;

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

    public UsersAndGroupsPO confirm() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.confirmButton));

        this.confirmButton.click();
        return new UsersAndGroupsPO(driver);
    }

    public UserAddToGroupPO add() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.addGroupButton));

        this.addGroupButton.click();
        return new UserAddToGroupPO(driver);
    }
}

