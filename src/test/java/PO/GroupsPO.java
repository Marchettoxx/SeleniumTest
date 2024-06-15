package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        this.detailLink.click();
        return new DetailGroupPO(driver);
    }
}

