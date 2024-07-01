package PO.figma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationDetailPO extends PageObject {

    @FindBy(linkText = "MODIFICA")
    private WebElement editButton;

    @FindBy(linkText = "Configurazione")
    private WebElement notificationLink;

    @FindBy(xpath = "//span[text()='[Descrizione notifica]']")
    private WebElement title;

    private final WebDriverWait wait;

    public NotificationDetailPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "[Descrizione notifica]"));

        return this.title.getText();
    }

    public NotificationEditPO edit() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.editButton));

        this.editButton.click();
        return new NotificationEditPO(driver);
    }

    public NotificationPO back() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.notificationLink));

        this.notificationLink.click();
        return new NotificationPO(driver);
    }
}

