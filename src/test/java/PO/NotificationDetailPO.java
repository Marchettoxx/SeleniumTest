package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationDetailPO extends PageObject {

    @FindBy(linkText = "MODIFICA")
    private WebElement editButton;

    @FindBy(xpath = "//span[text()='[Descrizione notifica]']")
    private WebElement title;

    public NotificationDetailPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return this.title.getText();
    }

    public NotificationEditPO edit() {
        this.editButton.click();
        return new NotificationEditPO(driver);
    }
}

