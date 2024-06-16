package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationPO extends PageObject {

    @FindBy(xpath = "//span[text()='Notifiche']")
    private WebElement title;

    @FindBy(linkText = "Nuova notifica")
    private WebElement createNotificationButton;

    @FindBy(linkText = "Regola di notifica 2")
    private WebElement detailNotificationLink;

    public NotificationPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(this.title));

        return this.title.getText();
    }

    public NotificationCreatePO createNotification() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.createNotificationButton));

        this.createNotificationButton.click();
        return new NotificationCreatePO(driver);
    }

    public NotificationDetailPO clickDetail() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.detailNotificationLink));

        this.detailNotificationLink.click();
        return new NotificationDetailPO(driver);
    }
}

