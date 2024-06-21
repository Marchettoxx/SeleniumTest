package PO.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationCreatePO extends PageObject {

    @FindBy(linkText = "CONFERMA")
    private WebElement confirmButton;

    @FindBy(xpath = "//span[text()='Nuova notifica']")
    private WebElement title;

    public NotificationCreatePO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return this.title.getText();
    }

    public NotificationPO confirm() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.confirmButton));

        this.confirmButton.click();
        return new NotificationPO(driver);
    }
}

