package PO.figma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationEditPO extends PageObject {

    @FindBy(xpath = "//span[text()='SALVA']")
    private WebElement saveButton;

    private final WebDriverWait wait;

    public NotificationEditPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getSaveButtonText() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.saveButton));

        return this.saveButton.getText();
    }

    public NotificationDetailPO save() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.saveButton));

        this.saveButton.click();
        return new NotificationDetailPO(driver);
    }
}

