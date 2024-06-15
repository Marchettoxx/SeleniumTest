package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupsPO extends PageObject {

    @FindBy(linkText = "NUOVO GRUPPO")
    private WebElement newGroupButton;

    @FindBy(linkText = "Gruppo Compliance 231 (ristretto)")
    private WebElement detailLink;

    public GroupsPO(WebDriver driver) {
        super(driver);
    }

    public String getGroupText() {
        return this.detailLink.getText();
    }

    public DetailGroupPO clickDetailGroup() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.detailLink));

        this.detailLink.click();
        return new DetailGroupPO(driver);
    }
}

