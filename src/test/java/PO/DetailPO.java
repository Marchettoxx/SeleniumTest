package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailPO extends PageObject {

    @FindBy(xpath = "//span[text()='[Nome comunicazione]']")
    private WebElement title;

    public DetailPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return this.title.getText();
    }
}

