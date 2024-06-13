package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationPO extends PageObject {

    @FindBy(xpath = "//span[text()='Notifiche']")
    private WebElement title;

    public NotificationPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return this.title.getText();
    }
}

