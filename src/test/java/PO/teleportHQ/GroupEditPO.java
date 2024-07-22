package PO.teleportHQ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupEditPO extends PageObject {

    @FindBy(xpath = "//span[text()='Dettaglio gruppo']")
    private WebElement title;

    @FindBy(xpath = "//span[text()='ANNULLA']")
    private WebElement cancelButton;

    private final WebDriverWait wait;

    public GroupEditPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Dettaglio gruppo"));

        return this.title.getText();
    }

    public GroupDetailPO cancel() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.cancelButton));

        this.cancelButton.click();
        return new GroupDetailPO(driver);
    }
}

