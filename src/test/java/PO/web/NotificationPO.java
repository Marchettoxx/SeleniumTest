package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationPO extends PageObject {

    @FindBy(xpath = "//span[text()='Notifiche']")
    private WebElement title;

    @FindBy(xpath = "//span[@class='k-button-text' and contains(text(), 'Nuova notifica')]")
    private WebElement createNotificationButton;

    @FindBy(xpath = "//div[@class='bb-ellipsis' and @title='Test' and contains(text(), 'Test')]")
    private WebElement detailNotificationLink;

    @FindBy(xpath = "//span[contains(text(), 'Presa visione')]")
    private WebElement ackTab;

    private final WebDriverWait wait;

    public NotificationPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Notifiche"));

        return this.title.getText();
    }

    public NotificationCreatePO createNotification() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.createNotificationButton));

        this.createNotificationButton.click();
        return new NotificationCreatePO(driver);
    }

    public NotificationDetailPO clickDetail() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.detailNotificationLink));

        Actions actions = new Actions(driver);
        actions.doubleClick(this.detailNotificationLink).perform();
        return new NotificationDetailPO(driver);
    }

    public ConfigurationPO backToCommunication() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.ackTab));

        this.ackTab.click();
        return new ConfigurationPO(driver);
    }
}

