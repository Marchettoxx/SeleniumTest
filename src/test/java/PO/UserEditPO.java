package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserEditPO extends PageObject {

    @FindBy(xpath = "//span[text()='Dettaglio utente']")
    private WebElement title;

    @FindBy(linkText = "SALVA")
    private WebElement saveButton;

    public UserEditPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Dettaglio utente"));

        return this.title.getText();
    }

    public UsersAndGroupsPO save() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.saveButton));

        this.saveButton.click();
        return new UsersAndGroupsPO(driver);
    }
}

