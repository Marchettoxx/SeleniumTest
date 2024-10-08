package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationDetailPO extends PageObject {

    @FindBy(xpath = "//span[contains(text(), 'MODIFICA')]")
    private WebElement editButton;

    @FindBy(xpath = "//span[contains(text(), 'Configurazione')]")
    private WebElement notificationLink;

    @FindBy(xpath = "//div[text()='Regola di notifica 2']")
    private WebElement title;

    private final WebDriverWait wait;

    public NotificationDetailPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Regola di notifica 2"));

        return this.title.getText();
    }

    public NotificationEditPO edit() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.editButton));

        this.editButton.click();
        return new NotificationEditPO(driver);
    }

    public NotificationPO back() {
        driver.manage().window().maximize();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.notificationLink));

        this.notificationLink.click();
        return new NotificationPO(driver);
    }
}

