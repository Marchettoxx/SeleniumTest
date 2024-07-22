package PO.teleportHQ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserAddToGroupPO extends PageObject {

    @FindBy(xpath = "//span[text()='Seleziona i gruppi in cui aggiungere l’utente']")
    private WebElement title;

    @FindBy(xpath = "//a[@href='/cmcreanuovoutente']")
    private WebElement closeButton;

    private final WebDriverWait wait;

    public UserAddToGroupPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Seleziona i gruppi in cui aggiungere l’utente"));

        return this.title.getText();
    }

    public UserCreatePO close() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.closeButton));

        this.closeButton.click();
        return new UserCreatePO(driver);
    }
}

