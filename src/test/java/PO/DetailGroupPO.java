package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailGroupPO extends PageObject {

    @FindBy(xpath = "//span[text()='[Nome gruppo]']")
    private WebElement title;

    public DetailGroupPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return this.title.getText();
    }
}

