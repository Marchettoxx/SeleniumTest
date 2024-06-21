package PO.web;

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

    public UserCreatePO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Nuovo utente"));

        return this.title.getText();
    }

    public UsersAndGroupsPO confirm() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.confirmButton));

        this.confirmButton.click();
        return new UsersAndGroupsPO(driver);
    }

    public UserAddToGroupPO add() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.addGroupButton));

        this.addGroupButton.click();
        return new UserAddToGroupPO(driver);
    }
}

