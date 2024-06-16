package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserDetailPO extends PageObject {

    @FindBy(xpath = "//span[text()='[Cognome nome]']")
    private WebElement title;

    public UserDetailPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return this.title.getText();
    }
}

