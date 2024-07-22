package PO.teleportHQ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationCreatePO extends PageObject {

    @FindBy(xpath = "//span[text()='ANNULLA']")
    private WebElement cancelButton;

    @FindBy(xpath = "//span[text()='Nuova notifica']")
    private WebElement title;

    private final WebDriverWait wait;

    public NotificationCreatePO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Nuova notifica"));

        return this.title.getText();
    }

    public NotificationPO cancel() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.cancelButton));

        this.cancelButton.click();
        return new NotificationPO(driver);
    }
}

