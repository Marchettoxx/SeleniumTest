package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationEditPO extends PageObject {

    @FindBy(xpath = "//div[text()='Dettaglio notifica']")
    private WebElement title;

    @FindBy(xpath = "//span[contains(text(), 'ANNULLA')]")
    private WebElement cancelButton;

    private final WebDriverWait wait;

    public NotificationEditPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Dettaglio notifica"));

        return this.title.getText();
    }

    public NotificationDetailPO cancel() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.cancelButton));

        this.cancelButton.click();
        return new NotificationDetailPO(driver);
    }
}

