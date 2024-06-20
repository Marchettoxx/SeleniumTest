package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupCreatePO extends PageObject {

    @FindBy(xpath = "//span[text()='Nuovo gruppo']")
    private WebElement title;

    @FindBy(linkText = "ANNULLA")
    private WebElement cancelButton;

    public GroupCreatePO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return this.title.getText();
    }

    public GroupsPO cancel() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.cancelButton));

        this.cancelButton.click();
        return new GroupsPO(driver);
    }
}

