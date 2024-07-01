package PO.figma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupEditPO extends PageObject {

    @FindBy(xpath = "//span[text()='Dettaglio gruppo']")
    private WebElement title;

    @FindBy(linkText = "SALVA")
    private WebElement saveButton;

    private final WebDriverWait wait;

    public GroupEditPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getTitle() {
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.title, "Dettaglio gruppo"));

        return this.title.getText();
    }

    public GroupsPO save() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.saveButton));

        this.saveButton.click();
        return new GroupsPO(driver);
    }
}

